package edu.iu.habahram.coffeeorder.controllers;

import edu.iu.habahram.coffeeorder.model.OrderData;
import edu.iu.habahram.coffeeorder.model.Receipt;
import edu.iu.habahram.coffeeorder.repository.OrderFileRepository;
import edu.iu.habahram.coffeeorder.repository.OrderRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/orders")
public class OrderController {
    private final OrderRepository orderRepository;
    private final OrderFileRepository orderFileRepository;

    public OrderController(OrderRepository orderRepository, OrderFileRepository orderFileRepository) {
        this.orderRepository = orderRepository;
        this.orderFileRepository = orderFileRepository;
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody OrderData order) {
        try {
            Receipt receipt = orderFileRepository.add(order);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(receipt);
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

}
