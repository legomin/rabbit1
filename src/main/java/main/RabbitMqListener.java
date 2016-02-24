package main;

/**
 * Created by Виталий on 30.12.2015.
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Message;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import service.MessageFactory;

import java.io.IOException;

//import org.apache.log4j.Logger;

@EnableRabbit //нужно для активации обработки аннотаций @RabbitListener
@Component
public class RabbitMqListener {
    //Logger logger = Logger.getLogger(RabbitMqListener.class);
    MessageFactory factory = new MessageFactory();
    ObjectMapper mapper = new ObjectMapper();


    @RabbitListener(queues = "queue1")
    public void processQueue1(String message) throws IOException {
        factory.addMessage(mapper.readValue(message, Message.class));

        //logger.info("Received from queue 1: " + message);
    }
}