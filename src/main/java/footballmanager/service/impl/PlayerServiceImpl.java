package footballmanager.service.impl;

import footballmanager.dao.PlayerDao;
import footballmanager.exception.DataProcessingException;
import footballmanager.model.Player;
import footballmanager.model.Team;
import footballmanager.service.PlayerService;
import footballmanager.service.TeamService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PlayerServiceImpl implements PlayerService {
    private final PlayerDao dao;
    private final TeamService teamService;

    public PlayerServiceImpl(PlayerDao dao, TeamService teamService) {
        this.dao = dao;
        this.teamService = teamService;
    }

    @Override
    public Player add(Player player) {
        return dao.save(player);
    }

    @Override
    public Player get(Long id) {
        return dao.findById(id).orElseThrow(
                () -> new DataProcessingException("Can't get player by id " + id));
    }

    @Override
    public Player update(Player player) {
        return dao.save(player);
    }

    @Override
    public void delete(Long id) {
        dao.deleteById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Player transfer(Long fromTeamId, Long toTeamId, Long playerId) {
        if (fromTeamId == toTeamId) {
            throw new DataProcessingException("Command IDs are incorrect");
        }
        Player player = get(playerId);
        Team from = teamService.get(fromTeamId);
        Team to = teamService.get(toTeamId);
        if (!player.getTeam().equals(from)) {
            throw new DataProcessingException("The player does not belong to this team");
        }
        BigDecimal price = BigDecimal
                .valueOf(player.getExperience())
                .multiply(BigDecimal.valueOf(100000))
                .divide(BigDecimal.valueOf(player.getAge()));
        price = price.add(price.multiply(BigDecimal.valueOf(from.getCommission()))
                .divide(BigDecimal.valueOf(100L), RoundingMode.HALF_UP));
        if (to.getBudget().compareTo(price) < 0) {
            throw new DataProcessingException(""
                    + "The team does not have enough money to buy a player");
        }
        from.setBudget(from.getBudget().add(price));
        to.setBudget(to.getBudget().subtract(price));
        player.setTeam(to);
        teamService.update(from);
        teamService.update(to);
        return dao.save(player);
    }
}
