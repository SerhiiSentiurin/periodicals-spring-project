package org.periodicals.epam.spring.project.logic.dao.resultSetExtractor;

import org.periodicals.epam.spring.project.logic.entity.Account;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class AccountResultSetExtractor implements ResultSetExtractor<Account> {
    @Override
    public Account extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        Account account = new Account();
        if (resultSet.next()){
            account.setId(resultSet.getLong("account_id"));
            account.setAmountOfMoney(resultSet.getDouble("amount"));
        }
        return account;
    }
}
