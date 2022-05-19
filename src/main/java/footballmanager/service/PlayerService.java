package footballmanager.service;

import footballmanager.model.Player;

public interface PlayerService {
    Player add(Player player);

    Player get(Long id);

    Player update(Player player);

    void delete(Long id);

    Player transfer(Long fromTeamId, Long toTeamId, Long playerId);
}
