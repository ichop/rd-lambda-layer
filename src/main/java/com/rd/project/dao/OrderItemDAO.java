package com.rd.project.dao;

import com.rd.project.config.db.DSConfig;
import com.rd.project.mapper.OrderItemRowMapper;
import com.rd.project.model.OrderItem;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class OrderItemDAO {
    private static final JdbcTemplate jdbcTemplate;
    private static final OrderItemRowMapper orderItemRowMapper;
    private static final DataSource dataSource;

    static  {
        dataSource = DSConfig.getDataSource();
        jdbcTemplate = new JdbcTemplate(dataSource);
        orderItemRowMapper = new OrderItemRowMapper();
    }

    public List<OrderItem> getOrderItemsByOrderId(int orderId) {
        String query = "SELECT * FROM order_items WHERE order_id = ?";
        return jdbcTemplate.query(query, orderItemRowMapper, orderId);
    }

    public void createOrderItem(OrderItem orderItem) {
        String query = "INSERT INTO order_items (order_id, item_id, item_amount) VALUES (?, ?, ?)";
        jdbcTemplate.update(query, orderItem.getOrderId(), orderItem.getItemId(), orderItem.getItemAmount());
    }

    public void createOrderItems(List<OrderItem> orderItems) {
        String query = "INSERT INTO order_items (order_id, item_id, item_amount) VALUES (?, ?, ?)";
        jdbcTemplate.batchUpdate(query, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                OrderItem orderItem = orderItems.get(i);
                preparedStatement.setInt(1, orderItem.getOrderId());
                preparedStatement.setInt(2, orderItem.getItemId());
                preparedStatement.setInt(3, orderItem.getItemAmount());
            }

            @Override
            public int getBatchSize() {
                return orderItems.size();
            }
        });
    }
}
