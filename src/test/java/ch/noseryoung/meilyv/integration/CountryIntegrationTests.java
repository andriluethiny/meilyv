package ch.noseryoung.meilyv.integration;

import ch.noseryoung.meilyv.core.security.helpers.AuthorizationSchemas;
import ch.noseryoung.meilyv.core.security.helpers.JwtProperties;
import ch.noseryoung.meilyv.domain.authority.Authority;
import ch.noseryoung.meilyv.domain.authority.AuthorityRepository;
import ch.noseryoung.meilyv.domain.country.Country;
import ch.noseryoung.meilyv.domain.country.CountryRepository;
import ch.noseryoung.meilyv.domain.rank.Rank;
import ch.noseryoung.meilyv.domain.rank.RankRepository;
import ch.noseryoung.meilyv.domain.role.Role;
import ch.noseryoung.meilyv.domain.role.RoleRepository;
import ch.noseryoung.meilyv.domain.user.User;
import ch.noseryoung.meilyv.domain.user.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.hasSize;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class CountryIntegrationTests {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private JwtProperties jwtProperties;

    @Autowired
    private AuthorityRepository authorityRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private RankRepository rankRepository;

    @Autowired
    private UserRepository userRepository;

    private String generateToken(UUID subject) {
        byte[] keyBytes = Decoders.BASE64.decode(jwtProperties.getSecret());

        return Jwts.builder()
                .setClaims(Map.of("sub", subject))
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtProperties.getExpirationMillis()))
                .setIssuer(jwtProperties.getIssuer())
                .signWith(Keys.hmacShaKeyFor(keyBytes))
                .compact();
    }

    @Autowired
    private CountryRepository countryRepository;

    @Test
    public void findAll_requestAllCountries_expectAllCountriesAsDTOS() throws Exception {
        Authority authority = authorityRepository.saveAndFlush(new Authority().setName("COUNTRY_READ"));
        Role role = roleRepository.saveAndFlush(new Role().setName("ROLE_TESTER").setAuthorities(Set.of(authority)));
        Rank rank = rankRepository.saveAndFlush(new Rank().setName("BRONZE").setSeeds(0).setDiscount(0F));
        User user = userRepository.saveAndFlush(new User().setEmail("test@test.com").setRoles(Set.of(role)).setRank(rank));
        List<Country> dummyCountries = countryRepository.saveAllAndFlush(Stream.of(new Country(UUID.randomUUID(), "Deutschland", "DE"), new Country(UUID.randomUUID(), "Frankreich", "FR")).collect(Collectors.toList()));

        mvc.perform(MockMvcRequestBuilders
                        .get("/countries")
                        .header(HttpHeaders.AUTHORIZATION, AuthorizationSchemas.BEARER + " " + generateToken(user.getId()))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[*].id").value(Matchers.containsInAnyOrder(dummyCountries.get(0).getId().toString(), dummyCountries.get(1).getId().toString())))
                .andExpect(MockMvcResultMatchers.jsonPath("$[*].name").value(Matchers.containsInAnyOrder(dummyCountries.get(0).getName(), dummyCountries.get(1).getName())))
                .andExpect(MockMvcResultMatchers.jsonPath("$[*].code").value(Matchers.containsInAnyOrder(dummyCountries.get(0).getCode(), dummyCountries.get(1).getCode())));
    }

    @Test
    public void findById_requestCountryById_expectCountryAsDTO() throws Exception {
        Authority authority = authorityRepository.saveAndFlush(new Authority().setName("COUNTRY_READ"));
        Role role = roleRepository.saveAndFlush(new Role().setName("ROLE_TESTER").setAuthorities(Set.of(authority)));
        Rank rank = rankRepository.saveAndFlush(new Rank().setName("BRONZE").setSeeds(0).setDiscount(0F));
        User user = userRepository.saveAndFlush(new User().setEmail("test@test.com").setRoles(Set.of(role)).setRank(rank));
        List<Country> dummyCountries = countryRepository.saveAllAndFlush(Stream.of(new Country(UUID.randomUUID(), "Schweiz", "CH"), new Country(UUID.randomUUID(), "Deutschland", "DE"), new Country(UUID.randomUUID(), "Frankreich", "FR")).collect(Collectors.toList()));
        Country dummyCountry = dummyCountries.get(0);

        mvc.perform(MockMvcRequestBuilders
                        .get("/countries/{id}", dummyCountries.get(0).getId())
                        .header(HttpHeaders.AUTHORIZATION, AuthorizationSchemas.BEARER + " " + generateToken(user.getId()))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(dummyCountry.getId().toString()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(dummyCountry.getName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(dummyCountry.getCode()));
    }

    @Test
    public void save_requestCountryDTOToBeCreated_expectCreatedCountryAsDTO() throws Exception {
        Authority authority = authorityRepository.saveAndFlush(new Authority().setName("COUNTRY_WRITE"));
        Role role = roleRepository.saveAndFlush(new Role().setName("ROLE_TESTER").setAuthorities(Set.of(authority)));
        Rank rank = rankRepository.saveAndFlush(new Rank().setName("BRONZE").setSeeds(0).setDiscount(0F));
        User user = userRepository.saveAndFlush(new User().setEmail("test@test.com").setRoles(Set.of(role)).setRank(rank));
        UUID uuid = UUID.randomUUID();
        Country dummyCountry = countryRepository.saveAndFlush(new Country(uuid, "Schweiz", "CH"));

        mvc.perform(MockMvcRequestBuilders
                        .post("/countries")
                        .header(HttpHeaders.AUTHORIZATION, AuthorizationSchemas.BEARER + " " + generateToken(user.getId()))
                        .content(new ObjectMapper().writeValueAsString(dummyCountry.setId(dummyCountry.getId())))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(dummyCountry.getId().toString()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(dummyCountry.getName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(dummyCountry.getCode()));
    }

    @Test
    public void updateById_requestCountryDTOToBeUpdated_expectUpdatedCountryDTO() throws Exception {
        Authority authority = authorityRepository.saveAndFlush(new Authority().setName("COUNTRY_UPDATE"));
        Role role = roleRepository.saveAndFlush(new Role().setName("ROLE_TESTER").setAuthorities(Set.of(authority)));
        Rank rank = rankRepository.saveAndFlush(new Rank().setName("BRONZE").setSeeds(0).setDiscount(0F));
        User user = userRepository.saveAndFlush(new User().setEmail("test@test.com").setRoles(Set.of(role)).setRank(rank));
        Country dummyCountry = countryRepository.saveAndFlush(new Country(UUID.randomUUID(), "Schweiz", "CH"));

        String updatedCountryName = "Schwiz";
        String updatedCountryCode = "CHF";

        mvc.perform(MockMvcRequestBuilders
                        .put("/countries/" + dummyCountry.getId().toString())
                        .header(HttpHeaders.AUTHORIZATION, AuthorizationSchemas.BEARER + " " + generateToken(user.getId()))
                        .content(new ObjectMapper().writeValueAsString(dummyCountry.setName(updatedCountryName).setCode(updatedCountryCode)))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(dummyCountry.getId().toString()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(updatedCountryName))
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(updatedCountryCode));
    }

    @Test
    public void deleteById_requestDeletionOfCountryById_expectAppropriateState() throws Exception {
        Authority authority = authorityRepository.saveAndFlush(new Authority().setName("COUNTRY_DELETE"));
        Role role = roleRepository.saveAndFlush(new Role().setName("ROLE_TESTER").setAuthorities(Set.of(authority)));
        Rank rank = rankRepository.saveAndFlush(new Rank().setName("BRONZE").setSeeds(0).setDiscount(0F));
        User user = userRepository.saveAndFlush(new User().setEmail("test@test.com").setRoles(Set.of(role)).setRank(rank));
        Country dummyCountry = countryRepository.saveAndFlush(new Country(UUID.randomUUID(), "Schweiz", "CH"));

        mvc.perform(MockMvcRequestBuilders
                        .delete("/countries/{id}", dummyCountry.getId())
                        .header(HttpHeaders.AUTHORIZATION, AuthorizationSchemas.BEARER + " " + generateToken(user.getId()))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }
}