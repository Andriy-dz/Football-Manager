package footballmanager.dto.response;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class TeamResponse {
    private Long id;
    private String name;
    private Integer commission;
    private BigDecimal budget;
}
