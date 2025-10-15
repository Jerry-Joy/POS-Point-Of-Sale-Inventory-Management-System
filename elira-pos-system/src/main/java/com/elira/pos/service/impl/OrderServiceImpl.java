package com.elira.pos.service.impl;

import com.elira.pos.domain.OrderStatus;
import com.elira.pos.domain.PaymentType;
import com.elira.pos.mapper.OrderMapper;
import com.elira.pos.modal.*;
import com.elira.pos.payload.dto.OrderDTO;
import com.elira.pos.repository.CustomerRepository;
import com.elira.pos.repository.OrderItemRepository;
import com.elira.pos.repository.OrderRepository;
import com.elira.pos.repository.ProductRepository;
import com.elira.pos.service.OrderService;
import com.elira.pos.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final UserService userService;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final CustomerRepository customerRepository;

    @Override
    public OrderDTO createOrder(OrderDTO orderDTO) throws Exception {
        User cashier = userService.getCurrentUser();

        Branch branch = cashier.getBranch();
        if (branch == null) {
            throw new Exception("Cashier's branch not found");
        }

        Customer customer = null;
        if (orderDTO.getCustomerId() != null) {
            customer = customerRepository.findById(orderDTO.getCustomerId())
                    .orElseThrow(() -> new EntityNotFoundException("Customer not found"));
        } else if (orderDTO.getCustomer() != null) {
            customer = customerRepository.save(orderDTO.getCustomer());
        }

        Order order = Order.builder()
                .branch(branch)
                .cashier(cashier)
                .customer(customer)
                .paymentType(orderDTO.getPaymentType())
                .build();

        List<OrderItem> orderItems = orderDTO.getItems().stream().map(
                itemDTO -> {
                    Product product = productRepository.findById(itemDTO.getProductId())
                            .orElseThrow(() -> new EntityNotFoundException("Product not found"));

                    return OrderItem.builder()
                            .product(product)
                            .quantity(itemDTO.getQuantity())
                            .price(product.getSellingPrice()* itemDTO.getQuantity())
                            .order(order)
                            .build();
                }
        ).toList();
        double totalAmount = orderItems.stream().mapToDouble(
                OrderItem::getPrice
        ).sum();
        order.setTotalAmount(totalAmount);
        order.setItems(orderItems);

        Order savedOrder = orderRepository.save(order);
        return OrderMapper.toDTO(savedOrder);
    }

    @Override
    public OrderDTO getOrderById(Long id) throws Exception {
        return orderRepository.findById(id)
                .map(OrderMapper::toDTO)
                .orElseThrow(
                () -> new Exception("Order not found with id" + id)
        );
    }

    @Override
    public List<OrderDTO> getOrdersByBranch(Long branchId,
                                            Long customerId,
                                            Long cashierId,
                                            PaymentType paymentType,
                                            OrderStatus status) throws Exception {
        return orderRepository.findByBranchId(branchId)
                .stream()
                .filter(order -> customerId == null ||
                        (order.getCustomer() != null &&
                                order.getCustomer().equals(customerId)))
                .filter(order -> cashierId == null ||
                        order.getCashier() != null &&
                        order.getCashier().getId().equals(cashierId))
                .filter(order -> paymentType == null ||
                        order.getPaymentType()==(paymentType)) //Added ) here
                .map(OrderMapper::toDTO).collect(Collectors.toList());


    }

    @Override
    public List<OrderDTO> getOrderByCashier(Long cashierId) {
        return orderRepository.findByCashierId(cashierId)
                .stream()
                .map(OrderMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteOrder(Long id) throws Exception {
    Order order = orderRepository.findById(id)
            .orElseThrow(() -> new Exception("Order not found with id" + id)
            );
    orderRepository.delete(order);
    }

    @Override
    public List<OrderDTO> getTodayOrdersByBranch(Long branchId) throws Exception {
        LocalDate today = LocalDate.now();
        LocalDateTime start = today.atStartOfDay();
        LocalDateTime end = today.plusDays(1).atStartOfDay();

        return orderRepository.findByBranchIdAndCreatedAtBetween(
                branchId, start, end
                ).stream().map(
                        OrderMapper::toDTO
                ).collect(Collectors.toList());
    }

    @Override
    public List<OrderDTO> getOrdersByCustomerId(Long customerId) throws Exception {
        return orderRepository.findByCustomerId(customerId)
                .stream().map(
                OrderMapper::toDTO
        ).collect(Collectors.toList());
    }

    @Override
    public List<OrderDTO> getTop5RecentOrdersByBranchId(Long branchId) throws Exception {
        return orderRepository.findTop5ByBranchIdOrderByCreatedAtDesc(branchId)
                .stream().map(
                        OrderMapper::toDTO
                ).collect(Collectors.toList());
    }
}
