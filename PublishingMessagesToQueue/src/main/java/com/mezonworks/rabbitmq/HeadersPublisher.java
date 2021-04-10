package com.mezonworks.rabbitmq;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

public class HeadersPublisher {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        Map<String, Object> headersMap = new HashMap<>();
        headersMap.put("item1", "mobile");
        headersMap.put("item2", "television");

        BasicProperties br = new BasicProperties();
        br = br.builder().headers(headersMap).build();


        String message = "Message for Mobile and TV";
        channel.basicPublish("Headers-Exchange", "", br, message.getBytes());

        channel.close();
        connection.close();
    }
}
