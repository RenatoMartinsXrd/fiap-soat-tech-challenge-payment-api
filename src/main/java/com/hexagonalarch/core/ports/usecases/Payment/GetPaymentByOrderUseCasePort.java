package com.hexagonalarch.core.ports.usecases.Payment;

import com.hexagonalarch.core.domain.Payment;

public interface GetPaymentByOrderUseCasePort {
    Payment getPaymentByOrderId(Long orderId);
}
