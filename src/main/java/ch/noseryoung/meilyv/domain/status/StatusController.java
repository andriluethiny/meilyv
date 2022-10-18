package ch.noseryoung.meilyv.domain.status;

import ch.noseryoung.meilyv.domain.status.dto.StatusDTO;
import ch.noseryoung.meilyv.domain.status.dto.StatusMapper;
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
@RequestMapping("/status")
public class StatusController {
    private final StatusService statusService;

    private final StatusMapper statusMapper;

    @Autowired
    public StatusController(StatusService statusService, StatusMapper statusMapper) {
        this.statusService = statusService;
        this.statusMapper = statusMapper;
    }

    @GetMapping({"", "/"})
    @PreAuthorize("hasAuthority('STATUS_READ')")
    public @ResponseBody ResponseEntity<List<StatusDTO>> findAll() {
        List<Status> statuses = statusService.findAll();
        return new ResponseEntity<>(statusMapper.toDTOs(statuses), HttpStatus.OK);
    }

    @GetMapping("/{pageNr}/{pageSz}")
    @PreAuthorize("hasAuthority('STATUS_READ')")
    public @ResponseBody ResponseEntity<List<StatusDTO>> findAllByPages(@PathVariable("pageNr") Integer pageNr, @PathVariable("pageSz") Integer pageSz) {
        List<Status> statuses = statusService.findAll(PageRequest.of(pageNr, pageSz));
        return new ResponseEntity<>(statusMapper.toDTOs(statuses), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('STATUS_READ')")
    public ResponseEntity<StatusDTO> findById(@PathVariable UUID id) {
        Status status = statusService.findById(id);
        return new ResponseEntity<>(statusMapper.toDTO(status), HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('STATUS_WRITE')")
    public ResponseEntity<StatusDTO> save(@Valid @RequestBody StatusDTO statusDTO) {
        Status status = statusService.save(statusMapper.fromDTO(statusDTO));
        return new ResponseEntity<>(statusMapper.toDTO(status), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('STATUS_UPDATE')")
    public ResponseEntity<StatusDTO> updateById(@PathVariable UUID id, @Valid @RequestBody StatusDTO statusDTO) {
        Status status = statusService.updateById(id, statusMapper.fromDTO(statusDTO));
        return new ResponseEntity<>(statusMapper.toDTO(status), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('STATUS_DELETE')")
    public ResponseEntity<Void> deleteById(@PathVariable UUID id) {
        statusService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}