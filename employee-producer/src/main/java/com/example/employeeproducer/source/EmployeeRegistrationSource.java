package com.example.employeeproducer.source;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeRegistrationSource {

    @Output("employeeRegistrationChannel")
    MessageChannel employeeRegistration();

}
