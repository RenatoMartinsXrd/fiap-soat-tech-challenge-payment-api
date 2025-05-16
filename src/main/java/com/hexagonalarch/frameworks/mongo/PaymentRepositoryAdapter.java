package com.hexagonalarch.frameworks.mongo;

import com.hexagonalarch.core.domain.Payment;
import com.hexagonalarch.core.ports.gateways.PaymentGatewayPort;
import com.hexagonalarch.frameworks.mongo.entity.PaymentDocument;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

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
    public Payment getPaymentByOrderId(Payment order) {
        return null;
    }

    @Override
    public Payment updatePaymentStatus(Payment orderPayment) {
        return null;
    }
}
