package sk.com.ecommerce.payment_service.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @PostMapping("/process")
    public String processPayment(@RequestParam Long orderId) {
        System.out.println("Processing payment for Order ID: " + orderId);
        return "PAYMENT SUCCESS FOR ORDER " + orderId;
    }
}
