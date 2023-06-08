package kodlama.io.ecommerce.business.abstracts;

import kodlama.io.ecommerce.business.dto.requests.create.CreateInvoiceRequest;
import kodlama.io.ecommerce.business.dto.requests.update.UpdateInvoiceRequest;
import kodlama.io.ecommerce.business.dto.responses.create.CreateInvoiceResponse;
import kodlama.io.ecommerce.business.dto.responses.get.GetAllnvoicesResponse;
import kodlama.io.ecommerce.business.dto.responses.get.GetInvoiceResponse;
import kodlama.io.ecommerce.business.dto.responses.update.UpdateInvoiceResponse;

import java.util.List;


public interface InvoiceService {
    List<GetAllnvoicesResponse> getAll();
    GetInvoiceResponse getById(int id);
    CreateInvoiceResponse add(CreateInvoiceRequest request);
    UpdateInvoiceResponse update(int id, UpdateInvoiceRequest request);
    void delete(int id);

}
