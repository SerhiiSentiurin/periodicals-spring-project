package org.periodicals.epam.spring.project.logic.dao.rowMapper;

import lombok.RequiredArgsConstructor;
import org.periodicals.epam.spring.project.logic.entity.Reader;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
@RequiredArgsConstructor
public class ReaderRowMapper implements RowMapper<Reader> {
    private final AccountRowMapper accountRowMapper;

    @Override
    public Reader mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Reader reader = new Reader();
        reader.setId(resultSet.getLong("reader.id"));
        reader.setLogin(resultSet.getString("login"));
        reader.setAccount(accountRowMapper.mapRow(resultSet, rowNum));
        reader.setLock(resultSet.getBoolean("lock"));
        return reader;
    }
}
