package com.example.processor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.integration.annotation.Transformer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

@EnableBinding(Processor.class)
@SpringBootApplication
public class ProcessorApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProcessorApplication.class, args);
    }

    @Transformer(inputChannel = Processor.INPUT, outputChannel = Processor.OUTPUT)
    public Object transform(Long date) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(date);
    }

}
