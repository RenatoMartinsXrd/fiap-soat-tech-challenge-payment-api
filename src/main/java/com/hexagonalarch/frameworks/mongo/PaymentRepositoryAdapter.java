package com.hexagonalarch.frameworks.mongo;

import com.hexagonalarch.core.domain.Payment;
import com.hexagonalarch.core.ports.gateways.PaymentGatewayPort;
import com.hexagonalarch.frameworks.mongo.entity.PaymentDocument;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class PaymentRepositoryAdapter implements PaymentGatewayPort {
    private final PaymentRepository paymentRepository;
    private final ModelMapper modelMapper;

    @Override
    public Payment generatePayment(Payment payment) {
        PaymentDocument paymentDocument = modelMapper.map(payment, PaymentDocument.class);
        PaymentDocument save = paymentRepository.save(paymentDocument);
        return modelMapper.map(save, Payment.class);
    }

    @Override
    public List<Payment> getPaymentsByOrderId(Long orderId) {
        return paymentRepository.findAllByOrderId(orderId).stream()
                .map(doc -> modelMapper.map(doc, Payment.class))
                .toList();
    }

    @Override
    public Payment updatePaymentStatus(Payment orderPayment) {
        return null;
    }
}
