package com.ivoronline.springboot_kafka_provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

  @Autowired KafkaTemplate<String, String> kafkaTemplate;

  @RequestMapping("SendMessage")
  public String sendMessage(@RequestParam("message") String message) {
    kafkaTemplate.send("Topic1", message);
    return "Sent: " + message;
  }

}