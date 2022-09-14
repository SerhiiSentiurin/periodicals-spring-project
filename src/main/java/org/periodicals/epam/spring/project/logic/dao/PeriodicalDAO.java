package org.periodicals.epam.spring.project.logic.dao;

import lombok.RequiredArgsConstructor;
import org.periodicals.epam.spring.project.logic.dao.resultSetExtractor.PaginationResultSetExtractor;
import org.periodicals.epam.spring.project.logic.dao.rowMapper.PeriodicalRowMapper;
import org.periodicals.epam.spring.project.logic.entity.Periodical;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PeriodicalDAO {
    private final JdbcTemplate jdbcTemplate;
    private final PeriodicalRowMapper periodicalRowMapper;
    private final PaginationResultSetExtractor paginationResultSetExtractor;

    public double getCountOfRowsAllPeriodicals() {
        String sql = "SELECT COUNT(*) FROM periodical";
        return jdbcTemplate.query(sql, paginationResultSetExtractor).get();
    }

    public double getCountOfRowsWithSelectedTopic(String topic) {
        String sql = "SELECT COUNT(*) FROM periodical WHERE topic = ?";
        return jdbcTemplate.query(sql, ps -> ps.setString(1, topic), paginationResultSetExtractor).get();
    }


    public double getCountOfRowsWithSelectedName(String name) {
        String sql = "SELECT COUNT(*) FROM periodical WHERE name LIKE ?";
        return jdbcTemplate.query(sql, ps -> ps.setString(1, "%" + name + "%"), paginationResultSetExtractor).get();
    }

    public double getCountOfRowsWithSelectedNameAndTopic(String name, String topic) {
        String sql = "SELECT COUNT(*) FROM periodical WHERE topic = ? AND name LIKE ?";
        return jdbcTemplate.query(sql, ps -> {
            ps.setString(1, topic);
            ps.setString(2, "%" + name + "%");
        }, paginationResultSetExtractor).get();
    }

    public List<Periodical> getAllPeriodicals(int index) {
        String sql = "SELECT * FROM (select * from periodical order by id limit ?, 5) periodical ORDER BY id";
        return jdbcTemplate.query(sql, ps -> ps.setInt(1, index), periodicalRowMapper);
    }

    public List<Periodical> findByTopic(String topic, int index) {
        String sql = "SELECT * FROM (select * from periodical order by id limit ?, 5) periodical WHERE topic = ?";
        return jdbcTemplate.query(sql, ps -> {
            ps.setInt(1, index);
            ps.setString(2, topic);
        }, periodicalRowMapper);
    }

    public List<Periodical> findByName(String name, int index) {
        String sql = "SELECT * FROM (select * from periodical order by id limit ?, 5) periodical WHERE name LIKE ?";
        return jdbcTemplate.query(sql, ps -> {
            ps.setInt(1, index);
            ps.setString(2, "%" + name + "%");
        }, periodicalRowMapper);
    }

    public List<Periodical> findWithSelectedNameAndTopic(String topic, String name, int index) {
        String sql = "SELECT * FROM (select * from periodical order by id limit ?, 5) periodical WHERE topic = ? AND name LIKE ?";
        return jdbcTemplate.query(sql, ps -> {
            ps.setInt(1, index);
            ps.setString(2, topic);
            ps.setString(3, "%" + name + "%");
        }, periodicalRowMapper);
    }

    // sorting in natural ordering
    public List<Periodical> sortByCostAllPeriodicals(int index) {
        String sql = "SELECT * FROM (select * from periodical order by id limit ?, 5) periodical ORDER BY cost";
        return jdbcTemplate.query(sql, ps -> ps.setInt(1, index), periodicalRowMapper);
    }

    public List<Periodical> sortByCostWithSelectedTopic(String topic, int index) {
        String sql = "SELECT * FROM (select * from periodical order by id limit ?, 5) periodical WHERE topic = ? ORDER BY cost";
        return jdbcTemplate.query(sql, ps -> {
            ps.setInt(1, index);
            ps.setString(2, topic);

        }, periodicalRowMapper);
    }

    public List<Periodical> sortByCostWithSelectedName(String name, int index) {
        String sql = "SELECT * FROM (select * from periodical order by id limit ?, 5) periodical WHERE name LIKE ? ORDER BY cost";
        return jdbcTemplate.query(sql, ps -> {
            ps.setInt(1, index);
            ps.setString(2, "%" + name + "%");
        }, periodicalRowMapper);
    }

    public List<Periodical> sortByCostWithSelectedTopicAndName(String name, String topic, int index) {
        String sql = "SELECT * FROM (select * from periodical order by id limit ?, 5) periodical WHERE topic = ? AND name LIKE ? ORDER BY cost";
        return jdbcTemplate.query(sql, ps -> {
            ps.setInt(1, index);
            ps.setString(2, topic);
            ps.setString(3, "%" + name + "%");
        }, periodicalRowMapper);
    }

    public List<Periodical> sortByNameAllPeriodicals(int index) {
        String sql = "SELECT * FROM (select * from periodical order by id limit ?, 5) periodical ORDER BY name";
        return jdbcTemplate.query(sql, ps -> ps.setInt(1, index), periodicalRowMapper);
    }

    public List<Periodical> sortByNameWithSelectedTopic(String topic, int index) {
        String sql = "SELECT * FROM (select * from periodical order by id limit ?, 5) periodical WHERE topic = ? ORDER BY name";
        return jdbcTemplate.query(sql, ps -> {
            ps.setInt(1, index);
            ps.setString(2, topic);
        }, periodicalRowMapper);
    }

    public List<Periodical> sortByNameWithSelectedName(String name, int index) {
        String sql = "SELECT * FROM (select * from periodical order by id limit ?, 5) periodical WHERE name LIKE ? ORDER BY name";
        return jdbcTemplate.query(sql, ps -> {
            ps.setInt(1, index);
            ps.setString(2, "%" + name + "%");
        }, periodicalRowMapper);
    }

    public List<Periodical> sortByNameWithSelectedTopicAndName(String topic, String name, int index) {
        String sql = "SELECT * FROM (select * from periodical order by id limit ?, 5) periodical WHERE topic = ? AND name LIKE ? ORDER BY name";
        return jdbcTemplate.query(sql, ps -> {
            ps.setInt(1, index);
            ps.setString(2, topic);
            ps.setString(3, "%" + name + "%");
        }, periodicalRowMapper);
    }

    // reversed sorting
    public List<Periodical> reversedSortByCostAllPeriodicals(int index) {
        String sql = "SELECT * FROM (select * from periodical order by id limit ?, 5) periodical ORDER BY cost DESC";
        return jdbcTemplate.query(sql, ps -> ps.setInt(1, index), periodicalRowMapper);
    }

    public List<Periodical> reversedSortByCostWithSelectedTopic(String topic, int index) {
        String sql = "SELECT * FROM (select * from periodical order by id limit ?, 5) periodical WHERE topic = ? ORDER BY cost DESC";
        return jdbcTemplate.query(sql, ps -> {
            ps.setInt(1, index);
            ps.setString(2, topic);
        }, periodicalRowMapper);
    }

    public List<Periodical> reversedSortByCostWithSelectedName(String name, int index) {
        String sql = "SELECT * FROM (select * from periodical order by id limit ?, 5) periodical WHERE name LIKE ? ORDER BY cost DESC";
        return jdbcTemplate.query(sql, ps -> {
            ps.setInt(1, index);
            ps.setString(2, "%" + name + "%");
        }, periodicalRowMapper);
    }

    public List<Periodical> reversedSortByCostWithSelectedTopicAndName(String name, String topic, int index) {
        String sql = "SELECT * FROM (select * from periodical order by id limit ?, 5) periodical WHERE topic = ? AND name LIKE ? ORDER BY cost DESC";
        return jdbcTemplate.query(sql, ps -> {
            ps.setInt(1, index);
            ps.setString(2, topic);
            ps.setString(3, "%" + name + "%");
        }, periodicalRowMapper);
    }

    public List<Periodical> reversedSortByNameAllPeriodicals(int index) {
        String sql = "SELECT * FROM (select * from periodical order by id limit ?, 5) periodical ORDER BY name DESC";
        return jdbcTemplate.query(sql, ps -> ps.setInt(1, index), periodicalRowMapper);
    }

    public List<Periodical> reversedSortByNameWithSelectedTopic(String topic, int index) {
        String sql = "SELECT * FROM (select * from periodical order by id limit ?, 5) periodical WHERE topic = ? ORDER BY name DESC";
        return jdbcTemplate.query(sql, ps -> {
            ps.setInt(1, index);
            ps.setString(2, topic);
        }, periodicalRowMapper);
    }

    public List<Periodical> reversedSortByNameWithSelectedName(String name, int index) {
        String sql = "SELECT * FROM (select * from periodical order by id limit ?, 5) periodical WHERE name LIKE ? ORDER BY name DESC";
        return jdbcTemplate.query(sql, ps -> {
            ps.setInt(1, index);
            ps.setString(2, "%" + name + "%");
        }, periodicalRowMapper);
    }

    public List<Periodical> reversedSortByNameWithSelectedTopicAndName(String topic, String name, int index) {
        String sql = "SELECT * FROM (select * from periodical order by id limit ?, 5) periodical WHERE topic = ? AND name LIKE ? ORDER BY name DESC";
        return jdbcTemplate.query(sql, ps -> {
            ps.setInt(1, index);
            ps.setString(2, topic);
            ps.setString(3, "%" + name + "%");
        }, periodicalRowMapper);
    }


}
