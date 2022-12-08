package org.periodicals.epam.spring.project.logic.dao;

import lombok.RequiredArgsConstructor;
import org.periodicals.epam.spring.project.logic.dao.resultSetExtractor.UserResultSetExtractor;
import org.periodicals.epam.spring.project.logic.entity.User;
import org.periodicals.epam.spring.project.logic.entity.dto.UserDto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserDAO {
    private final JdbcTemplate jdbcTemplate;
    private final UserResultSetExtractor userResultSetExtractor;


    public Optional<User> getUserByLogin(UserDto userDto) {
        String getUserByLogin = "SELECT * FROM user WHERE login=?";
        return jdbcTemplate.query(getUserByLogin, ps -> ps.setString(1, userDto.getLogin()), userResultSetExtractor);

    }
}
