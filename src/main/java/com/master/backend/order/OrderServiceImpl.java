package com.master.backend.order;

import com.master.backend.orderItem.OrderItem;
import com.master.backend.product.Product;
import com.master.backend.product.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;


    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> getOrderById(int id) {
        return orderRepository.findById(id);
    }

    @Override
    public Order createOrder(Order order) {
        for (OrderItem orderItem : order.getOrderItems()) {
            Product product = productRepository.findById(orderItem.getProduct().getId())
                    .orElseThrow(() -> new EntityNotFoundException("Product not found"));

            if (product.getQuantity() < orderItem.getQuantity()) {
                throw new IllegalArgumentException("Insufficient quantity for product: " + product.getName());
            }

            // Decrement the quantity of the product
            int remainingQuantity = product.getQuantity() - orderItem.getQuantity();
            product.setQuantity(remainingQuantity);
            productRepository.save(product);
        }

        return orderRepository.save(order);
    }


    @Override
    public Order updateOrder(Order order) {
        return orderRepository.save(order);
    }


    @Override
    public void deleteOrder(int id) {
        orderRepository.deleteById(id);
    }
}
