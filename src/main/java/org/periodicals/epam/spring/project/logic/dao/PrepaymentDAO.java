package org.periodicals.epam.spring.project.logic.dao;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.periodicals.epam.spring.project.infra.web.exception.ApplicationException;
import org.periodicals.epam.spring.project.logic.dao.resultSetExtractor.AccountResultSetExtractor;
import org.periodicals.epam.spring.project.logic.dao.resultSetExtractor.PeriodicalResultSetExtractor;
import org.periodicals.epam.spring.project.logic.entity.Account;
import org.periodicals.epam.spring.project.logic.entity.Periodical;
import org.periodicals.epam.spring.project.logic.entity.dto.PrepaymentDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Log4j2
@RequiredArgsConstructor
public class PrepaymentDAO {
    private final JdbcTemplate jdbcTemplate;
    private final PeriodicalResultSetExtractor periodicalResultSetExtractor;
    private final AccountResultSetExtractor accountResultSetExtractor;
    private static final Integer MONTHS_IN_YEAR = 12;
    private static final Integer DAYS_IN_MONTH = 30;
    private static final Double DISCOUNT = 0.9d;

    @Transactional
    public void addSubscription(PrepaymentDTO dto) {
        String addSubscription = "INSERT INTO periodicals (reader_id, periodical_id) VALUES (?,?)";
        String updateAccount = "UPDATE account INNER JOIN reader ON account.id = reader.account_id SET account.amount = ? WHERE reader.id = " + dto.getReaderId();
        String updatePrepayment = "INSERT INTO prepayment (start_date, due_date, periodical_id, reader_id) VALUES (curdate(), adddate(start_date, INTERVAL " + dto.getDurationOfSubscription() + " DAY), " + dto.getPeriodicalId() + ", " + dto.getReaderId() + ");";
        try{
            checkAccountAmount(dto);
            jdbcTemplate.update(addSubscription, ps -> {
                ps.setLong(1, dto.getReaderId());
                ps.setLong(2, dto.getPeriodicalId());
            });
            jdbcTemplate.update(updateAccount, ps -> ps.setDouble(1, dto.getAmountOfMoney()));
            jdbcTemplate.execute(updatePrepayment);
        }catch (Exception e){
            throw new ApplicationException("Cannot add subscription!");
        }

    }

    private void checkAccountAmount(PrepaymentDTO dto) {
        Double costPeerMonth = getPeriodicalCost(dto.getPeriodicalId());
        Double costPeerYear = (getPeriodicalCost(dto.getPeriodicalId()) * MONTHS_IN_YEAR) * DISCOUNT; // with 10% discount
        Double accountBalance = getAmountFromAccount(dto.getReaderId());

        if ((costPeerMonth > accountBalance) && (dto.getDurationOfSubscription() <= DAYS_IN_MONTH)) {
            log.error("reader have not enough money on the account");
            throw new ApplicationException("Not enough money on the account");
        } else if ((costPeerYear > accountBalance) && (dto.getDurationOfSubscription() > DAYS_IN_MONTH)) {
            log.error("reader have not enough money on the account");
            throw new ApplicationException("Not enough money on the account, try to get month subscription or top up your account!");
        } else if (dto.getDurationOfSubscription() > 30) {
            dto.setAmountOfMoney(accountBalance - costPeerYear);
        } else {
            dto.setAmountOfMoney(accountBalance - costPeerMonth);
        }
    }

    @Transactional
    public void deleteSubscription(Long readerId, Long periodicalId) {
        String deleteFromPeriodicals = "DELETE FROM periodicals WHERE reader_id = ? AND periodical_id = ?";
        String deleteFromPrepayments = "DELETE FROM prepayment WHERE reader_id = ? AND periodical_id = ?";
        try {
            jdbcTemplate.update(deleteFromPeriodicals, ps -> {
                ps.setLong(1, readerId);
                ps.setLong(2, periodicalId);
            });
            jdbcTemplate.update(deleteFromPrepayments, ps -> {
                ps.setLong(1, readerId);
                ps.setLong(2, periodicalId);
            });
        }catch (Exception e){
            throw new ApplicationException("Cannot delete subscription");
        }
    }

    private Double getPeriodicalCost(Long periodicalId) {
        String getCost = "SELECT * FROM periodical WHERE id = ?";
        Periodical periodical = jdbcTemplate.query(getCost, ps -> ps.setLong(1, periodicalId), periodicalResultSetExtractor);
        assert periodical != null;
        return periodical.getCost();
    }

    protected Double getAmountFromAccount(Long readerId) {
        String selectAccountAmount = "SELECT * FROM account JOIN reader ON reader.account_id = account.id WHERE reader.id = ?";
        Account readerAccount = jdbcTemplate.query(selectAccountAmount, ps -> ps.setLong(1, readerId), accountResultSetExtractor);
        assert readerAccount != null;
        return readerAccount.getAmountOfMoney();
    }
}
