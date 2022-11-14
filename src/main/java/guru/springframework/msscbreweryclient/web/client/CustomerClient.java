package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.BeerDto;
import guru.springframework.msscbreweryclient.web.model.CustomerDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
public class CustomerClient {

    public static final String CUSTOMER_PATH_V1 = "/api/v1/customer/";
    private final String apiHost;

    private final RestTemplate restTemplate;

    public CustomerClient(@Value("${sfg.brewery.apihost}") String apiHost, RestTemplateBuilder restTemplateBuilder){

        this.restTemplate = restTemplateBuilder.build();
        this.apiHost = apiHost;
    }
    public CustomerDto getCustomerById(UUID uuid){
        return restTemplate.getForObject(this.apiHost + CUSTOMER_PATH_V1 + uuid, CustomerDto.class);
    }
    public URI saveNewCustomer(CustomerDto dto){
        return restTemplate.postForLocation(this.apiHost + CUSTOMER_PATH_V1, dto);
    }
    public void updateCustomer(UUID uuid, CustomerDto dto){
        restTemplate.put(this.apiHost + CUSTOMER_PATH_V1 + "/" + uuid, dto);
    }

    public void deleteCustomer(UUID uuid){
        restTemplate.delete(this.apiHost + CUSTOMER_PATH_V1 + "/" + uuid);
    }

}
