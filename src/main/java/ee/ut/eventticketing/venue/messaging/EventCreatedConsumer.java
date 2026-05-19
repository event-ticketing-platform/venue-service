package ee.ut.eventticketing.venue.messaging;

import ee.ut.eventticketing.venue.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class EventCreatedConsumer {

    @RabbitListener(queues = RabbitMQConfig.EVENT_CREATED_QUEUE)
    public void consumeEventCreated(String message) {
        System.out.println("Venue Service received async message: " + message);
    }
}