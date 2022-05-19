package footballmanager.service.mapper;

import footballmanager.dto.request.TeamRequest;
import footballmanager.dto.response.TeamResponse;
import footballmanager.model.Team;
import org.springframework.stereotype.Component;

@Component
public class TeamMapper implements RequestDtoMapper<Team, TeamRequest>,
        ResponseDtoMapper<Team, TeamResponse> {
    @Override
    public Team mapToModel(TeamRequest dto) {
        Team team = new Team();
        team.setName(dto.getName());
        team.setCommission(dto.getCommission());
        team.setBudget(dto.getBudget());
        return team;
    }

    @Override
    public TeamResponse mapToDto(Team team) {
        TeamResponse response = new TeamResponse();
        response.setId(team.getId());
        response.setName(team.getName());
        response.setCommission(team.getCommission());
        response.setBudget(team.getBudget());
        return response;
    }
}
