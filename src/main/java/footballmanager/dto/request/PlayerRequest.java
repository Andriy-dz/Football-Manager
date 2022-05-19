package footballmanager.dto.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class PlayerRequest {
    @Size(min = 2, message = "Name must be longer than 2 characters")
    private String name;
    @Min(value = 15, message = "Age must be greater than 15")
    private Integer age;
    @NotNull(message = "Experience should not be null")
    private Integer experience;
    @Min(value = 0, message = "TeamId must be greater than 0")
    private Long teamId;
}
