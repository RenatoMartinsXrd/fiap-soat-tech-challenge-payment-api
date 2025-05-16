package com.hexagonalarch.shared.config;

import com.hexagonalarch.adapters.controllers.PaymentController;
import com.hexagonalarch.core.ports.gateways.*;
import com.hexagonalarch.core.ports.usecases.Payment.CreatePaymentUseCasePort;
import com.hexagonalarch.core.ports.usecases.Payment.GetPaymentByOrderUseCasePort;
import com.hexagonalarch.core.ports.usecases.Payment.PaymentWebhookUseCasePort;
import com.hexagonalarch.core.ports.usecases.Payment.UpdatePaymentStatusUseCasePort;
import com.hexagonalarch.core.usecases.Payment.CreatePaymentUseCase;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

//    @Bean
//    public PaymentController paymentController(PaymentWebhookUseCasePort paymentWebhookUseCasePort,
//                                               CreatePaymentUseCasePort createPaymentUseCasePort,
//                                               GetPaymentByOrderUseCasePort getPaymentByOrderUseCasePort,
//                                               UpdatePaymentStatusUseCasePort updatePaymentStatusUseCasePort){
//        return new PaymentController(paymentWebhookUseCasePort, createPaymentUseCasePort, getPaymentByOrderUseCasePort, updatePaymentStatusUseCasePort);
//    }

    @Bean
    public PaymentController paymentController(
                                               CreatePaymentUseCasePort createPaymentUseCasePort){
        return new PaymentController(createPaymentUseCasePort);
    }

    @Bean
    public CreatePaymentUseCasePort createPaymentUseCasePort(PaymentGatewayPort paymentGatewayPort){
        return new CreatePaymentUseCase(paymentGatewayPort);
    }

//    @Bean
//    public UpdatePaymentStatusUseCasePort updatePaymentStatusUseCasePort(PaymentWebhookUseCase paymentWebhookUseCase, OrderPaymentGatewayPort orderPaymentGatewayPort){
//        return new UpdatePaymentStatusUseCase(orderPaymentGatewayPort, paymentWebhookUseCase);
//    }
//
//    @Bean
//    public GetPaymentByOrderUseCasePort getPaymentByOrderUseCasePort( PaymentGatewayPort paymentGatewayPort, OrderPaymentGatewayPort orderPaymentGatewayPort){
//        return new GetPaymentByOrderUseCase(paymentGatewayPort, orderPaymentGatewayPort);
//    }
//
//    @Bean
//    public PaymentWebhookUseCasePort paymentWebhookUseCasePort(OrderPaymentGatewayPort paymentGatewayPort, OrderGatewayPort orderGatewayPort) {
//        return new PaymentWebhookUseCase(paymentGatewayPort, orderGatewayPort);
//    }
}
