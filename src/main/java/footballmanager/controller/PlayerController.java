package footballmanager.controller;

import footballmanager.dto.request.PlayerRequest;
import footballmanager.dto.response.PlayerResponse;
import footballmanager.model.Player;
import footballmanager.service.PlayerService;
import footballmanager.service.mapper.PlayerMapper;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/players")
public class PlayerController {
    private final PlayerService service;
    private final PlayerMapper mapper;

    public PlayerController(PlayerService service, PlayerMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public PlayerResponse add(@RequestBody @Validated PlayerRequest dto) {
        return mapper.mapToDto(service.add(mapper.mapToModel(dto)));
    }

    @GetMapping("/{id}")
    public PlayerResponse get(@PathVariable Long id) {
        return mapper.mapToDto(service.get(id));
    }

    @PutMapping("/{id}")
    public PlayerResponse update(@PathVariable Long id, @RequestBody @Validated PlayerRequest dto) {
        Player player = mapper.mapToModel(dto);
        player.setId(id);
        return mapper.mapToDto(service.update(player));
    }

    @PutMapping
    public PlayerResponse transfer(@RequestParam Long fromTeamId,
                                   @RequestParam Long toTeamId,
                                   @RequestParam Long playerId) {
        return mapper.mapToDto(service.transfer(fromTeamId, toTeamId, playerId));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
