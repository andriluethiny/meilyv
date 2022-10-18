package ch.noseryoung.meilyv.unit;

import ch.noseryoung.meilyv.domain.country.Country;
import ch.noseryoung.meilyv.domain.country.CountryRepository;
import ch.noseryoung.meilyv.domain.country.CountryServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CountryServiceImplUnitTests {
    @InjectMocks
    private CountryServiceImpl countryService;

    @Mock
    private CountryRepository countryRepository;

    private Country dummyCountry;

    private List<Country> dummyCountries;

    @BeforeEach
    public void setUp() {
        dummyCountries = Stream.of(new Country(UUID.randomUUID(), "Schweiz", "CH"), new Country(UUID.randomUUID(), "Deutschland", "DE"), new Country(UUID.randomUUID(), "Frankreich", "FR")).collect(Collectors.toList());
        dummyCountry = dummyCountries.get(0);
    }

    @Test
    public void findAll_requestAllCountries_expectCountries() {
        given(countryRepository.findAll()).willReturn(dummyCountries);

        assertThat(countryService.findAll()).usingRecursiveComparison().isEqualTo(dummyCountries);

        verify(countryRepository, times(1)).findAll();
    }

    @Test
    public void findById_requestCountryById_expectCountry() {
        given(countryRepository.findById(any(UUID.class))).will(invocation -> {
            if ("non-existent".equals(invocation.getArgument(0)))
                throw new NoSuchElementException("No such product present");
            return Optional.ofNullable(dummyCountry);
        });

        assertThat(countryService.findById(dummyCountry.getId())).usingRecursiveComparison().isEqualTo(dummyCountry);

        ArgumentCaptor<UUID> productArgumentCaptor = ArgumentCaptor.forClass(UUID.class);
        verify(countryRepository, times(1)).findById(productArgumentCaptor.capture());
        assertThat(productArgumentCaptor.getValue()).isEqualTo(dummyCountry.getId());
    }

    @Test
    public void deleteById_requestDeletionOfCountryById_expectAppropriateState() {
        doNothing().when(countryRepository).deleteById(any(UUID.class));
        given(countryRepository.existsById(any(UUID.class))).willReturn(true);

        assertThat(countryService.deleteById(dummyCountry.getId())).isNull();

        ArgumentCaptor<UUID> countryArgumentCaptor = ArgumentCaptor.forClass(UUID.class);
        verify(countryRepository, times(1)).deleteById(countryArgumentCaptor.capture());
    }
}