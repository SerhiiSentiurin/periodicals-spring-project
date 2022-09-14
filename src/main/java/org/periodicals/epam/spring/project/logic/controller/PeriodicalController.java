package org.periodicals.epam.spring.project.logic.controller;

import org.periodicals.epam.spring.project.infra.web.QueryParameterHandler;
import org.periodicals.epam.spring.project.logic.service.PeriodicalService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/periodical")
public class PeriodicalController {

    private final PeriodicalService periodicalService;
    private final QueryParameterHandler queryParameterHandler;

    public PeriodicalController(PeriodicalService periodicalService, QueryParameterHandler queryParameterHandler) {
        this.periodicalService = periodicalService;
        this.queryParameterHandler = queryParameterHandler;
    }

//сделать проверку есть ли в сессии юзер, если нет то использовать этот метод, если есть то if(!userFromSession.isEmpty){new ModelAndView(watchSubscriptions.jsp (или) periodicalsForSubscribing.jsp)}

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

}
