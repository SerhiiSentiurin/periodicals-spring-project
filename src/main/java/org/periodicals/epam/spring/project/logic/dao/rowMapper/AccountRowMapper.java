package org.periodicals.epam.spring.project.logic.dao.rowMapper;

import org.periodicals.epam.spring.project.logic.entity.Account;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class AccountRowMapper implements RowMapper<Account> {
    @Override
    public Account mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Account account = new Account();
        account.setId(resultSet.getLong("account_id"));
        account.setAmountOfMoney(resultSet.getDouble("amount"));
        return account;
    }
}
