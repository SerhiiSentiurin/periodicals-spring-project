package org.periodicals.epam.spring.project.logic.service;

import lombok.RequiredArgsConstructor;
import org.periodicals.epam.spring.project.logic.dao.PeriodicalDAO;
import org.periodicals.epam.spring.project.logic.entity.Periodical;
import org.periodicals.epam.spring.project.logic.entity.Prepayment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PeriodicalService {
    private final PeriodicalDAO periodicalDAO;
    private static final int PERIODICALS_PER_PAGE = 5;

    public int getCountOfPagesAllPeriodicals() {
        double countOfRows = periodicalDAO.getCountOfRowsAllPeriodicals();
        return (int) Math.ceil(countOfRows / PERIODICALS_PER_PAGE);
    }

    public int getCountOfPagesWithSelectedName(String name) {
        double countOfRows = periodicalDAO.getCountOfRowsWithSelectedName(name);
        return (int) Math.ceil(countOfRows / PERIODICALS_PER_PAGE);
    }

    public int getCountOfPagesWithSelectedTopic(String topic) {
        double countOfRows = periodicalDAO.getCountOfRowsWithSelectedTopic(topic);
        return (int) Math.ceil(countOfRows / PERIODICALS_PER_PAGE);
    }

    public int getCountOfPagesWithSelectedNameAndTopic(String name, String topic) {
        double countOfRows = periodicalDAO.getCountOfRowsWithSelectedNameAndTopic(name,topic);
        return (int) Math.ceil(countOfRows / PERIODICALS_PER_PAGE);
    }


    public List<Periodical> getAllPeriodicals(int page) {
        return periodicalDAO.getAllPeriodicals(getIndex(page));
    }

    public List<Periodical> findByTopic(String topic,int page) {
        return periodicalDAO.findByTopic(topic,getIndex(page));
    }

    public List<Periodical> findWithSelectedNameAndTopic(String topic, String name,int page) {
        return periodicalDAO.findWithSelectedNameAndTopic(topic, name,getIndex(page));
    }

    public List<Periodical> findByName(String name, int page) {
        return periodicalDAO.findByName(name, getIndex(page));
    }

    // sorting in natural ordering
    public List<Periodical> sortByCostAllPeriodicals(int page) {
        return periodicalDAO.sortByCostAllPeriodicals(getIndex(page));
    }

    public List<Periodical> sortByCostWithSelectedTopic(String topic,int page) {
        return periodicalDAO.sortByCostWithSelectedTopic(topic,getIndex(page));
    }

    public List<Periodical> sortByCostWithSelectedName(String name,int page) {
        return periodicalDAO.sortByCostWithSelectedName(name,getIndex(page));
    }

    public List<Periodical> sortByCostWithSelectedTopicAndName(String name, String topic,int page) {
        return periodicalDAO.sortByCostWithSelectedTopicAndName(name, topic,getIndex(page));
    }

    public List<Periodical> sortByNameAllPeriodicals(int page) {
        return periodicalDAO.sortByNameAllPeriodicals(getIndex(page));
    }

    public List<Periodical> sortByNameWithSelectedTopic(String topic,int page) {
        return periodicalDAO.sortByNameWithSelectedTopic(topic,getIndex(page));
    }

    public List<Periodical> sortByNameWithSelectedName(String name,int page) {
        return periodicalDAO.sortByNameWithSelectedName(name,getIndex(page));
    }

    public List<Periodical> sortByNameWithSelectedTopicAndName(String topic, String name,int page) {
        return periodicalDAO.sortByNameWithSelectedTopicAndName(topic, name,getIndex(page));
    }

    // reversed sorting
    public List<Periodical> reversedSortByCostAllPeriodicals(int page) {
        return periodicalDAO.reversedSortByCostAllPeriodicals(getIndex(page));
    }

    public List<Periodical> reversedSortByCostWithSelectedTopic(String topic,int page) {
        return periodicalDAO.reversedSortByCostWithSelectedTopic(topic,getIndex(page));
    }

    public List<Periodical> reversedSortByCostWithSelectedName(String name,int page) {
        return periodicalDAO.reversedSortByCostWithSelectedName(name,getIndex(page));
    }

    public List<Periodical> reversedSortByCostWithSelectedTopicAndName(String name, String topic,int page) {
        return periodicalDAO.reversedSortByCostWithSelectedTopicAndName(name, topic,getIndex(page));
    }

    public List<Periodical> reversedSortByNameAllPeriodicals(int page) {
        return periodicalDAO.reversedSortByNameAllPeriodicals(getIndex(page));
    }

    public List<Periodical> reversedSortByNameWithSelectedTopic(String topic,int page) {
        return periodicalDAO.reversedSortByNameWithSelectedTopic(topic,getIndex(page));
    }

    public List<Periodical> reversedSortByNameWithSelectedName(String name,int page) {
        return periodicalDAO.reversedSortByNameWithSelectedName(name,getIndex(page));
    }

    public List<Periodical> reversedSortByNameWithSelectedTopicAndName(String topic, String name,int page) {
        return periodicalDAO.reversedSortByNameWithSelectedTopicAndName(topic, name,getIndex(page));
    }

    public List<Periodical> getPeriodicalsByReaderId(Long readerId){
        return periodicalDAO.getPeriodicalsByReaderId(readerId);
    }


    public Map<Periodical, Prepayment> getPeriodicalsByTopicByReaderId(String topic, Long readerId) {
        return periodicalDAO.getPeriodicalsByTopicByReaderId(topic, readerId);
    }

    public Map<Periodical, Prepayment> findPeriodicalsByNameByReaderId(String name, Long readerId) {
        return periodicalDAO.findPeriodicalsByNameByReaderId(name, readerId);
    }

    public List<Prepayment> getPrepaymentsByReaderId(Long readerId) {
        return periodicalDAO.getPrepaymentsByReaderId(readerId);
    }

    public List<Periodical> getPeriodicalsForSubscribing(Long readerId) {
        List<Long> periodicalIdByReaderId = periodicalDAO.getPeriodicalIdByReaderId(readerId);
        return periodicalDAO.getPeriodicalsForSubscribing(periodicalIdByReaderId);
    }

    public List<Periodical> getPeriodicalsForSubscribingByTopicByReaderId(String topic, Long readerId) {
        List<Long> periodicalIdByReaderId = periodicalDAO.getPeriodicalIdByReaderId(readerId);
        return periodicalDAO.getPeriodicalsForSubscribing(periodicalIdByReaderId)
                .stream()
                .filter(periodical -> periodical.getTopic().equals(topic))
                .collect(Collectors.toList());
    }

    public List<Periodical> findPeriodicalsForSubscribingByNameByReaderId(String name, Long readerId) {
        List<Long> periodicalIdByReaderId = periodicalDAO.getPeriodicalIdByReaderId(readerId);
        return periodicalDAO.findPeriodicalsForSubscribingByName(periodicalIdByReaderId, name);
    }

    private static int getIndex(int page){
        return (page - 1) * PERIODICALS_PER_PAGE;
    }

}
