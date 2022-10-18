package ch.noseryoung.meilyv.domain.order;

import ch.noseryoung.meilyv.core.exception.IllegalActionException;
import ch.noseryoung.meilyv.core.generic.ExtendedRepository;
import ch.noseryoung.meilyv.core.generic.ExtendedServiceImpl;
import ch.noseryoung.meilyv.domain.ordertea.OrderTea;
import ch.noseryoung.meilyv.domain.rank.Rank;
import ch.noseryoung.meilyv.domain.rank.RankService;
import ch.noseryoung.meilyv.domain.status.StatusService;
import ch.noseryoung.meilyv.domain.tea.TeaService;
import ch.noseryoung.meilyv.domain.user.UserService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl extends ExtendedServiceImpl<Order> implements OrderService {
    private final MessageSource messageSource;

    private final UserService userService;

    private final RankService rankService;

    private final StatusService statusService;

    private final TeaService teaService;

    @Autowired
    public OrderServiceImpl(ExtendedRepository<Order> repository, Logger logger, MessageSource messageSource, UserService userService, RankService rankService, StatusService statusService, TeaService teaService) {
        super(repository, logger);
        this.messageSource = messageSource;
        this.userService = userService;
        this.rankService = rankService;
        this.statusService = statusService;
        this.teaService = teaService;
    }

    @Override
    @Transactional
    public Order createOrder(Order order) {
        Set<OrderTea> detachedPositions = order.getOrderTeas();
        Order cachedOrdering = save(order.setOrderTeas(new HashSet<>()).setUser(userService.findPrincipalUser().user()).setStatus(statusService.findByName("PAID")));
        cachedOrdering.setOrderTeas(detachedPositions.stream().map(p -> p.setOrder(cachedOrdering)).collect(Collectors.toSet()));

        Order order1 = save(cachedOrdering);

        order1.setOrderTeas(order1.getOrderTeas().stream().map(orderTea -> {
            orderTea.setTea(teaService.findById(orderTea.getTea().getId()));
            if (userService.findPrincipalUser().user().getSeeds() < orderTea.getTea().getTeaType().getRank().getSeeds()) {
                throw new IllegalActionException(messageSource.getMessage("exception.illegalaction.isRankHighEnough.message", null, LocaleContextHolder.getLocale()));
            } else if (userService.findPrincipalUser().user().getAge() < orderTea.getTea().getTeaType().getMinAge()) {
                throw new IllegalActionException(messageSource.getMessage("exception.illegalaction.isUserOldEnough.message", null, LocaleContextHolder.getLocale()));
            } else if (order1.getOrderTeas().stream().noneMatch(p -> p.getQuantity() <= orderTea.getTea().getStockNumber())) {
                throw new IllegalActionException(messageSource.getMessage("exception.illegalaction.isStockNumberHighEnough.message", null, LocaleContextHolder.getLocale()));
            } else {
                orderTea.setTea(teaService.findById(orderTea.getTea().getId()));
                return orderTea.setOrder(order1);
            }
        }).collect(Collectors.toSet()));

        float priceWithoutDiscount = order1.getOrderTeas().stream().map(orderTea -> orderTea.getTea().getSelling_price() * orderTea.getQuantity()).reduce(Float::sum).orElseThrow(() -> new IllegalActionException(messageSource.getMessage("exception.illegalaction.text", null, LocaleContextHolder.getLocale())));
        float priceWithDiscount = priceWithoutDiscount - ((priceWithoutDiscount / 10) * userService.findPrincipalUser().user().getRank().getDiscount());
        order1.setPrice(priceWithDiscount);

        float seedsFromPrice = order1.getPrice() / 2;
        order1.getUser().setSeeds((int) seedsFromPrice + order1.getUser().getSeeds());

        Rank rank = rankService.findRankBySeeds(order1.getUser().getSeeds());
        order1.getUser().setRank(rank);

        return save(order1);
    }

    @Override
    public List<Order> findOrdersByUserId() {
        return ((OrderRepository) super.getRepository()).findOrdersByUserId(userService.findPrincipalUser().user().getId());
    }

    public List<Order> findOwnTeaHistory() {
        Optional<List<Order>> optional = ((OrderRepository) super.getRepository()).findOwnTeaHistory(userService.findPrincipalUser().user().getId());
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new NoSuchElementException("No value present");
        }
    }

    public List<Order> findAllTeaHistories() {
        Optional<List<Order>> optional = ((OrderRepository) super.getRepository()).findAllTeaHistories();
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new NoSuchElementException("No value present");
        }
    }

    @Override
    public List<Order> findMostBuyed() {
        Optional<List<Order>> optional = ((OrderRepository) super.getRepository()).findMostBuyed();
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new NoSuchElementException("No value present");
        }
    }
}