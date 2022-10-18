package ch.noseryoung.meilyv.domain.authority;

import ch.noseryoung.meilyv.domain.authority.dto.AuthorityDTO;
import ch.noseryoung.meilyv.domain.authority.dto.AuthorityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/authorities")
public class AuthorityController {
    private final AuthorityService authorityService;

    private final AuthorityMapper authorityMapper;

    @Autowired
    public AuthorityController(AuthorityService authorityService, AuthorityMapper authorityMapper) {
        this.authorityService = authorityService;
        this.authorityMapper = authorityMapper;
    }

    @GetMapping({"", "/"})
    @PreAuthorize("hasAuthority('AUTHORIZATION_READ')")
    public @ResponseBody ResponseEntity<List<AuthorityDTO>> findAll() {
        List<Authority> authorities = authorityService.findAll();
        return new ResponseEntity<>(authorityMapper.toDTOs(authorities), HttpStatus.OK);
    }

    @GetMapping("/{pageNr}/{pageSz}")
    @PreAuthorize("hasAuthority('AUTHORIZATION_READ')")
    public @ResponseBody ResponseEntity<List<AuthorityDTO>> findAllByPages(@PathVariable("pageNr") Integer pageNr, @PathVariable("pageSz") Integer pageSz) {
        List<Authority> authorities = authorityService.findAll(PageRequest.of(pageNr, pageSz));
        return new ResponseEntity<>(authorityMapper.toDTOs(authorities), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('AUTHORIZATION_READ')")
    public ResponseEntity<AuthorityDTO> findById(@PathVariable UUID id) {
        Authority authority = authorityService.findById(id);
        return new ResponseEntity<>(authorityMapper.toDTO(authority), HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('AUTHORIZATION_WRITE')")
    public ResponseEntity<AuthorityDTO> save(@Validated @RequestBody AuthorityDTO authorityDTO) {
        Authority authority = authorityService.save(authorityMapper.fromDTO(authorityDTO));
        return new ResponseEntity<>(authorityMapper.toDTO(authority), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('AUTHORIZATION_UPDATE')")
    public ResponseEntity<AuthorityDTO> updateById(@PathVariable UUID id, @Validated @RequestBody AuthorityDTO authorityDTO) {
        Authority authority = authorityService.updateById(id, authorityMapper.fromDTO(authorityDTO));
        return new ResponseEntity<>(authorityMapper.toDTO(authority), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('AUTHORIZATION_DELETE')")
    public ResponseEntity<Void> deleteById(@PathVariable UUID id) {
        authorityService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}