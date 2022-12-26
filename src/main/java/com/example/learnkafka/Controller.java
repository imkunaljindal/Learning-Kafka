package com.example.learnkafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    KafkaTemplate<String,String> kafkaTemplate;

    @Value("${myapp.topic_name}")
    String topic;


    @PostMapping("/produce")
    public void produceMessage(@RequestParam("msg")String message){
        kafkaTemplate.send(topic,message);
    }
}
