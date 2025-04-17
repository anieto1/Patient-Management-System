package com.pm.billing_service.grpc;

import org.slf4j.LoggerFactory;

import com.pm.billing.BillingRequest;
import com.pm.billing.BillingResponse;
import com.pm.billing.BillingServiceGrpc.BillingServiceImplBase;

import ch.qos.logback.classic.Logger;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class BillingGrpcService extends BillingServiceImplBase{

    private static final Logger log = (Logger) LoggerFactory.getLogger(BillingGrpcService.class);

    @Override
    public void createBillingAccount(BillingRequest billingRequest, StreamObserver<BillingResponse> responseObserver){
        // Log the incoming request details for debugging/monitoring
        log.info("createBillingAccount request recieved{}", billingRequest.toString());

        // TODO: Implement business logic
        // - Validate request data
        // - Create account record in database
        // - Generate unique account ID
        // - Set up payment methods
        // - Initialize account status

        // For now, return a mock response with hardcoded values
        BillingResponse response = BillingResponse.newBuilder()
        .setAccountId("12345") // Placeholder account ID
        .setStatus("Active")   // Default initial status
        .build();

        // Send the response back to the client
        responseObserver.onNext(response);
        
        // Mark the RPC call as completed
        responseObserver.onCompleted();
    }
    
    
}
