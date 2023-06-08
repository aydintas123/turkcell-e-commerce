package kodlama.io.ecommerce.business.dto.requests.create;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateProductRequest {
    private int id;
    @NotNull
    @Size(min = 3, max = 50)
    private String name;
    @Min(1)
    private int quantity;
    @Min(1)
    private double unitPrice;
    @NotNull
    @Size(min = 3, max = 150)
    private String description;

}

