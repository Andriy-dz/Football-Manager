package footballmanager.service;

import footballmanager.model.Team;

public interface TeamService {
    Team add(Team team);

    Team get(Long id);

    Team update(Team team);

    void delete(Long id);
}
