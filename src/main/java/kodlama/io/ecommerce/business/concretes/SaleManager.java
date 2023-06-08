package kodlama.io.ecommerce.business.concretes;

import kodlama.io.ecommerce.business.abstracts.SaleService;
import kodlama.io.ecommerce.business.dto.requests.create.CreateSaleRequest;
import kodlama.io.ecommerce.business.dto.requests.update.UpdateSaleRequest;
import kodlama.io.ecommerce.business.dto.responses.create.CreateSaleResponse;
import kodlama.io.ecommerce.business.dto.responses.get.GetAllSalesResponse;
import kodlama.io.ecommerce.business.dto.responses.get.GetSaleResponse;
import kodlama.io.ecommerce.business.dto.responses.update.UpdateSaleResponse;
import kodlama.io.ecommerce.entities.Sale;
import kodlama.io.ecommerce.repository.SaleRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class SaleManager implements SaleService {
    private SaleRepository repository;
    private ModelMapper mapper;
    @Override
    public List<GetAllSalesResponse> getAll() {
        List<Sale> sales =repository.findAll();
        List<GetAllSalesResponse> responses = sales
                .stream()
                .map(sale -> mapper.map(sale,GetAllSalesResponse.class))
                .toList();

        return responses; 
    }

    @Override
    public GetSaleResponse getById(int id) {
        Sale sale = repository.findById(id).orElseThrow();
        GetSaleResponse response =mapper.map(sale,GetSaleResponse.class);

        return response;
    }

    @Override
    public CreateSaleResponse add(CreateSaleRequest request) {
        Sale sale =mapper.map(request,Sale.class);
        sale.setId(0);
        repository.save(sale);

        CreateSaleResponse response =mapper.map(sale,CreateSaleResponse.class);
        return response;
    }

    @Override
    public UpdateSaleResponse update(int id, UpdateSaleRequest request) {
        Sale sale =mapper.map(request,Sale.class);
        sale.setId(id);
        repository.save(sale);
        UpdateSaleResponse response=mapper.map(sale, UpdateSaleResponse.class);

        return response;
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
