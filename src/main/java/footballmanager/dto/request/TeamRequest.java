package footballmanager.dto.request;

import java.math.BigDecimal;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class TeamRequest {
    @Size(min = 2, message = "Name must be longer than 2 characters")
    private String name;
    @Min(value = 0, message = "The commission must be at least 0")
    @Max(value = 10, message = "The commission should be no more than 10")
    private Integer commission;
    @NotNull(message = "The budget should not be null")
    private BigDecimal budget;
}
