package footballmanager.service.impl;

import footballmanager.dao.TeamDao;
import footballmanager.exception.DataProcessingException;
import footballmanager.model.Team;
import footballmanager.service.TeamService;
import org.springframework.stereotype.Service;

@Service
public class TeamServiceImpl implements TeamService {
    private final TeamDao dao;

    public TeamServiceImpl(TeamDao dao) {
        this.dao = dao;
    }

    @Override
    public Team add(Team team) {
        return dao.save(team);
    }

    @Override
    public Team get(Long id) {
        return dao.findById(id).orElseThrow(
                () -> new DataProcessingException("Can't get team by id " + id));
    }

    @Override
    public Team update(Team team) {
        return dao.save(team);
    }

    @Override
    public void delete(Long id) {
        dao.deleteById(id);
    }
}
