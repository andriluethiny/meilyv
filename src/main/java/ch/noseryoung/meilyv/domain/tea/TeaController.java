package ch.noseryoung.meilyv.domain.tea;

import ch.noseryoung.meilyv.domain.tea.dto.TeaDTO;
import ch.noseryoung.meilyv.domain.tea.dto.TeaMapper;
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
@RequestMapping("/teas")
public class TeaController {
    private final TeaService teaService;

    private final TeaMapper teaMapper;

    @Autowired
    public TeaController(TeaService teaService, TeaMapper teaMapper) {
        this.teaService = teaService;
        this.teaMapper = teaMapper;
    }

    @GetMapping({"", "/"})
    @PreAuthorize("hasAuthority('TEA_READ')")
    public @ResponseBody ResponseEntity<List<TeaDTO>> findAll() {
        List<Tea> teas = teaService.findAll();
        return new ResponseEntity<>(teaMapper.toDTOs(teas), HttpStatus.OK);
    }

    @GetMapping("/{pageNr}/{pageSz}")
    @PreAuthorize("hasAuthority('TEA_READ')")
    public @ResponseBody ResponseEntity<List<TeaDTO>> findAllByPages(@PathVariable("pageNr") Integer pageNr, @PathVariable("pageSz") Integer pageSz) {
        List<Tea> teas = teaService.findAll(PageRequest.of(pageNr, pageSz));
        return new ResponseEntity<>(teaMapper.toDTOs(teas), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('TEA_READ')")
    public ResponseEntity<TeaDTO> findById(@PathVariable UUID id) {
        Tea tea = teaService.findById(id);
        return new ResponseEntity<>(teaMapper.toDTO(tea), HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('TEA_WRITE')")
    public ResponseEntity<TeaDTO> save(@Valid @RequestBody TeaDTO teaDTO) {
        Tea tea = teaService.save(teaMapper.fromDTO(teaDTO));
        return new ResponseEntity<>(teaMapper.toDTO(tea), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('TEA_UPDATE')")
    public ResponseEntity<TeaDTO> updateById(@PathVariable UUID id, @Valid @RequestBody TeaDTO teaDTO) {
        Tea tea = teaService.updateById(id, teaMapper.fromDTO(teaDTO));
        return new ResponseEntity<>(teaMapper.toDTO(tea), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('TEA_DELETE')")
    public ResponseEntity<Void> deleteById(@PathVariable UUID id) {
        teaService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}