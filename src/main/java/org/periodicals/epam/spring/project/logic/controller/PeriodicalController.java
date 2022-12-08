package org.periodicals.epam.spring.project.logic.controller;

import lombok.AllArgsConstructor;
import org.periodicals.epam.spring.project.logic.entity.Periodical;
import org.periodicals.epam.spring.project.logic.entity.Prepayment;
import org.periodicals.epam.spring.project.logic.entity.Reader;
import org.periodicals.epam.spring.project.logic.service.PeriodicalService;
import org.periodicals.epam.spring.project.logic.service.ReaderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/periodical")
@AllArgsConstructor
public class PeriodicalController {
    private final PeriodicalService periodicalService;
    private final ReaderService readerService;

    @GetMapping("/watch")
    public ModelAndView getAllPeriodicals(HttpServletRequest request) {
        int page = Integer.parseInt(request.getParameter("page"));
        ModelAndView modelAndView = new ModelAndView("/periodical/watchPeriodical.jsp");
        modelAndView.addObject("periodicals", periodicalService.getAllPeriodicals(page));
        modelAndView.addObject("countOfPages", periodicalService.getCountOfPagesAllPeriodicals());
        modelAndView.addObject("page", page);
        modelAndView.addObject("path",getRequestPath(request));
        return modelAndView;
    }

    @GetMapping("/search")
    public ModelAndView searchPeriodical(HttpServletRequest request) {
        String topic = request.getParameter("topic");
        String name = request.getParameter("name");
        int page = Integer.parseInt(request.getParameter("page"));
        ModelAndView modelAndView = new ModelAndView("/periodical/watchPeriodical.jsp");
        if (name.isEmpty() && topic.isEmpty()) {
            modelAndView.addObject("periodicals", periodicalService.getAllPeriodicals(page));
            modelAndView.addObject("countOfPages", periodicalService.getCountOfPagesAllPeriodicals());
        } else if (!topic.isEmpty() && name.isEmpty()) {
            modelAndView.addObject("periodicals", periodicalService.findByTopic(topic, page));
            modelAndView.addObject("countOfPages", periodicalService.getCountOfPagesWithSelectedTopic(topic));
        } else if (topic.isEmpty()) {
            modelAndView.addObject("periodicals", periodicalService.findByName(name, page));
            modelAndView.addObject("countOfPages", periodicalService.getCountOfPagesWithSelectedName(name));
        } else {
            modelAndView.addObject("periodicals", periodicalService.findWithSelectedNameAndTopic(topic, name, page));
            modelAndView.addObject("countOfPages", periodicalService.getCountOfPagesWithSelectedNameAndTopic(name, topic));
        }
        modelAndView.addObject("topic", topic);
        modelAndView.addObject("name", name);
        modelAndView.addObject("page", page);
        modelAndView.addObject("path",getRequestPath(request));
        return modelAndView;
    }

    @GetMapping("/sortByCost")
    public ModelAndView sortByCost(HttpServletRequest request) {
        String name = request.getParameter("name");
        String topic = request.getParameter("topic");
        int page = Integer.parseInt(request.getParameter("page"));
        ModelAndView modelAndView = new ModelAndView("/periodical/watchPeriodical.jsp");
        if (name.isEmpty() && topic.isEmpty()) {
            modelAndView.addObject("periodicals", periodicalService.sortByCostAllPeriodicals(page));
            modelAndView.addObject("countOfPages", periodicalService.getCountOfPagesAllPeriodicals());
        } else if (!topic.isEmpty() && name.isEmpty()) {
            modelAndView.addObject("periodicals", periodicalService.sortByCostWithSelectedTopic(topic, page));
            modelAndView.addObject("countOfPages", periodicalService.getCountOfPagesWithSelectedTopic(topic));
        } else if (topic.isEmpty()) {
            modelAndView.addObject("periodicals", periodicalService.sortByCostWithSelectedName(name, page));
            modelAndView.addObject("countOfPages", periodicalService.getCountOfPagesWithSelectedName(name));
        } else {
            modelAndView.addObject("periodicals", periodicalService.sortByCostWithSelectedTopicAndName(name, topic, page));
            modelAndView.addObject("countOfPages", periodicalService.getCountOfPagesWithSelectedNameAndTopic(name, topic));
        }
        modelAndView.addObject("name", name);
        modelAndView.addObject("topic", topic);
        modelAndView.addObject("page", page);
        modelAndView.addObject("path",getRequestPath(request));
        return modelAndView;
    }

    @GetMapping("/reversedSortByCost")
    public ModelAndView reversedSortByCost(HttpServletRequest request) {
        String name = request.getParameter("name");
        String topic = request.getParameter("topic");
        int page = Integer.parseInt(request.getParameter("page"));
        ModelAndView modelAndView = new ModelAndView("/periodical/watchPeriodical.jsp");
        if (name.isEmpty() && topic.isEmpty()) {
            modelAndView.addObject("periodicals", periodicalService.reversedSortByCostAllPeriodicals(page));
            modelAndView.addObject("countOfPages", periodicalService.getCountOfPagesAllPeriodicals());
        } else if (!topic.isEmpty() && name.isEmpty()) {
            modelAndView.addObject("periodicals", periodicalService.reversedSortByCostWithSelectedTopic(topic, page));
            modelAndView.addObject("countOfPages", periodicalService.getCountOfPagesWithSelectedTopic(topic));
        } else if (topic.isEmpty()) {
            modelAndView.addObject("periodicals", periodicalService.reversedSortByCostWithSelectedName(name, page));
            modelAndView.addObject("countOfPages", periodicalService.getCountOfPagesWithSelectedName(name));
        } else {
            modelAndView.addObject("periodicals", periodicalService.reversedSortByCostWithSelectedTopicAndName(name, topic, page));
            modelAndView.addObject("countOfPages", periodicalService.getCountOfPagesWithSelectedNameAndTopic(name, topic));
        }
        modelAndView.addObject("name", name);
        modelAndView.addObject("topic", topic);
        modelAndView.addObject("page", page);
        modelAndView.addObject("path",getRequestPath(request));
        return modelAndView;
    }

    @GetMapping("/sortByName")
    public ModelAndView sortByName(HttpServletRequest request) {
        String name = request.getParameter("name");
        String topic = request.getParameter("topic");
        int page = Integer.parseInt(request.getParameter("page"));
        ModelAndView modelAndView = new ModelAndView("/periodical/watchPeriodical.jsp");
        if (name.isEmpty() && topic.isEmpty()) {
            modelAndView.addObject("periodicals", periodicalService.sortByNameAllPeriodicals(page));
            modelAndView.addObject("countOfPages", periodicalService.getCountOfPagesAllPeriodicals());
        } else if (!topic.isEmpty() && name.isEmpty()) {
            modelAndView.addObject("periodicals", periodicalService.sortByNameWithSelectedTopic(topic, page));
            modelAndView.addObject("countOfPages", periodicalService.getCountOfPagesWithSelectedTopic(topic));
        } else if (topic.isEmpty()) {
            modelAndView.addObject("periodicals", periodicalService.sortByNameWithSelectedName(name, page));
            modelAndView.addObject("countOfPages", periodicalService.getCountOfPagesWithSelectedName(name));
        } else {
            modelAndView.addObject("periodicals", periodicalService.sortByNameWithSelectedTopicAndName(topic, name, page));
            modelAndView.addObject("countOfPages", periodicalService.getCountOfPagesWithSelectedNameAndTopic(name, topic));
        }
        modelAndView.addObject("name", name);
        modelAndView.addObject("topic", topic);
        modelAndView.addObject("page", page);
        modelAndView.addObject("path",getRequestPath(request));
        return modelAndView;
    }

    @GetMapping("/reversedSortByName")
    public ModelAndView reversedSortByName(HttpServletRequest request) {
        String name = request.getParameter("name");
        String topic = request.getParameter("topic");
        int page = Integer.parseInt(request.getParameter("page"));
        ModelAndView modelAndView = new ModelAndView("/periodical/watchPeriodical.jsp");
        if (name.isEmpty() && topic.isEmpty()) {
            modelAndView.addObject("periodicals", periodicalService.reversedSortByNameAllPeriodicals(page));
            modelAndView.addObject("countOfPages", periodicalService.getCountOfPagesAllPeriodicals());
        } else if (!topic.isEmpty() && name.isEmpty()) {
            modelAndView.addObject("periodicals", periodicalService.reversedSortByNameWithSelectedTopic(topic, page));
            modelAndView.addObject("countOfPages", periodicalService.getCountOfPagesWithSelectedTopic(topic));
        } else if (topic.isEmpty()) {
            modelAndView.addObject("periodicals", periodicalService.reversedSortByNameWithSelectedName(name, page));
            modelAndView.addObject("countOfPages", periodicalService.getCountOfPagesWithSelectedName(name));
        } else {
            modelAndView.addObject("periodicals", periodicalService.reversedSortByNameWithSelectedTopicAndName(topic, name, page));
            modelAndView.addObject("countOfPages", periodicalService.getCountOfPagesWithSelectedNameAndTopic(name, topic));
        }
        modelAndView.addObject("name", name);
        modelAndView.addObject("topic", topic);
        modelAndView.addObject("page", page);
        modelAndView.addObject("path",getRequestPath(request));
        return modelAndView;
    }

    private static String getRequestPath(HttpServletRequest request) {
        String contextPath = request.getContextPath();
        String servletPath = request.getServletPath();
        String pathInfo = request.getPathInfo();
        return contextPath.concat(servletPath).concat(pathInfo);
    }

    @GetMapping("/readerSubscriptions")
    public ModelAndView getPeriodicalsByReaderId(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        long readerId = Long.parseLong(request.getParameter("readerId"));
        List<Periodical> subscribedPeriodicals = periodicalService.getPeriodicalsByReaderId(readerId);
        List<Prepayment> prepaymentInfo = periodicalService.getPrepaymentsByReaderId(readerId);
        modelAndView.addObject("periodicals", subscribedPeriodicals);
        modelAndView.addObject("prepayments", prepaymentInfo);
        modelAndView.setViewName("/periodical/watchSubscriptions.jsp");
        return modelAndView;
    }

    @GetMapping("/getByTopicReaderSubscriptions")
    public ModelAndView getPeriodicalsByTopicByReaderId(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        long readerId = Long.parseLong(request.getParameter("readerId"));
        String topic = request.getParameter("topic");
        Map<Periodical, Prepayment> infoMap = periodicalService.getPeriodicalsByTopicByReaderId(topic, readerId);
        List<Periodical> subscribedPeriodicals = new ArrayList<>(infoMap.keySet());
        List<Prepayment> prepaymentInfo = new ArrayList<>(infoMap.values());
        modelAndView.addObject("periodicals", subscribedPeriodicals);
        modelAndView.addObject("prepayments", prepaymentInfo);
        modelAndView.addObject("topic", topic);
        modelAndView.setViewName("/periodical/watchSubscriptions.jsp");
        return modelAndView;
    }

    @GetMapping("/findByNameReaderSubscriptions")
    public ModelAndView findPeriodicalsByNameByReaderId(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        long readerId = Long.parseLong(request.getParameter("readerId"));
        String name = request.getParameter("name");
        Map<Periodical, Prepayment> infoList = periodicalService.findPeriodicalsByNameByReaderId(name, readerId);
        List<Periodical> subscribedPeriodicals = new ArrayList<>(infoList.keySet());
        List<Prepayment> prepaymentInfo = new ArrayList<>(infoList.values());

        modelAndView.addObject("periodicals", subscribedPeriodicals);
        modelAndView.addObject("prepayments", prepaymentInfo);
        modelAndView.addObject("name", name);
        modelAndView.setViewName("/periodical/watchSubscriptions.jsp");
        return modelAndView;
    }

    @GetMapping("/periodicalsForSubscribing")
    public ModelAndView getPeriodicalsForSubscribing(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        long readerId = Long.parseLong(request.getParameter("readerId"));
        List<Periodical> periodicalsForSubscribing = periodicalService.getPeriodicalsForSubscribing(readerId);
        Reader reader = readerService.getReaderById(readerId);
        modelAndView.addObject("reader", reader);
        modelAndView.addObject("periodicals", periodicalsForSubscribing);
        modelAndView.setViewName("/periodical/periodicalsForSubscribing.jsp");
        return modelAndView;
    }

    @GetMapping("/getByTopicPeriodicalsForSubscribing")
    public ModelAndView getPeriodicalsForSubscribingByTopicByReaderId(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        long readerId = Long.parseLong(request.getParameter("readerId"));
        String topic = request.getParameter("topic");
        List<Periodical> periodicalsForSubscribing = periodicalService.getPeriodicalsForSubscribingByTopicByReaderId(topic, readerId);
        Reader reader = readerService.getReaderById(readerId);
        modelAndView.addObject("reader", reader);
        modelAndView.addObject("periodicals", periodicalsForSubscribing);
        modelAndView.addObject("topic", topic);
        modelAndView.setViewName("/periodical/periodicalsForSubscribing.jsp");
        return modelAndView;
    }

    @GetMapping("/findByNamePeriodicalsForSubscribing")
    public ModelAndView findPeriodicalsForSubscribingByNameByReaderId(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        long readerId = Long.parseLong(request.getParameter("readerId"));
        String name = request.getParameter("name");
        List<Periodical> periodicalsForSubscribing = periodicalService.findPeriodicalsForSubscribingByNameByReaderId(name, readerId);
        Reader reader = readerService.getReaderById(readerId);
        modelAndView.addObject("reader", reader);
        modelAndView.addObject("periodicals", periodicalsForSubscribing);
        modelAndView.addObject("name", name);
        modelAndView.setViewName("/periodical/periodicalsForSubscribing.jsp");
        return modelAndView;
    }
}
