package org.periodicals.epam.spring.project.logic.dao.resultSetExtractor;

import org.periodicals.epam.spring.project.logic.entity.Periodical;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class PeriodicalResultSetExtractor implements ResultSetExtractor<Periodical> {
    @Override
    public Periodical extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        Periodical periodical = new Periodical();
        if (resultSet.next()) {
            periodical.setId(resultSet.getLong("id"));
            periodical.setName(resultSet.getString("name"));
            periodical.setTopic(resultSet.getString("topic"));
            periodical.setCost(resultSet.getDouble("cost"));
            periodical.setDescription(resultSet.getString("description"));
            periodical.setIsDeleted(resultSet.getBoolean("isDeleted"));
        }
        return periodical;
    }
}
