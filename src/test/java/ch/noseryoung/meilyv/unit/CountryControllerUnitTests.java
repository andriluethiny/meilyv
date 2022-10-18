package ch.noseryoung.meilyv.unit;

import ch.noseryoung.meilyv.core.security.helpers.AuthorizationSchemas;
import ch.noseryoung.meilyv.core.security.helpers.JwtProperties;
import ch.noseryoung.meilyv.domain.authority.Authority;
import ch.noseryoung.meilyv.domain.country.Country;
import ch.noseryoung.meilyv.domain.country.CountryService;
import ch.noseryoung.meilyv.domain.role.Role;
import ch.noseryoung.meilyv.domain.user.User;
import ch.noseryoung.meilyv.domain.user.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class CountryControllerUnitTests {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private JwtProperties jwtProperties;

    @MockBean
    private UserService userService;

    @MockBean
    private CountryService countryService;

    private String dummyToken;

    private Country dummyCountry;

    private List<Country> dummyCountries;

    private String generateToken() {
        byte[] keyBytes = Decoders.BASE64.decode(jwtProperties.getSecret());

        return Jwts.builder()
                .setClaims(Map.of("sub", UUID.randomUUID()))
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtProperties.getExpirationMillis()))
                .setIssuer(jwtProperties.getIssuer())
                .signWith(Keys.hmacShaKeyFor(keyBytes))
                .compact();
    }

    @BeforeEach
    public void setUp() {
        dummyToken = generateToken();
        dummyCountries = Stream.of(new Country(UUID.randomUUID(), "Schweiz", "CH"), new Country(UUID.randomUUID(), "Deutschland", "DE"), new Country(UUID.randomUUID(), "Frankreich", "FR")).collect(Collectors.toList());
        dummyCountry = dummyCountries.get(0);
    }

    @Test
    public void findAll_requestAllCountries_expectAllCountriesAsDTOS() throws Exception {
        given(userService.findById(any(UUID.class))).willReturn(new User().setRoles(Set.of(new Role().setAuthorities(Set.of(new Authority().setName("COUNTRY_READ"))))));
        given(countryService.findAll()).willReturn(dummyCountries);

        mvc.perform(MockMvcRequestBuilders
                        .get("/countries")
                        .header(HttpHeaders.AUTHORIZATION, AuthorizationSchemas.BEARER + " " + dummyToken)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(3)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[*].id").value(Matchers.containsInAnyOrder(dummyCountries.get(0).getId().toString(), dummyCountries.get(1).getId().toString(), dummyCountries.get(2).getId().toString())))
                .andExpect(MockMvcResultMatchers.jsonPath("$[*].name").value(Matchers.containsInAnyOrder(dummyCountries.get(0).getName(), dummyCountries.get(1).getName(), dummyCountries.get(2).getName())))
                .andExpect(MockMvcResultMatchers.jsonPath("$[*].code").value(Matchers.containsInAnyOrder(dummyCountries.get(0).getCode(), dummyCountries.get(1).getCode(), dummyCountries.get(2).getCode())));

        verify(countryService, times(1)).findAll();
    }

    @Test
    public void findById_requestCountryById_expectCountryAsDTO() throws Exception {
        given(userService.findById(any(UUID.class))).willReturn(new User().setRoles(Set.of(new Role().setAuthorities(Set.of(new Authority().setName("COUNTRY_READ"))))));
        given(countryService.findById(any(UUID.class))).will(invocation -> {
            if ("non-existent".equals(invocation.getArgument(0)))
                throw new NoSuchElementException("No such country present");
            return dummyCountry;
        });

        mvc.perform(MockMvcRequestBuilders
                        .get("/countries/{id}", dummyCountry.getId())
                        .header(HttpHeaders.AUTHORIZATION, AuthorizationSchemas.BEARER + " " + dummyToken)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(dummyCountry.getId().toString()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(dummyCountry.getName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(dummyCountry.getCode()));

        ArgumentCaptor<UUID> countryArgumentCaptor = ArgumentCaptor.forClass(UUID.class);
        verify(countryService, times(1)).findById(countryArgumentCaptor.capture());
        assertThat(countryArgumentCaptor.getValue()).isEqualTo(dummyCountry.getId());
    }

    @Test
    public void save_requestCountryDTOToBeCreated_expectCreatedCountryAsDTO() throws Exception {
        UUID uuid = UUID.randomUUID();

        given(userService.findById(any(UUID.class))).willReturn(new User().setRoles(Set.of(new Role().setAuthorities(Set.of(new Authority().setName("COUNTRY_WRITE"))))));
        given(countryService.save(any(Country.class))).will(invocation -> {
            if ("non-existent".equals(invocation.getArgument(0))) throw new Exception("Country could not be created");
            return ((Country) invocation.getArgument(0)).setId(uuid);
        });

        mvc.perform(MockMvcRequestBuilders
                        .post("/countries")
                        .header(HttpHeaders.AUTHORIZATION, AuthorizationSchemas.BEARER + " " + dummyToken)
                        .content(new ObjectMapper().writeValueAsString(dummyCountry.setId(null)))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(uuid.toString()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(dummyCountry.getName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(dummyCountry.getCode()));

        ArgumentCaptor<Country> countryArgumentCaptor = ArgumentCaptor.forClass(Country.class);
        verify(countryService, times(1)).save(countryArgumentCaptor.capture());
        assertThat(countryArgumentCaptor.getValue()).usingRecursiveComparison().isEqualTo(dummyCountry.setId(uuid));
    }

    @Test
    public void updateById_requestCountryDTOToBeUpdated_expectUpdatedCountryDTO() throws Exception {
        String updatedCountryName = "Inserted country name successfully";
        String updatedCountryCode = "Inserted country code successfully";

        given(userService.findById(any(UUID.class))).willReturn(new User().setRoles(Set.of(new Role().setAuthorities(Set.of(new Authority().setName("COUNTRY_UPDATE"))))));
        given(countryService.updateById(any(UUID.class), any(Country.class))).will(invocation -> {
            if ("non-existent".equals(invocation.getArgument(0))) throw new Exception("Country could not be updated");
            return ((Country) invocation.getArgument(1)).setId(invocation.getArgument(0)).setName(updatedCountryName).setCode(updatedCountryCode);
        });

        mvc.perform(MockMvcRequestBuilders
                        .put("/countries/" + dummyCountry.getId().toString())
                        .header(HttpHeaders.AUTHORIZATION, AuthorizationSchemas.BEARER + " " + dummyToken)
                        .content(new ObjectMapper().writeValueAsString(dummyCountry))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(dummyCountry.getId().toString()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(updatedCountryName))
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(updatedCountryCode));

        ArgumentCaptor<UUID> countryIdArgumentCaptor = ArgumentCaptor.forClass(UUID.class);
        ArgumentCaptor<Country> countryArgumentCaptor = ArgumentCaptor.forClass(Country.class);
        verify(countryService, times(1)).updateById(countryIdArgumentCaptor.capture(), countryArgumentCaptor.capture());
    }

    @Test
    public void deleteById_requestDeletionOfCountryById_expectAppropriateState() throws Exception {
        given(userService.findById(any(UUID.class))).willReturn(new User().setRoles(Set.of(new Role().setAuthorities(Set.of(new Authority().setName("COUNTRY_DELETE"))))));
        given(countryService.deleteById(any(UUID.class))).will(invocation -> {
            if ("non-existent".equals(invocation.getArgument(0)))
                throw new NoSuchElementException("No such product present");
            return null;
        });

        mvc.perform(MockMvcRequestBuilders
                        .delete("/countries/{id}", dummyCountry.getId())
                        .header(HttpHeaders.AUTHORIZATION, AuthorizationSchemas.BEARER + " " + dummyToken)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNoContent());

        ArgumentCaptor<UUID> productArgumentCaptor = ArgumentCaptor.forClass(UUID.class);
        verify(countryService, times(1)).deleteById(productArgumentCaptor.capture());
        assertThat(productArgumentCaptor.getValue()).isEqualTo(dummyCountry.getId());
    }
}