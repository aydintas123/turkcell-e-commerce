package kodlama.io.ecommerce.business.concretes;

import kodlama.io.ecommerce.business.abstracts.InvoiceService;
import kodlama.io.ecommerce.business.dto.requests.create.CreateInvoiceRequest;
import kodlama.io.ecommerce.business.dto.requests.update.UpdateInvoiceRequest;
import kodlama.io.ecommerce.business.dto.responses.create.CreateInvoiceResponse;
import kodlama.io.ecommerce.business.dto.responses.get.GetAllnvoicesResponse;
import kodlama.io.ecommerce.business.dto.responses.get.GetInvoiceResponse;
import kodlama.io.ecommerce.business.dto.responses.update.UpdateInvoiceResponse;
import kodlama.io.ecommerce.entities.Invoice;
import kodlama.io.ecommerce.repository.InvoiceRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class InvoiceManager implements InvoiceService {
    private final InvoiceRepository repository;
    private final ModelMapper mapper;

    @Override
    public List<GetAllnvoicesResponse> getAll() {
        List<Invoice> invoices = repository.findAll();
        List<GetAllnvoicesResponse> responses = invoices
                .stream()
                .map(invoice -> mapper.map(invoice, GetAllnvoicesResponse.class))
                .toList();

        return responses;
    }

    @Override
    public GetInvoiceResponse getById(int id) {
        Invoice invoice = repository.findById(id).orElseThrow();
        GetInvoiceResponse response = mapper.map(invoice, GetInvoiceResponse.class);

        return response;
    }

    @Override
    public CreateInvoiceResponse add(CreateInvoiceRequest request) {
        Invoice invoice = mapper.map(request, Invoice.class);
        invoice.setId(0);
        repository.save(invoice);
        CreateInvoiceResponse response = mapper.map(invoice, CreateInvoiceResponse.class);
        return response;
    }

    @Override
    public UpdateInvoiceResponse update(int id, UpdateInvoiceRequest request) {
        Invoice invoice = mapper.map(request, Invoice.class);
        invoice.setId(id);
        repository.save(invoice);

        UpdateInvoiceResponse response = mapper.map(invoice, UpdateInvoiceResponse.class);
        return response;
    }


    @Override
    public void delete(int id) {
        repository.deleteById(id);

    }
}
