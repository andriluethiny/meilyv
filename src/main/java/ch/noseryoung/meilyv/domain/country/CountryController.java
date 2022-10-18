package ch.noseryoung.meilyv.domain.country;

import ch.noseryoung.meilyv.domain.country.dto.CountryDTO;
import ch.noseryoung.meilyv.domain.country.dto.CountryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@Validated
@RestController
@RequestMapping("/countries")
public class CountryController {
    private final CountryService countryService;

    private final CountryMapper countryMapper;

    @Autowired
    public CountryController(CountryService countryService, CountryMapper countryMapper) {
        this.countryService = countryService;
        this.countryMapper = countryMapper;
    }

    @GetMapping({"", "/"})
    @PreAuthorize("hasAuthority('COUNTRY_READ')")
    public @ResponseBody ResponseEntity<List<CountryDTO>> findAll() {
        List<Country> countries = countryService.findAll();
        return new ResponseEntity<>(countryMapper.toDTOs(countries), HttpStatus.OK);
    }

    @GetMapping("/{pageNr}/{pageSz}")
    @PreAuthorize("hasAuthority('COUNTRY_READ')")
    public @ResponseBody ResponseEntity<List<CountryDTO>> findAllByPages(@PathVariable("pageNr") Integer pageNr, @PathVariable("pageSz") Integer pageSz) {
        List<Country> countries = countryService.findAll(PageRequest.of(pageNr, pageSz));
        return new ResponseEntity<>(countryMapper.toDTOs(countries), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('COUNTRY_READ')")
    public ResponseEntity<CountryDTO> findById(@PathVariable UUID id) {
        Country country = countryService.findById(id);
        return new ResponseEntity<>(countryMapper.toDTO(country), HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('COUNTRY_WRITE')")
    public ResponseEntity<CountryDTO> save(@Valid @RequestBody CountryDTO countryDTO) {
        Country country = countryService.save(countryMapper.fromDTO(countryDTO));
        return new ResponseEntity<>(countryMapper.toDTO(country), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('COUNTRY_UPDATE')")
    public ResponseEntity<CountryDTO> updateById(@PathVariable UUID id, @Valid @RequestBody CountryDTO countryDTO) {
        Country country = countryService.updateById(id, countryMapper.fromDTO(countryDTO));
        return new ResponseEntity<>(countryMapper.toDTO(country), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('COUNTRY_DELETE')")
    public ResponseEntity<Void> deleteById(@PathVariable UUID id) {
        countryService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}