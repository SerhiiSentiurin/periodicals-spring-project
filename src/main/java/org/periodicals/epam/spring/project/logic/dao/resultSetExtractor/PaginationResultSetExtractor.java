package org.periodicals.epam.spring.project.logic.dao.resultSetExtractor;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.OptionalDouble;

@Component
public class PaginationResultSetExtractor implements ResultSetExtractor<Optional<Double>> {
    @Override
    public Optional<Double> extractData(ResultSet rs) throws SQLException, DataAccessException {
        double rows;
        if (rs.next()){
            return Optional.of(rows = rs.getDouble(1));
        }
        return Optional.of(0.0);
    }
}
