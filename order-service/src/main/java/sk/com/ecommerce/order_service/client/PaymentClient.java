package sk.com.ecommerce.order_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sk.com.ecommerce.order_service.dto.PaymentResponse;

@FeignClient(name = "PAYMENT-SERVICE")
public interface PaymentClient {

    @PostMapping("/api/payment/process")
    PaymentResponse processPayment(@RequestParam Long orderId);
}

