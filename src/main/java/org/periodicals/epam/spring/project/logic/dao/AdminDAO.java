package org.periodicals.epam.spring.project.logic.dao;

import lombok.AllArgsConstructor;
import org.periodicals.epam.spring.project.logic.dao.resultSetExtractor.PeriodicalResultSetExtractor;
import org.periodicals.epam.spring.project.logic.dao.rowMapper.PeriodicalRowMapper;
import org.periodicals.epam.spring.project.logic.dao.rowMapper.ReaderRowMapper;
import org.periodicals.epam.spring.project.logic.entity.Periodical;
import org.periodicals.epam.spring.project.logic.entity.Reader;
import org.periodicals.epam.spring.project.logic.entity.dto.PeriodicalDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Repository
@AllArgsConstructor
public class AdminDAO {

    private final JdbcTemplate jdbcTemplate;
    private final PeriodicalRowMapper periodicalRowMapper;
    private final ReaderRowMapper readerRowMapper;
    private final PeriodicalResultSetExtractor periodicalResultSetExtractor;

    public List<Periodical> getAllPeriodicals() {
        String sql = "SELECT * FROM periodical ORDER BY id";
        return jdbcTemplate.query(sql, periodicalRowMapper);
    }

    public void createNewPeriodical(PeriodicalDTO dto) {
        String addNewPeriodical = "INSERT INTO periodical (name, topic, cost, description) VALUES (?,?,?,?)";
        jdbcTemplate.update(addNewPeriodical,
                ps -> {
                    ps.setString(1, dto.getName());
                    ps.setString(2, dto.getTopic());
                    ps.setDouble(3, dto.getCost());
                    ps.setString(4, dto.getDescription());
                });
    }

    public void deletePeriodicalByPeriodicalId(Long periodicalId) {
        String deletePeriodical = "DELETE FROM periodical WHERE periodical.id = ?";
        jdbcTemplate.update(deletePeriodical,
                ps -> {
                    ps.setLong(1, periodicalId);
                });
    }

    public void deletePeriodicalForReaders(Long periodicalId) {
        String delPeriodical = "UPDATE periodical SET isDeleted = true WHERE id = ?";
        jdbcTemplate.update(delPeriodical,
                ps -> {
                    ps.setLong(1, periodicalId);
                });
    }

    public void restorePeriodicalForReaders(Long periodicalId) {
        String restorePeriodical = "UPDATE periodical SET isDeleted = false WHERE id = ?";
        jdbcTemplate.update(restorePeriodical,
                ps -> {
                    ps.setLong(1, periodicalId);
                });
    }

    public Periodical getPeriodicalById(Long periodicalId) {
        String getPeriodical = "SELECT * FROM periodical WHERE id = ?";
        return jdbcTemplate.query(getPeriodical,
                ps -> ps.setLong(1, periodicalId), periodicalResultSetExtractor);
    }

    public void editPeriodicalById(PeriodicalDTO dto) {
        String editPeriodical = "UPDATE periodical SET name =?, topic =?, cost =?, description =? WHERE id =?";
        jdbcTemplate.update(editPeriodical,
                ps -> {
                    ps.setString(1, dto.getName());
                    ps.setString(2, dto.getTopic());
                    ps.setDouble(3, dto.getCost());
                    ps.setString(4, dto.getDescription());
                    ps.setLong(5, dto.getPeriodicalId());
                });
    }

    //TODO need to improve
    public Map<Reader, Periodical> getAllReaders() {
        String getAll = "select user.id, login, account.amount, reader.lock, reader.account_id, reader.id, periodical.id, periodical.name, periodical.topic, periodical.cost, periodical.description, periodical.isDeleted from user JOIN reader ON user.id = reader.id JOIN account ON reader.account_id = account.id left join periodicals on user.id=periodicals.reader_id left join periodical on periodicals.periodical_id = periodical.id where not user.role = 'ADMIN' order by user.id";
        Map<Reader, Periodical> map = new LinkedHashMap<>();
        List<Periodical> periodicals = jdbcTemplate.query(getAll, periodicalRowMapper);
        List<Reader> readers = jdbcTemplate.query(getAll, readerRowMapper);
        int i = 0;
        for (Reader reader:readers){

            map.put(reader, periodicals.get(i));
            if (map.containsKey(reader)) {
                periodicals.get(i).setName(map.get(reader).getName() + ", " + periodicals.get(i).getName());
                map.put(reader, periodicals.get(i));
            }
            i++;
        }
        return map;
    }

    public void lockReader(Long readerId) {
        String lockReader = "UPDATE reader SET reader.lock = true WHERE id = ?";
        jdbcTemplate.update(lockReader,
                ps -> {
                    ps.setLong(1, readerId);
                });
    }

    public void unlockReader(Long readerId) {
        String lockReader = "UPDATE reader SET reader.lock = false WHERE id = ?";
        jdbcTemplate.update(lockReader, ps -> {
            ps.setLong(1, readerId);
        });
    }
}
