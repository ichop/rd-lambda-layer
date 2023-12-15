package com.rd.project.mapper;

import com.rd.project.model.Order;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderRowMapper implements RowMapper<Order> {
    @Override
    public Order mapRow(ResultSet resultSet, int i) throws SQLException {
        Order order = new Order();
        order.setId(resultSet.getInt("id"));
        order.setUserId(resultSet.getInt("user_id"));
        order.setOrderDate(resultSet.getTimestamp("order_date").toLocalDateTime());
        order.setDeliveryAddress(resultSet.getString("delivery_address"));
        return order;
    }
}