package com.rd.project.dao;

import com.rd.project.config.db.DSConfig;
import com.rd.project.mapper.OrderItemRowMapper;
import com.rd.project.mapper.OrderRowMapper;
import com.rd.project.model.Order;
import com.rd.project.model.OrderItem;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderDAO {
    private static final JdbcTemplate jdbcTemplate;
    private static final OrderRowMapper orderRowMapper;
    private static final DataSource dataSource;

    static  {
        dataSource = DSConfig.getDataSource();
        jdbcTemplate = new JdbcTemplate(dataSource);
        orderRowMapper = new OrderRowMapper();
    }

    public Order getOrderById(int id) {
        String query = "SELECT * FROM orders WHERE id = ?";
        Order order = jdbcTemplate.queryForObject(query, orderRowMapper, id);
        if (order != null) {
            List<OrderItem> orderItems = getOrderItemsByOrderId(order.getId());
            order.setOrderItems(orderItems);
        }
        return order;
    }

    private List<OrderItem> getOrderItemsByOrderId(int orderId) {
        String query = "SELECT * FROM order_items WHERE order_id = ?";
        return jdbcTemplate.query(query, new OrderItemRowMapper(), orderId);
    }

    public int createOrder(Order order) {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("orders")
                .usingGeneratedKeyColumns("id");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("user_id", order.getUserId());
        parameters.put("order_date", Timestamp.valueOf(order.getOrderDate()));
        parameters.put("delivery_address", order.getDeliveryAddress());

        Number generatedId = simpleJdbcInsert.executeAndReturnKey(parameters);

        return generatedId != null ? generatedId.intValue() : -1;
    }
}
