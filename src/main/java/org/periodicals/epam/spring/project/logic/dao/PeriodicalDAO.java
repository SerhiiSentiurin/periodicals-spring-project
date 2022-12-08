package org.periodicals.epam.spring.project.logic.dao;

import lombok.RequiredArgsConstructor;
import org.periodicals.epam.spring.project.logic.dao.resultSetExtractor.PaginationResultSetExtractor;
import org.periodicals.epam.spring.project.logic.dao.rowMapper.PeriodicalRowMapper;
import org.periodicals.epam.spring.project.logic.dao.rowMapper.PrepaymentRowMapper;
import org.periodicals.epam.spring.project.logic.entity.Periodical;
import org.periodicals.epam.spring.project.logic.entity.Prepayment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@RequiredArgsConstructor
public class PeriodicalDAO {
    private final JdbcTemplate jdbcTemplate;
    private final PeriodicalRowMapper periodicalRowMapper;
    private final PrepaymentRowMapper prepaymentRowMapper;
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

    public List<Periodical> getPeriodicalsByReaderId(Long readerId) {
        String sql = "SELECT * FROM periodical JOIN periodicals ON periodical.id = periodicals.periodical_id WHERE reader_id =? ORDER BY periodical.id";
        return jdbcTemplate.query(sql, ps -> {
            ps.setLong(1, readerId);
        }, periodicalRowMapper);
    }

    public Map<Periodical, Prepayment> getPeriodicalsByTopicByReaderId(String topic, Long readerId) {
        String getPeriodicalByTopicByReaderId = "SELECT * FROM periodical JOIN prepayment ON periodical.id = prepayment.periodical_id WHERE reader_id =? AND topic =? ORDER BY periodical.id";
        Map<Periodical, Prepayment> info = new HashMap<>();

        List<Periodical> periodicals = jdbcTemplate.query(getPeriodicalByTopicByReaderId, ps -> {
            ps.setLong(1, readerId);
            ps.setString(2, topic);
        }, periodicalRowMapper);

        List<Prepayment> prepayments = jdbcTemplate.query(getPeriodicalByTopicByReaderId, ps -> {
            ps.setLong(1, readerId);
            ps.setString(2, topic);
        }, prepaymentRowMapper);
        for (Periodical periodical : periodicals) {
            for (Prepayment prepayment : prepayments) {
                info.put(periodical, prepayment);
            }
        }
        return info;
    }

    public List<Prepayment> getPrepaymentsByReaderId(Long readerId) {
        String selectPeriodicalsByReaderId = "SELECT prepayment.id, start_date, due_date, periodical_id, reader_id FROM periodical JOIN prepayment ON periodical.id = prepayment.periodical_id WHERE reader_id =? ORDER BY periodical_id";
        return jdbcTemplate.query(selectPeriodicalsByReaderId, ps -> ps.setLong(1, readerId), prepaymentRowMapper);
    }

    public Map<Periodical, Prepayment> findPeriodicalsByNameByReaderId(String name, Long readerId) {
        String findPeriodicalsByNameByReaderId = "SELECT * FROM periodical JOIN prepayment ON periodical.id = prepayment.periodical_id WHERE reader_id =? AND name LIKE ? ORDER BY periodical.id";
        Map<Periodical, Prepayment> info = new HashMap<>();
        List<Periodical> periodicals = jdbcTemplate.query(findPeriodicalsByNameByReaderId, ps -> {
            ps.setLong(1, readerId);
            ps.setString(2, "%" + name + "%");
        }, periodicalRowMapper);

        List<Prepayment> prepayments = jdbcTemplate.query(findPeriodicalsByNameByReaderId, ps -> {
            ps.setLong(1, readerId);
            ps.setString(2, "%" + name + "%");
        }, prepaymentRowMapper);
        for (Periodical periodical : periodicals) {
            for (Prepayment prepayment : prepayments) {
                info.put(periodical, prepayment);
            }
        }
        return info;
    }

    public List<Periodical> getPeriodicalsForSubscribing(List<Long> listPeriodicalId) {
        String sqlToGetPeriodicalsForSubscribing = buildSqlToGetPeriodicalsForSubscribing(listPeriodicalId);
        return jdbcTemplate.query(sqlToGetPeriodicalsForSubscribing, periodicalRowMapper);
    }

    private String buildSqlToGetPeriodicalsForSubscribing(List<Long> listPeriodicalId) {
        StringBuilder sqlBuilder = new StringBuilder("SELECT distinct id, name, topic, cost, description, isDeleted FROM periodical");
        if (!listPeriodicalId.isEmpty()) {
            sqlBuilder.append(" left join periodicals ON periodicals.periodical_id = periodical.id WHERE (reader_id IS NULL OR ");
            Iterator<Long> iterator = listPeriodicalId.iterator();
            while (iterator.hasNext()) {
                sqlBuilder.append("NOT periodical_id = ").append(iterator.next());
                if (iterator.hasNext()) {
                    sqlBuilder.append(" and ");
                } else {
                    sqlBuilder.append(") and isDeleted = false");
                }
            }
        } else {
            sqlBuilder.append(" left join periodicals ON periodicals.periodical_id = periodical.id WHERE isDeleted = false");
        }
        return sqlBuilder.toString();
    }

    public List<Periodical> findPeriodicalsForSubscribingByName(List<Long> listPeriodicalId, String name) {
        String sqlToGetPeriodicalsForSubscribing = buildSqlToFindPeriodicalsForSubscribingByName(listPeriodicalId);
        return jdbcTemplate.query(sqlToGetPeriodicalsForSubscribing, ps -> ps.setString(1, "%" + name + "%"), periodicalRowMapper);
    }

    private String buildSqlToFindPeriodicalsForSubscribingByName(List<Long> listPeriodicalId) {
        StringBuilder sqlBuilder = new StringBuilder("SELECT distinct id, name, topic, cost, description, isDeleted FROM periodical");
        if (!listPeriodicalId.isEmpty()) {
            sqlBuilder.append(" left join periodicals ON periodicals.periodical_id = periodical.id WHERE (reader_id IS NULL OR ");
            Iterator<Long> iterator = listPeriodicalId.iterator();
            while (iterator.hasNext()) {
                sqlBuilder.append("NOT periodical_id = ").append(iterator.next());
                if (iterator.hasNext()) {
                    sqlBuilder.append(" AND ");
                } else {
                    sqlBuilder.append(") AND isDeleted = false AND name LIKE ?");
                }
            }
        } else {
            sqlBuilder.append(" LEFT JOIN periodicals ON periodicals.periodical_id = periodical.id WHERE name LIKE ? AND isDeleted = false");
        }
        return sqlBuilder.toString();
    }

    public List<Long> getPeriodicalIdByReaderId(Long readerId) {
        String getPeriodicalIdByReaderId = "SELECT * FROM periodicals JOIN periodical ON periodicals.periodical_id = periodical.id WHERE reader_id = ? order by periodical_id";
        List<Long> listOfPeriodicalId = new ArrayList<>();
        List<Periodical> periodicals = jdbcTemplate.query(getPeriodicalIdByReaderId, ps -> ps.setLong(1, readerId), periodicalRowMapper);
        for (Periodical periodical : periodicals) {
            listOfPeriodicalId.add(periodical.getId());
        }
        return listOfPeriodicalId;
    }

}
