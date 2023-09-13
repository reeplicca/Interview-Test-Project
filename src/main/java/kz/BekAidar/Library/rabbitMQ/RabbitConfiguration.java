package kz.BekAidar.Library.rabbitMQ;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfiguration {
    Logger logger = LoggerFactory.getLogger(RabbitConfiguration.class);

    @Bean
    public ConnectionFactory connectionFactory() {
        return new CachingConnectionFactory("localhost");
    }

    @Bean
    public AmqpAdmin amqpAdmin() {
        return new RabbitAdmin(connectionFactory());
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        return new RabbitTemplate(connectionFactory());
    }

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

    @Bean
    public FanoutExchange fanoutExchangeUser() {
        return new FanoutExchange("add-user");
    }

    @Bean
    public FanoutExchange fanoutExchangeBook() {
        return new FanoutExchange("add-book");
    }

    @Bean
    public FanoutExchange fanoutExchangeLibrary() {
        return new FanoutExchange("add-library");
    }

    @Bean
    public Binding bindingUser() {
        return BindingBuilder.bind(myQueueUser()).to((fanoutExchangeUser()));
    }

    @Bean
    public Binding bindingBook() {
        return BindingBuilder.bind(myQueueBook()).to((fanoutExchangeBook()));
    }

    @Bean
    public Binding bindingLibrary() {
        return BindingBuilder.bind(myQueueLibrary()).to((fanoutExchangeLibrary()));
    }
}
