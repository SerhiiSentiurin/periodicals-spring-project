package org.periodicals.epam.spring.project.logic.dao.rowMapper;

import org.periodicals.epam.spring.project.logic.entity.Prepayment;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class PrepaymentRowMapper implements RowMapper<Prepayment> {
    @Override
    public Prepayment mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Prepayment prepayment = new Prepayment();
        prepayment.setId(resultSet.getLong("id"));
        prepayment.setStartDate(resultSet.getString("start_date"));
        prepayment.setDueDate(resultSet.getString("due_date"));
        prepayment.setPeriodicalId(resultSet.getLong("periodical_id"));
        prepayment.setReaderId(resultSet.getLong("reader_id"));
        return prepayment;
    }
}
