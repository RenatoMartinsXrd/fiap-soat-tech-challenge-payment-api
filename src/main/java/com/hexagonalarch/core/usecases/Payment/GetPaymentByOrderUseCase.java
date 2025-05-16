//package com.hexagonalarch.core.usecases.Payment;
//
//import com.hexagonalarch.core.domain.Payment;
//import com.hexagonalarch.core.ports.gateways.PaymentGatewayPort;
//import com.hexagonalarch.core.ports.usecases.Payment.GetPaymentByOrderUseCasePort;
//
//import java.util.List;
//
//public class GetPaymentByOrderUseCase implements GetPaymentByOrderUseCasePort {
//
//    private final PaymentGatewayPort paymentGatewayPort;
//
//    public GetPaymentByOrderUseCase(PaymentGatewayPort mercadoPagoGateway {
//        this.paymentGatewayPort = mercadoPagoGateway;
//    }
//
//    @Override
//    public Payment getPaymentByOrderId(Long orderId) {
//        List<Payment> payments = paymentGatewayPort. findByOrderId(orderId);
//
//        if (payments.isEmpty()) {
//            throw new RuntimeException("Nenhum pagamento encontrado para o pedido: " + orderId);
//        }
//        return payments.get(0);
//    }
//}