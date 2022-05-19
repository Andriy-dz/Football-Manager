package footballmanager.dto.response;

import lombok.Data;

@Data
public class PlayerResponse {
    private Long id;
    private String name;
    private Integer age;
    private Integer experience;
    private Long teamId;
}
