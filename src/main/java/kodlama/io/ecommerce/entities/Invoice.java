package kodlama.io.ecommerce.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import kodlama.io.ecommerce.repository.InvoiceRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "invoices")
public class Invoice extends BaseClass {

    private String description;
    private String totalPrice;

    @OneToOne
    private Sale sale;

}
