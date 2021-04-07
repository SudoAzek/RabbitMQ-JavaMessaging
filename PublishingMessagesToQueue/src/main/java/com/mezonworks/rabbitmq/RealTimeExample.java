package com.mezonworks.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.json.JSONObject;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RealTimeExample {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("from_date", "2021-04-07");
        jsonObject.put("to_date", "2021-08-01");
        jsonObject.put("email", "sudoazek@gmail.com");
        jsonObject.put("query", "select * from data");

        channel.basicPublish("", "Queue-1", null, jsonObject.toString().getBytes());
        channel.close();
        connection.close();
    }
}
