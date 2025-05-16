//package com.hexagonalarch.core.usecases.Payment;
//
//import com.hexagonalarch.core.domain.Payment;
//import com.hexagonalarch.core.domain.dto.PaymentNotificationDto;
//import com.hexagonalarch.core.domain.enumeration.PaymentStatus;
//import com.hexagonalarch.core.ports.usecases.Payment.UpdatePaymentStatusUseCasePort;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//public class UpdatePaymentStatusUseCase implements UpdatePaymentStatusUseCasePort {
//    private final OrderPaymentGatewayPort orderPaymentGatewayPort;
//    private final PaymentWebhookUseCase paymentWebhookUseCase;
//
//    public UpdatePaymentStatusUseCase(OrderPaymentGatewayPort orderPaymentGatewayPort, PaymentWebhookUseCase paymentWebhookUseCase) {
//        this.orderPaymentGatewayPort = orderPaymentGatewayPort;
//        this.paymentWebhookUseCase = paymentWebhookUseCase;
//    }
//
//    @Override
//    public Payment updateStatusPayment(Long orderId, PaymentStatus paymentStatus) {
//        List<Payment> byOrderId = orderPaymentGatewayPort.findByOrderId(orderId);
//        if(byOrderId.isEmpty()) new RuntimeException("Pagamento não encontrado para a orderId: " + orderId);
//
//        Payment updatedOrderPayment = byOrderId.get(0);
//        updatedOrderPayment.setStatus(paymentStatus);
//        updatedOrderPayment.setCreatedAt(LocalDateTime.now());
//
//
//        orderPaymentGatewayPort.save(updatedOrderPayment);
//        paymentWebhookUseCase.processPaymentWebhook(new PaymentNotificationDto("event", updatedOrderPayment.getOrderId().toString(), "sd", true));
//
//        return updatedOrderPayment;
//    }
//}