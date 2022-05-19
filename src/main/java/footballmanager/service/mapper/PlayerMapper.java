package footballmanager.service.mapper;

import footballmanager.dto.request.PlayerRequest;
import footballmanager.dto.response.PlayerResponse;
import footballmanager.model.Player;
import footballmanager.service.TeamService;
import org.springframework.stereotype.Component;

@Component
public class PlayerMapper implements RequestDtoMapper<Player, PlayerRequest>,
        ResponseDtoMapper<Player, PlayerResponse> {
    private final TeamService teamService;

    public PlayerMapper(TeamService teamService) {
        this.teamService = teamService;
    }

    @Override
    public Player mapToModel(PlayerRequest dto) {
        Player player = new Player();
        player.setName(dto.getName());
        player.setAge(dto.getAge());
        player.setExperience(dto.getExperience());
        player.setTeam(teamService.get(dto.getTeamId()));
        return player;
    }

    @Override
    public PlayerResponse mapToDto(Player player) {
        PlayerResponse response = new PlayerResponse();
        response.setId(player.getId());
        response.setName(player.getName());
        response.setAge(player.getAge());
        response.setExperience(player.getExperience());
        response.setTeamId(player.getTeam().getId());
        return response;
    }
}
