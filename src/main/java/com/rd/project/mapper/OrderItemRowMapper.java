package com.rd.project.mapper;

import com.rd.project.model.OrderItem;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderItemRowMapper implements RowMapper<OrderItem> {
    @Override
    public OrderItem mapRow(ResultSet resultSet, int i) throws SQLException {
        OrderItem orderItem = new OrderItem();
        orderItem.setOrderId(resultSet.getInt("order_id"));
        orderItem.setItemId(resultSet.getInt("item_id"));
        orderItem.setItemAmount(resultSet.getInt("item_amount"));
        return orderItem;
    }
}