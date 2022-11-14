package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.BeerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@ConfigurationProperties(prefix = "sfg.brewery", ignoreUnknownFields = false)
@Component
public class BreweryClient {

    public static final String BEER_PATH_V1 = "/api/v1/beer/";
    private String apiHost;

    private final RestTemplate restTemplate;

    public void setApiHost(String apiHost) {
        this.apiHost = apiHost;
    }

    public BreweryClient(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate = restTemplateBuilder.build();
    }
    public BeerDto getBeerById(UUID uuid){
        return restTemplate.getForObject(this.apiHost + BEER_PATH_V1 + uuid, BeerDto.class);
    }
    public URI saveNewBeer(BeerDto dto){
        return restTemplate.postForLocation(this.apiHost + BEER_PATH_V1, dto);
    }
    public void updateBeer(UUID uuid, BeerDto dto){
        restTemplate.put(this.apiHost + BEER_PATH_V1 + "/" + uuid, dto);
    }

    public void deleteBeer(UUID uuid){
        restTemplate.delete(this.apiHost + BEER_PATH_V1 + "/" + uuid);
    }

}
