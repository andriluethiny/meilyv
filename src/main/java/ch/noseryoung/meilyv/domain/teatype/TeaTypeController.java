package ch.noseryoung.meilyv.domain.teatype;

import ch.noseryoung.meilyv.domain.teatype.dto.TeaTypeDTO;
import ch.noseryoung.meilyv.domain.teatype.dto.TeaTypeMapper;
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
@RequestMapping("/teatypes")
public class TeaTypeController {
    private final TeaTypeService teaTypeService;

    private final TeaTypeMapper teaTypeMapper;

    @Autowired
    public TeaTypeController(TeaTypeService teaTypeService, TeaTypeMapper teaTypeMapper) {
        this.teaTypeService = teaTypeService;
        this.teaTypeMapper = teaTypeMapper;
    }

    @GetMapping({"", "/"})
    @PreAuthorize("hasAuthority('TEATYPE_READ')")
    public @ResponseBody ResponseEntity<List<TeaTypeDTO>> findAll() {
        List<TeaType> teaTypes = teaTypeService.findAll();
        return new ResponseEntity<>(teaTypeMapper.toDTOs(teaTypes), HttpStatus.OK);
    }

    @GetMapping("/{pageNr}/{pageSz}")
    @PreAuthorize("hasAuthority('TEATYPE_READ')")
    public @ResponseBody ResponseEntity<List<TeaTypeDTO>> findAllByPages(@PathVariable("pageNr") Integer pageNr, @PathVariable("pageSz") Integer pageSz) {
        List<TeaType> teaTypes = teaTypeService.findAll(PageRequest.of(pageNr, pageSz));
        return new ResponseEntity<>(teaTypeMapper.toDTOs(teaTypes), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('TEATYPE_READ')")
    public ResponseEntity<TeaTypeDTO> findById(@PathVariable UUID id) {
        TeaType teaType = teaTypeService.findById(id);
        return new ResponseEntity<>(teaTypeMapper.toDTO(teaType), HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('TEATYPE_WRITE')")
    public ResponseEntity<TeaTypeDTO> save(@Valid @RequestBody TeaTypeDTO teaTypeDTO) {
        TeaType teaType = teaTypeService.save(teaTypeMapper.fromDTO(teaTypeDTO));
        return new ResponseEntity<>(teaTypeMapper.toDTO(teaType), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('TEATYPE_UPDATE')")
    public ResponseEntity<TeaTypeDTO> updateById(@PathVariable UUID id, @Valid @RequestBody TeaTypeDTO teaTypeDTO) {
        TeaType teaType = teaTypeService.updateById(id, teaTypeMapper.fromDTO(teaTypeDTO));
        return new ResponseEntity<>(teaTypeMapper.toDTO(teaType), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('TEATYPE_DELETE')")
    public ResponseEntity<Void> deleteById(@PathVariable UUID id) {
        teaTypeService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}