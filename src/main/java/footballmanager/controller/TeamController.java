package footballmanager.controller;

import footballmanager.dto.request.TeamRequest;
import footballmanager.dto.response.TeamResponse;
import footballmanager.model.Team;
import footballmanager.service.TeamService;
import footballmanager.service.mapper.TeamMapper;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teams")
public class TeamController {
    private final TeamService service;
    private final TeamMapper mapper;

    public TeamController(TeamService service, TeamMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public TeamResponse add(@RequestBody @Validated final TeamRequest dto) {
        return mapper.mapToDto(service.add(mapper.mapToModel(dto)));
    }

    @GetMapping("/{id}")
    public TeamResponse get(@PathVariable Long id) {
        return mapper.mapToDto(service.get(id));
    }

    @PutMapping("/{id}")
    public TeamResponse update(@PathVariable Long id, @RequestBody @Validated TeamRequest dto) {
        Team team = mapper.mapToModel(dto);
        team.setId(id);
        return mapper.mapToDto(service.update(team));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
