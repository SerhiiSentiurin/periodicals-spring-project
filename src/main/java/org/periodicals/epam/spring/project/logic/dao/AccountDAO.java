package org.periodicals.epam.spring.project.logic.dao;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.periodicals.epam.spring.project.logic.dao.rowMapper.AccountRowMapper;
import org.periodicals.epam.spring.project.logic.entity.Account;
import org.periodicals.epam.spring.project.logic.entity.dto.AccountDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
@Log4j2
@RequiredArgsConstructor
public class AccountDAO {
    private final JdbcTemplate jdbcTemplate;
    private final AccountRowMapper accountRowMapper;

    public void topUpAccountAmount(AccountDTO dto) {
        String sql = "UPDATE account INNER JOIN reader ON account.id = reader.account_id SET account.amount = ? WHERE reader.id = ?";
        jdbcTemplate.update(sql, dto.getAmountOfMoney() + getAmountOfMoneyByReaderId(dto), dto.getReaderId());
    }

    public Double getAmountOfMoneyByReaderId(AccountDTO dto) {
        String selectAccountAmount = "SELECT * FROM account JOIN reader ON reader.account_id = account.id WHERE reader.id = ?";
        Account account = jdbcTemplate.queryForObject(selectAccountAmount,accountRowMapper,dto.getReaderId());
        assert account != null;
        return account.getAmountOfMoney();
    }
}
