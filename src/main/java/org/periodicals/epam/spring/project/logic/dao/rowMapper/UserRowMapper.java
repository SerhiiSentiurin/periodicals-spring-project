//package org.periodicals.epam.spring.project.logic.dao.rowMapper;
//
//import org.periodicals.epam.spring.project.logic.entity.Admin;
//import org.periodicals.epam.spring.project.logic.entity.Reader;
//import org.periodicals.epam.spring.project.logic.entity.User;
//import org.periodicals.epam.spring.project.logic.entity.UserRole;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.stereotype.Component;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.Optional;
//
//@Component
//public class UserRowMapper implements RowMapper<Optional<User>> {
//    @Override
//    public Optional<User> mapRow(ResultSet resultSet, int rowNum) throws SQLException {
//        User foundUser;
//        if (resultSet.next()) {
//            long id = resultSet.getLong("id");
//            String login = resultSet.getString("login");
//            String password = resultSet.getString("password");
//            String role = resultSet.getString("role");
//            if (role.equals("ADMIN")) {
//                foundUser = new Admin();
//                foundUser.setUserRole(UserRole.ADMIN);
//            } else {
//                foundUser = new Reader();
//                foundUser.setUserRole(UserRole.READER);
//            }
//            foundUser.setId(id);
//            foundUser.setLogin(login);
//            foundUser.setPassword(password);
//            return Optional.of(foundUser);
//        }
//        return Optional.empty();
//    }
//}
