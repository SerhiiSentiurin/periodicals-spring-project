package org.periodicals.epam.spring.project.logic.dao;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.periodicals.epam.spring.project.logic.dao.resultSetExtractor.AccountResultSetExtractor;
import org.periodicals.epam.spring.project.logic.entity.Account;
import org.periodicals.epam.spring.project.logic.entity.dto.AccountDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
@Log4j2
@RequiredArgsConstructor
public class AccountDAO {
    private final JdbcTemplate jdbcTemplate;
    private final AccountResultSetExtractor accountResultSetExtractor;

    public void topUpAccountAmount(AccountDTO dto) {
        String sql = "UPDATE account INNER JOIN reader ON account.id = reader.account_id SET account.amount = ? WHERE reader.id = ?";
        jdbcTemplate.update(sql, ps -> {
            ps.setDouble(1, dto.getAmountOfMoney() + getAmountOfMoneyByReaderId(dto));
            ps.setLong(2, dto.getReaderId());
        });
    }

    public Double getAmountOfMoneyByReaderId(AccountDTO dto) {
        String selectAccountAmount = "SELECT * FROM account JOIN reader ON reader.account_id = account.id WHERE reader.id = ?";
        Account account = jdbcTemplate.query(selectAccountAmount, ps -> {
            ps.setLong(1, dto.getReaderId());
        }, accountResultSetExtractor);
        assert account != null;
        return account.getAmountOfMoney();
    }
}
