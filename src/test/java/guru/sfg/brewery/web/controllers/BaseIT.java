package guru.sfg.brewery.web.controllers;

import guru.sfg.brewery.repositories.BeerInventoryRepository;
import guru.sfg.brewery.repositories.BeerRepository;
import guru.sfg.brewery.repositories.CustomerRepository;
import guru.sfg.brewery.services.BeerService;
import guru.sfg.brewery.services.BreweryService;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;

@WebMvcTest
public class BaseIT {

    @Autowired
    WebApplicationContext wac; // application context in the spring environment -> gives us the spring security filters

    public MockMvc mockMvc;

    @MockBean // creates a spring mock bean in the spring context
    BeerRepository beerRepository;

    @MockBean
    BeerInventoryRepository beerInventoryRepository;

    @MockBean
    BreweryService breweryService;

    @MockBean
    CustomerRepository customerRepository;

    @MockBean
    BeerService beerService;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(wac)
                .apply(springSecurity()) // activates the spring security filters
                .build();
    }
}
