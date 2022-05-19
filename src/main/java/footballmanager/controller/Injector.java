package footballmanager.controller;

import footballmanager.model.Player;
import footballmanager.model.Team;
import footballmanager.service.PlayerService;
import footballmanager.service.TeamService;
import java.math.BigDecimal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inject")
public class Injector {
    private final PlayerService playerService;
    private final TeamService teamService;

    public Injector(PlayerService playerService, TeamService teamService) {
        this.playerService = playerService;
        this.teamService = teamService;
    }

    @PostMapping
    public void inject() {
        Team team = new Team("Динамо", 7, BigDecimal.valueOf(9000000));
        Team team2 = new Team("Десна", 5, BigDecimal.valueOf(8000000));
        teamService.add(team);
        teamService.add(team2);

        Player playerDinamo = new Player("Денис Гармаш", 20, 15, team);
        Player playerDinamo2 = new Player("Олександр Тимчик", 26, 20, team);
        Player playerDinamo3 = new Player("Олександр Сирота", 19, 10, team);
        playerService.add(playerDinamo);
        playerService.add(playerDinamo2);
        playerService.add(playerDinamo3);

        Player playerDesna = new Player("Євгеній Белич", 32, 25, team2);
        Player playerDesna2 = new Player("Євген Селін", 21, 6, team2);
        Player playerDesna3 = new Player("Ігор Литовка", 19, 3, team2);
        playerService.add(playerDesna);
        playerService.add(playerDesna2);
        playerService.add(playerDesna3);
    }
}
