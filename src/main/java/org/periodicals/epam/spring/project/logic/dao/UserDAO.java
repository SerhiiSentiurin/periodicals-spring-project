package org.periodicals.epam.spring.project.logic.dao;

import lombok.RequiredArgsConstructor;
import org.periodicals.epam.spring.project.logic.dao.resultSetExtractor.UserResultSetExtractor;
import org.periodicals.epam.spring.project.logic.entity.User;
import org.periodicals.epam.spring.project.logic.entity.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserDAO {

    private final JdbcTemplate jdbcTemplate;
    private final UserResultSetExtractor userResultSetExtractor;

    public Optional<User> getUserByLogin(UserDto userDto) {
        String getUserByLogin = "SELECT * FROM user WHERE login=?";
        return jdbcTemplate.query(getUserByLogin, preparedStatement -> preparedStatement.setString(1, userDto.getLogin()), userResultSetExtractor);
    }
}
