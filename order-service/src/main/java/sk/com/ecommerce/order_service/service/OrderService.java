package sk.com.ecommerce.order_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import sk.com.ecommerce.order_service.client.PaymentClient;
import sk.com.ecommerce.order_service.dto.OrderRequest;
import sk.com.ecommerce.order_service.dto.PaymentResponse;
import sk.com.ecommerce.order_service.entity.Order;
import sk.com.ecommerce.order_service.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private PaymentClient paymentClient;

    @CircuitBreaker(name = "paymentService", fallbackMethod = "paymentFallback")
    @Retry(name = "paymentService")
    public Order placeOrder(OrderRequest request) {

        Order order = new Order();
        order.setUserId(request.getUserId());
        order.setProductId(request.getProductId());
        order.setQuantity(request.getQuantity());

        PaymentResponse response =
                paymentClient.processPayment(order.getId());

        order.setStatus(response.getStatus());

        return orderRepository.save(order);
    }

    // Fallback method
    public Order paymentFallback(OrderRequest request, Exception ex) {
        Order order = new Order();
        order.setUserId(request.getUserId());
        order.setProductId(request.getProductId());
        order.setQuantity(request.getQuantity());
        order.setStatus("PAYMENT_FAILED");

        System.out.println("Payment service failed, using fallback: " + ex.getMessage());

        return orderRepository.save(order);
    }
}
