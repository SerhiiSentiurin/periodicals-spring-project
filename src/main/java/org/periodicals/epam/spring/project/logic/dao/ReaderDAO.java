package org.periodicals.epam.spring.project.logic.dao;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.periodicals.epam.spring.project.infra.web.exception.ApplicationException;
import org.periodicals.epam.spring.project.logic.dao.rowMapper.ReaderRowMapper;
import org.periodicals.epam.spring.project.logic.entity.Reader;
import org.periodicals.epam.spring.project.logic.entity.dto.ReaderCreateDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Objects;
import java.util.Optional;

@Log4j2
@Repository
@RequiredArgsConstructor
public class ReaderDAO {
    private final JdbcTemplate jdbcTemplate;
    private final ReaderRowMapper readerRowMapper;

    public Optional<Reader> getReaderById(Long id) {
        String getReaderById = "SELECT user.id, user.login, reader.account_id, reader.lock, account.amount FROM user JOIN reader ON user.id = reader.id JOIN account ON reader.account_id = account.id WHERE user.id = ?";
        return Optional.ofNullable(jdbcTemplate.queryForObject(getReaderById,readerRowMapper, id));
    }

    @Transactional
    public void insertReader(ReaderCreateDTO readerCreateDTO) {
        String insertIntoUser = "INSERT INTO user (login, password, role) VALUES (?,?,?)";
        String insertIntoAccount = "INSERT INTO account (amount) VALUE (0)";
        String insertIntoReader = "INSERT INTO READER (id,account_id) values (?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        try {
            jdbcTemplate.update(connection -> {
                PreparedStatement preparedStatement = connection.prepareStatement(insertIntoUser, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, readerCreateDTO.getLogin());
                preparedStatement.setString(2, readerCreateDTO.getPassword());
                preparedStatement.setString(3, readerCreateDTO.getUserRole().toString());
                return preparedStatement;
            }, keyHolder);

            long newUserId = Objects.requireNonNull(keyHolder.getKey()).longValue();
            jdbcTemplate.update(con -> con.prepareStatement(insertIntoAccount, Statement.RETURN_GENERATED_KEYS), keyHolder);
            long newUserAccountId = keyHolder.getKey().longValue();
            jdbcTemplate.update(insertIntoReader, ps -> {
                ps.setLong(1, newUserId);
                ps.setLong(2, newUserAccountId);
            });
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ApplicationException("Cannot create reader! Try to insert another login or password");
        }
    }
}
