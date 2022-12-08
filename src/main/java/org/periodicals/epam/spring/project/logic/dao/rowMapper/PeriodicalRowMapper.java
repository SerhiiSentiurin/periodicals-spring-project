package org.periodicals.epam.spring.project.logic.dao.rowMapper;

import org.periodicals.epam.spring.project.logic.entity.Periodical;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class PeriodicalRowMapper implements RowMapper<Periodical> {
    @Override
    public Periodical mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Periodical periodical = new Periodical();
        periodical.setId(resultSet.getLong("periodical.id"));
        periodical.setName(resultSet.getString("name"));
        periodical.setTopic(resultSet.getString("topic"));
        periodical.setCost(resultSet.getDouble("cost"));
        periodical.setDescription(resultSet.getString("description"));
        periodical.setIsDeleted(resultSet.getBoolean("isDeleted"));
        return periodical;
    }
}
