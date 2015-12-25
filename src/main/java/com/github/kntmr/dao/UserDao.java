package com.github.kntmr.dao;

import com.github.kntmr.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<User> findAll() {
        return jdbcTemplate.query("SELECT * FROM users;",
                (rs, rowNum) -> new User(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getInt("age")));
    }

    public User find(long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM users WHERE id=?;",
                (rs, rowNum) -> new User(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getInt("age")), id);
    }

    public long insert(User user) {
        return jdbcTemplate.queryForObject("INSERT INTO users (name, age) VALUES (?, ?) RETURNING id;",
                Long.class, user.getName(), user.getAge());
    }

    public int update(User user) {
        return jdbcTemplate.update("UPDATE users SET (name, age) = (?, ?) WHERE id=?;",
                user.getName(), user.getAge(), user.getId());
    }

    public int delete(long id) {
        return jdbcTemplate.update("DELETE FROM users WHERE id=?", id);
    }

}
