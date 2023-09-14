package kz.BekAidar.Library.rabbitMQ;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfiguration {
    @Bean
    public Queue myQueueUser() {
        return new Queue("myQueueUser");
    }

    @Bean
    public Queue myQueueBook() {
        return new Queue("myQueueBook");
    }

    @Bean
    public Queue myQueueLibrary() {
        return new Queue("myQueueLibrary");
    }
}
