package com.example.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

    @Autowired
    private RabbitProducer rabbitProducer;

    @GetMapping("/")
    public String name() {
        return "Producer Controller";
    }

    @GetMapping("/send")
    public String send() {

       MyUser user = new MyUser("Poorna", "Jay", 30);
       rabbitProducer.send(user);
       return "Success";
    }
}
