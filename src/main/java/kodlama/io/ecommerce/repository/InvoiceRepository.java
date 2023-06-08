package kodlama.io.ecommerce.repository;

import kodlama.io.ecommerce.entities.Invoice;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


public interface InvoiceRepository extends JpaRepository<Invoice,Integer> {

}
