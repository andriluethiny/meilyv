package ch.noseryoung.meilyv.domain.role;

import ch.noseryoung.meilyv.domain.role.dto.RoleDTO;
import ch.noseryoung.meilyv.domain.role.dto.RoleMapper;
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
@RequestMapping("/roles")
public class RoleController {
    private final RoleService roleService;

    private final RoleMapper roleMapper;

    @Autowired
    public RoleController(RoleService roleService, RoleMapper roleMapper) {
        this.roleService = roleService;
        this.roleMapper = roleMapper;
    }

    @GetMapping({"", "/"})
    @PreAuthorize("hasAuthority('AUTHORIZATION_READ')")
    public @ResponseBody ResponseEntity<List<RoleDTO>> findAll() {
        List<Role> roles = roleService.findAll();
        return new ResponseEntity<>(roleMapper.toDTOs(roles), HttpStatus.OK);
    }

    @GetMapping("/{pageNr}/{pageSz}")
    @PreAuthorize("hasAuthority('AUTHORIZATION_READ')")
    public @ResponseBody ResponseEntity<List<RoleDTO>> findAllByPages(@PathVariable("pageNr") Integer pageNr, @PathVariable("pageSz") Integer pageSz) {
        List<Role> roles = roleService.findAll(PageRequest.of(pageNr, pageSz));
        return new ResponseEntity<>(roleMapper.toDTOs(roles), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('AUTHORIZATION_READ')")
    public ResponseEntity<RoleDTO> findById(@PathVariable UUID id) {
        Role role = roleService.findById(id);
        return new ResponseEntity<>(roleMapper.toDTO(role), HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('AUTHORIZATION_WRITE')")
    public ResponseEntity<RoleDTO> save(@Validated @RequestBody RoleDTO roleDTO) {
        Role role = roleService.save(roleMapper.fromDTO(roleDTO));
        return new ResponseEntity<>(roleMapper.toDTO(role), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('AUTHORIZATION_UPDATE')")
    public ResponseEntity<RoleDTO> updateById(@PathVariable UUID id, @Validated @RequestBody RoleDTO roleDTO) {
        Role role = roleService.updateById(id, roleMapper.fromDTO(roleDTO));
        return new ResponseEntity<>(roleMapper.toDTO(role), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('AUTHORIZATION_DELETE')")
    public ResponseEntity<Void> deleteById(@PathVariable UUID id) {
        roleService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}