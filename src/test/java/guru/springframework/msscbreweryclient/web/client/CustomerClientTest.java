package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.BeerDto;
import guru.springframework.msscbreweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerClientTest {

    @Autowired
    CustomerClient client;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getCustomerById() {
        CustomerDto dto = client.getCustomerById(UUID.randomUUID());
        assertNotNull(dto);
    }

    @Test
    void saveNewCustomer() {
        CustomerDto dto = CustomerDto.builder().name("New CustMo").build();
        URI uri =  client.saveNewCustomer(dto);

        assertNotNull(uri);
    }

    @Test
    void updateCustomer() {
        CustomerDto dto = CustomerDto.builder().name("New CustMo").build();
        client.updateCustomer(UUID.randomUUID(), dto);
    }
    @Test
    void deleteCustomerTest() {
        client.deleteCustomer(UUID.randomUUID());
    }

}