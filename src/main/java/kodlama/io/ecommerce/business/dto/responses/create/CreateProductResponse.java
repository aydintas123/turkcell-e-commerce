package kodlama.io.ecommerce.business.dto.responses.create;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductResponse {

    private int id;
    private String name;
    private int quantity;
    private double unitPrice;
    private String description;
}
