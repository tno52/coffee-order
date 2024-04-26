package edu.iu.habahram.coffeeorder.repository;
import edu.iu.habahram.coffeeorder.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Random;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderFileRepository {

    private static final String DATABASE_NAME = "db.txt";
    private static final String NEW_LINE = System.lineSeparator();

    private static void appendToFile(Path path, String content)
            throws IOException {
        Files.write(path,
                content.getBytes(StandardCharsets.UTF_8),
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND);
    }
    public Receipt add(OrderData order) throws IOException {
        String dataLine = orderToString(order);

        return new Receipt(order.getBeverage(), (float) calculateCost(order), order.getOrderId());
    }
    private String orderToString(OrderData order) {
        return order.getOrderId() + "," + order.getBeverage() + "," + String.join(",", order.getCondiments()) + System.lineSeparator();
    }

    private double calculateCost(OrderData order) {
        return 5.0;
    }



    private OrderData stringToOrder(String line) {
        String[] parts = line.split(",");
        int orderId = Integer.parseInt(parts[0]);
        String beverage = parts[1];
        List<String> condiments = List.of(parts[2].split(";"));
        return new OrderData(orderId, beverage, condiments);
    }




}