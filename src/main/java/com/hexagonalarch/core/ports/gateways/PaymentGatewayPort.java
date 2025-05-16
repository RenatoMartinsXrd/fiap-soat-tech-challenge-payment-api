package com.hexagonalarch.core.ports.gateways;

import com.hexagonalarch.core.domain.Payment;

public interface PaymentGatewayPort {
    Payment generatePayment(Payment payment);
    Payment getPaymentByOrderId(Payment order);
    Payment updatePaymentStatus(Payment orderPayment);
}
