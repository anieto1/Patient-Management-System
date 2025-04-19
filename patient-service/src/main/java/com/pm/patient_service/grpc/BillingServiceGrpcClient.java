package com.pm.patient_service.grpc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.pm.billing.BillingRequest;
import com.pm.billing.BillingResponse;
import com.pm.billing.BillingServiceGrpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

@Service
public class BillingServiceGrpcClient {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(BillingServiceGrpcClient.class);
    private final BillingServiceGrpc.BillingServiceBlockingStub blockingStub;

    public BillingServiceGrpcClient(
        @Value("${billing.service.address:localhost}") String serverAddress,
        @Value("${billing.service.grpc.port:9001}") int serverPort
    ){
        log.info("Connecting to billing service at {}:{}", serverAddress, serverPort);
        ManagedChannel channel = ManagedChannelBuilder.forAddress(serverAddress, serverPort).usePlaintext().build();
        
        blockingStub = BillingServiceGrpc.newBlockingStub(channel);
    }

    public BillingResponse createBillingAccount(String patientId, String name, String email){

        BillingRequest request = BillingRequest.newBuilder().setPatientId(patientId).setName(name).setEmail(email).build();


        BillingResponse response = blockingStub.createBillingAccount(request);

        log.info("recieved response from billing service via GRPC:{}", response);

        return response;
    }
    
}
