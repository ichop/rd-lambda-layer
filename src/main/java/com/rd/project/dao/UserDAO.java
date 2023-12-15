package com.rd.project.dao;

import com.rd.project.config.db.DSConfig;
import com.rd.project.mapper.UserRowMapper;
import com.rd.project.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDAO {
    private static final JdbcTemplate jdbcTemplate;
    private static final UserRowMapper userRowMapper;
    private static final DataSource dataSource;

   static  {
        dataSource = DSConfig.getDataSource();
        jdbcTemplate = new JdbcTemplate(dataSource);
        userRowMapper = new UserRowMapper();
   }


    public List<User> getAllUsers() {
        String query = "SELECT * FROM users";
        return jdbcTemplate.query(query, userRowMapper);
    }

    public boolean doesUserExist(int id) {
        String query = "SELECT EXISTS(SELECT 1 FROM users WHERE id = ?)";
        return jdbcTemplate.queryForObject(query, Boolean.class, id);
    }

    public User getUserById(int id) {
        String query = "SELECT * FROM users WHERE id = ?";
        return jdbcTemplate.queryForObject(query, userRowMapper, id);
    }

    public int createUser(User user) {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("users")
                .usingGeneratedKeyColumns("id");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("email", user.getEmail());
        parameters.put("name", user.getName());
        parameters.put("surname", user.getSurname());
        parameters.put("role", user.getRole());

        Number generatedId = simpleJdbcInsert.executeAndReturnKey(parameters);

        return generatedId != null ? generatedId.intValue() : -1;
    }

    public void updateUser(User user) {
        String query = "UPDATE users SET email = ?, name = ?, surname = ?, role = ? WHERE id = ?";
        jdbcTemplate.update(query, user.getEmail(), user.getName(), user.getSurname(), user.getRole(), user.getId());
    }

    public void deleteUser(int id) {
        String query = "DELETE FROM users WHERE id = ?";
        jdbcTemplate.update(query, id);
    }

}
