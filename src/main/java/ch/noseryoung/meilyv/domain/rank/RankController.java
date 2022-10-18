package ch.noseryoung.meilyv.domain.rank;

import ch.noseryoung.meilyv.domain.rank.dto.RankDTO;
import ch.noseryoung.meilyv.domain.rank.dto.RankMapper;
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
@RequestMapping("/ranks")
public class RankController {
    private final RankService rankService;

    private final RankMapper rankMapper;

    @Autowired
    public RankController(RankService rankService, RankMapper rankMapper) {
        this.rankService = rankService;
        this.rankMapper = rankMapper;
    }

    @GetMapping({"", "/"})
    @PreAuthorize("hasAuthority('RANK_READ')")
    public @ResponseBody ResponseEntity<List<RankDTO>> findAll() {
        List<Rank> statuses = rankService.findAll();
        return new ResponseEntity<>(rankMapper.toDTOs(statuses), HttpStatus.OK);
    }

    @GetMapping("/{pageNr}/{pageSz}")
    @PreAuthorize("hasAuthority('RANK_READ')")
    public @ResponseBody ResponseEntity<List<RankDTO>> findAllByPages(@PathVariable("pageNr") Integer pageNr, @PathVariable("pageSz") Integer pageSz) {
        List<Rank> ranks = rankService.findAll(PageRequest.of(pageNr, pageSz));
        return new ResponseEntity<>(rankMapper.toDTOs(ranks), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('RANK_READ')")
    public ResponseEntity<RankDTO> findById(@PathVariable UUID id) {
        Rank rank= rankService.findById(id);
        return new ResponseEntity<>(rankMapper.toDTO(rank), HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('RANK_WRITE')")
    public ResponseEntity<RankDTO> save(@Valid @RequestBody RankDTO rankDTO) {
        Rank rank = rankService.save(rankMapper.fromDTO(rankDTO));
        return new ResponseEntity<>(rankMapper.toDTO(rank), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('RANK_UPDATE')")
    public ResponseEntity<RankDTO> updateById(@PathVariable UUID id, @Valid @RequestBody RankDTO rankDTO) {
        Rank rank = rankService.updateById(id, rankMapper.fromDTO(rankDTO));
        return new ResponseEntity<>(rankMapper.toDTO(rank), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('RANK_DELETE')")
    public ResponseEntity<Void> deleteById(@PathVariable UUID id) {
        rankService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}