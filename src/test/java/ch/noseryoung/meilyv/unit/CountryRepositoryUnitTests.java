package ch.noseryoung.meilyv.unit;

import ch.noseryoung.meilyv.domain.country.Country;
import ch.noseryoung.meilyv.domain.country.CountryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class CountryRepositoryUnitTests {
    @Autowired
    private CountryRepository countryRepository;

    private Country dummyCountry;

    private List<Country> dummyCountries;

    @BeforeEach
    public void setUp() {
        dummyCountries = countryRepository.saveAllAndFlush((Stream.of(new Country(UUID.randomUUID(), "Schweiz", "CH"), new Country(UUID.randomUUID(), "Deutschland", "DE"), new Country(UUID.randomUUID(), "Frankreich", "FR")).collect(Collectors.toList())));
        dummyCountry = dummyCountries.get(0);
    }

//    @Test
//    public void findAll_requestAllCountries_expectAllCountries() {
//        assertThat(countryRepository.findAll()).usingRecursiveComparison().ignoringCollectionOrder().isEqualTo(dummyCountries);
//    }

    @Test
    public void findById_requestCountryById_expectCountry() {
        assertThat(countryRepository.findById(dummyCountries.get(0).getId())).hasValue(dummyCountries.get(0));
    }

    @Test
    public void save_requestCountryToBeSaved_expectSavedCountry() {
        assertThat(countryRepository.save(dummyCountry).equals(dummyCountry));
    }
}