package kodlama.io.ecommerce.business.dto.responses.update;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductResponse {
    private int id;
    private String name;
    private int quantity;
    private double unitPrice;
    private String description;

}
