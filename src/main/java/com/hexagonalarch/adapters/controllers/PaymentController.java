package com.hexagonalarch.adapters.controllers;

import com.hexagonalarch.core.domain.Payment;
import com.hexagonalarch.core.domain.dto.PaymentNotificationDto;
import com.hexagonalarch.core.domain.enumeration.PaymentStatus;
import com.hexagonalarch.core.ports.usecases.Payment.CreatePaymentUseCasePort;
import com.hexagonalarch.core.ports.usecases.Payment.GetPaymentByOrderUseCasePort;
import com.hexagonalarch.core.ports.usecases.Payment.PaymentWebhookUseCasePort;
import com.hexagonalarch.core.ports.usecases.Payment.UpdatePaymentStatusUseCasePort;

public class PaymentController {
//    private final PaymentWebhookUseCasePort paymentWebhookUseCasePort;
    private final CreatePaymentUseCasePort createPaymentUseCasePort;
//    private final GetPaymentByOrderUseCasePort getPaymentByOrderUseCasePort;
//    private final UpdatePaymentStatusUseCasePort updatePaymentStatusUseCasePort;

//    public PaymentController(PaymentWebhookUseCasePort paymentWebhookUseCasePort, CreatePaymentUseCasePort createPaymentUseCasePort, GetPaymentByOrderUseCasePort paymentByOrderUseCasePort, UpdatePaymentStatusUseCasePort updatePaymentStatusUseCasePort) {
public PaymentController(CreatePaymentUseCasePort createPaymentUseCasePort) {
//        this.paymentWebhookUseCasePort = paymentWebhookUseCasePort;
        this.createPaymentUseCasePort = createPaymentUseCasePort;
//        this.getPaymentByOrderUseCasePort = paymentByOrderUseCasePort;
//        this.updatePaymentStatusUseCasePort = updatePaymentStatusUseCasePort;
    }
//    public void paymentWebhook(PaymentNotificationDto paymentNotificationDto){
//        paymentWebhookUseCasePort.processPaymentWebhook(paymentNotificationDto);
//    }
    public Payment createPayment(Payment payment){
        return createPaymentUseCasePort.createPayment(payment);
    }
//
//    public Payment getPaymentByOrderId(Long orderId){
//        return getPaymentByOrderUseCasePort.getPaymentByOrderId(orderId);
//    }
//
//    public Payment updateStatusPayment(Long orderId, PaymentStatus paymentStatus){
//        return updatePaymentStatusUseCasePort.updateStatusPayment(orderId, paymentStatus);
//    }
}
