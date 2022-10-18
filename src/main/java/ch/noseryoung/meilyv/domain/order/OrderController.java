package ch.noseryoung.meilyv.domain.order;

import ch.noseryoung.meilyv.core.exception.IllegalActionException;
import ch.noseryoung.meilyv.domain.order.dto.OrderDTO;
import ch.noseryoung.meilyv.domain.order.dto.OrderMapper;
import ch.noseryoung.meilyv.domain.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Validated
@RestController
@RequestMapping("/orders")
public class OrderController {
    private final MessageSource messageSource;

    private final OrderService orderService;

    private final OrderMapper orderMapper;

    private final UserService userService;

    @Autowired
    public OrderController(MessageSource messageSource, OrderService orderService, OrderMapper orderMapper, UserService userService) {
        this.messageSource = messageSource;
        this.orderService = orderService;
        this.orderMapper = orderMapper;
        this.userService = userService;
    }

    @GetMapping({"", "/"})
    @PreAuthorize("hasAnyAuthority('ORDER_READ', 'ORDER_READ_OWN')")
    public @ResponseBody ResponseEntity<List<OrderDTO>> findAll() {
        List<Order> orders = null;

        try {
            if (userService.findPrincipalUser().hasAnyAuthority(new HashSet<>(Set.of("ORDER_READ")))) {
                orderService.findAll();
            } else {
                orderService.findOrdersByUserId();
            }
            return new ResponseEntity<>(orderMapper.toDTOs(orders), HttpStatus.OK);
        } catch (Exception ex) {
            throw new IllegalActionException(messageSource.getMessage("exception.illegalaction.isPrincipalAdmin.message", null, LocaleContextHolder.getLocale()));
        }
    }

    @GetMapping("/{pageNr}/{pageSz}")
    @PreAuthorize("hasAnyAuthority('ORDER_READ', 'ORDER_READ_OWN')")
    public @ResponseBody ResponseEntity<List<OrderDTO>> findAllByPages(@PathVariable("pageNr") Integer pageNr, @PathVariable("pageSz") Integer pageSz) {
        List<Order> orders = null;

        try {
            if (userService.findPrincipalUser().hasAnyAuthority(new HashSet<>(Set.of("ORDER_READ")))) {
                orderService.findAll(PageRequest.of(pageNr, pageSz));
            } else {
                orderService.findOrdersByUserId();
            }
            return new ResponseEntity<>(orderMapper.toDTOs(orders), HttpStatus.OK);
        } catch (Exception ex) {
            throw new IllegalActionException(messageSource.getMessage("exception.illegalaction.isPrincipalAdmin.message", null, LocaleContextHolder.getLocale()));
        }
    }

    @GetMapping("/history")
    @PreAuthorize("hasAnyAuthority('ORDER_READ', 'ORDER_READ_OWN')")
    public ResponseEntity<List<OrderDTO>> findTeaHistory() {
        List<Order> orders = null;

        try {
            if (userService.findPrincipalUser().hasAnyAuthority(new HashSet<>(Set.of("ORDER_READ")))) {
                orderService.findAllTeaHistories();
            } else {
                orderService.findOwnTeaHistory();
            }
            return new ResponseEntity<>(orderMapper.toDTOs(orders), HttpStatus.OK);
        } catch (Exception ex) {
            throw new IllegalActionException(messageSource.getMessage("exception.illegalaction.isPrincipalAdmin.message", null, LocaleContextHolder.getLocale()));
        }
    }

//    @GetMapping("/history/{pageNr}/{pageSz}")
//    @PreAuthorize("hasAnyAuthority('ORDER_READ', 'ORDER_READ_OWN')")
//    public @ResponseBody ResponseEntity<List<OrderDTO>> findTeaHistoryByPages(@PathVariable("pageNr") Integer pageNr, @PathVariable("pageSz") Integer pageSz) {
//        List<Order> orders = null;
//
//        try {
//            if(userService.findPrincipalUser().hasAnyAuthority(new HashSet<>(Set.of("ORDER_READ")))) {
//                orderService.findAllTeaHistories(PageRequest.of(pageNr, pageSz));
//            } else {
//                orderService.findOwnTeaHistory();
//            } return new ResponseEntity<>(orderMapper.toDTOs(orders), HttpStatus.OK);
//        } catch (Exception ex) {
//            throw  new IllegalActionException(messageSource.getMessage("exception.illegalaction.isPrincipalAdmin.message", null, LocaleContextHolder.getLocale()));
//        }
//    }

    @GetMapping("/stats/most/buy")
    @PreAuthorize("hasRole('ROLE_ADMIN') || hasAuthority('ORDER_READ_STATS')")
    public ResponseEntity<List<OrderDTO>> findMostBuyed() {
        List<Order> order = orderService.findMostBuyed();
        return new ResponseEntity<>(orderMapper.toDTOs(order), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ORDER_READ')")
    public ResponseEntity<OrderDTO> findById(@PathVariable UUID id) {
        Order order = orderService.findById(id);
        return new ResponseEntity<>(orderMapper.toDTO(order), HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ORDER_WRITE')")
    public ResponseEntity<OrderDTO> createOrder(@Valid @RequestBody OrderDTO orderDTO) {
        Order order = orderService.createOrder(orderMapper.fromDTO(orderDTO));
        return new ResponseEntity<>(orderMapper.toDTO(order), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ORDER_UPDATE')")
    public ResponseEntity<OrderDTO> updateById(@PathVariable UUID id, @Valid @RequestBody OrderDTO orderDTO) {
        Order order = orderService.updateById(id, orderMapper.fromDTO(orderDTO));
        return new ResponseEntity<>(orderMapper.toDTO(order), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ORDER_DELETE')")
    public ResponseEntity<Void> deleteById(@PathVariable UUID id) {
        orderService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}