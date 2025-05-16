package com.hexagonalarch.frameworks.mongo;
import com.hexagonalarch.frameworks.mongo.entity.PaymentDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PaymentRepository extends MongoRepository<PaymentDocument, String> {
}
