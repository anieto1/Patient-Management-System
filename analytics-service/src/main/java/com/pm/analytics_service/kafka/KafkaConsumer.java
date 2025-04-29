package com.pm.analytics_service.kafka;

import com.google.protobuf.InvalidProtocolBufferException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import patient.event.PatientEvent;

@Service
public class KafkaConsumer {
    private static final Logger log = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics="patient", groupId="analytics-service")
    public void consumeEvent(byte[] event){
        try {
            PatientEvent patientEvent = PatientEvent.parseFrom(event);
            log.info("it worked: PatientId={}, patientName={}, patientEmail={}", patientEvent.getPatientId(), patientEvent.getName(), patientEvent.getEmail());
        } catch (InvalidProtocolBufferException e) {
            log.error("error deserializing event{}", e.getMessage());
        }


    }
}

//# Kafka Listener for Patient Events
//This code snippet defines a method that consumes messages from a Kafka topic. Let me break it down:
//## Key Components:
//1. **Annotation`@KafkaListener`**:
//    - This Spring annotation marks the method as a listener for Kafka messages
//    - : Specifies that this method listens to the "patient" topic `topics="patient"`
//    - : Defines the consumer group ID, allowing multiple consumers to coordinate consumption `groupId="analytics-service"`
//
//2. **Method Signature**:
//    - : Receives raw byte arrays from Kafka `consumeEvent(byte[] event)`
//
//3. **Protocol Buffers Deserialization**:
//    - : Attempts to deserialize the binary data using Protocol Buffers `PatientEvent.parseFrom(event)`
//    - Protocol Buffers is Google's language-neutral, platform-neutral mechanism for serializing structured data
//
//4. **Exception Handling**:
//    - Catches that might occur during deserialization `InvalidProtocolBufferException`
//    - Logs the error message using a logger (referred to as ) `log`
//
//## Note:
//The code appears to be incomplete as:
//- There's a closing brace for the class at the end but no visible class definition
//- The deserialized is not used within the method `patientEvent`
//- The logger is used but not shown in the initialization
//
//This method is likely part of a service that processes patient events for analytics purposes, as suggested by the consumer group ID