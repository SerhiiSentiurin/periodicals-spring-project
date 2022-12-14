package org.periodicals.epam.spring.project.logic.dao;

import lombok.RequiredArgsConstructor;
import org.periodicals.epam.spring.project.logic.dao.rowMapper.UserRowMapper;
import org.periodicals.epam.spring.project.logic.entity.User;
import org.periodicals.epam.spring.project.logic.entity.dto.UserDto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserDAO {
    private final JdbcTemplate jdbcTemplate;
    private final UserRowMapper userRowMapper;


    public Optional<User> getUserByLogin(UserDto userDto) {
        String getUserByLogin = "SELECT * FROM user WHERE login = ?";
        return Optional.ofNullable(jdbcTemplate.queryForObject(getUserByLogin,userRowMapper,userDto.getLogin()));

    }
}
