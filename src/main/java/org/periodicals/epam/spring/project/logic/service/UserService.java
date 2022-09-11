package org.periodicals.epam.spring.project.logic.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.periodicals.epam.spring.project.infra.web.exception.ApplicationException;
import org.periodicals.epam.spring.project.logic.dao.UserDAO;
import org.periodicals.epam.spring.project.logic.entity.User;
import org.periodicals.epam.spring.project.logic.entity.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserDAO userDAO;

    public User getUserByLogin(UserDto userDto) {
        log.info("Try to log in user: " + userDto.getLogin());

        User user = userDAO.getUserByLogin(userDto)
                .orElseThrow(() -> new ApplicationException("cannot find user with this login"));

        if (!user.getPassword().equals(userDto.getPassword())) {
            throw new ApplicationException("password is incorrect");
        }
        log.info("user: " + userDto.getLogin() + " was entered");
        return user;
    }
}
