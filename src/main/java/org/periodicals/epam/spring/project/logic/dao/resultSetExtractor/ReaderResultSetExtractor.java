package org.periodicals.epam.spring.project.logic.dao.resultSetExtractor;

import org.periodicals.epam.spring.project.logic.entity.Account;
import org.periodicals.epam.spring.project.logic.entity.Reader;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

@Component
public class ReaderResultSetExtractor implements ResultSetExtractor<Optional<Reader>> {
    @Override
    public Optional<Reader> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        Reader reader = new Reader();
        if (resultSet.next()) {
            long id = resultSet.getLong("id");
            String login = resultSet.getString("login");
            boolean lock = resultSet.getBoolean("lock");
            long accountId = resultSet.getLong("account_id");
            double amountOfMoney = resultSet.getDouble("amount");
            Account account = new Account(accountId, amountOfMoney);
            reader.setId(id);
            reader.setLogin(login);
            reader.setLock(lock);
            reader.setAccount(account);
            return Optional.of(reader);
        }
        return Optional.empty();
    }
}
