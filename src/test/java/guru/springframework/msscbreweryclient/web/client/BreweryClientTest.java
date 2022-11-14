package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.BeerDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient client;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getBeerByIdTest() {
        BeerDto dto = client.getBeerById(UUID.randomUUID());
        assertNotNull(dto);
    }

    @Test
    void saveNewBeerTest() {
        BeerDto dto = BeerDto.builder().beerName("New Beer").build();
        URI uri =  client.saveNewBeer(dto);

        assertNotNull(uri);
    }

    @Test
    void updateBeerTest() {
        BeerDto dto = BeerDto.builder().beerName("New Beer").build();
        client.updateBeer(UUID.randomUUID(), dto);
    }

    @Test
    void deleteBeerTest() {
        client.deleteBeer(UUID.randomUUID());
    }

}