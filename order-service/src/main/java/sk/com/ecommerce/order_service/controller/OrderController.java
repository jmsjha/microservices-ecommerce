package sk.com.ecommerce.order_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import sk.com.ecommerce.order_service.dto.OrderRequest;
import sk.com.ecommerce.order_service.entity.Order;
import sk.com.ecommerce.order_service.service.OrderService;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/place")
    public Order placeOrder(@RequestBody OrderRequest request) {
        return orderService.placeOrder(request);
    }
}

