package org.periodicals.epam.spring.project.logic.controller;

import lombok.AllArgsConstructor;
import org.periodicals.epam.spring.project.infra.web.QueryParameterHandler;
import org.periodicals.epam.spring.project.logic.entity.Periodical;
import org.periodicals.epam.spring.project.logic.entity.Reader;
import org.periodicals.epam.spring.project.logic.entity.dto.PeriodicalDTO;
import org.periodicals.epam.spring.project.logic.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminController {
    private final AdminService adminService;
    private final QueryParameterHandler queryParameterHandler;

    @GetMapping("/managePeriodicals")
    public ModelAndView getAllPeriodicals(HttpServletRequest request) {
        List<Periodical> listPeriodicals = adminService.getAllPeriodicals();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("periodicals", listPeriodicals);
        modelAndView.setViewName("/admin/managePeriodicals.jsp");
        return modelAndView;
    }

    @PostMapping("/createNewPeriodical")
    public ModelAndView createNewPeriodical(HttpServletRequest request) {
        PeriodicalDTO dto = queryParameterHandler.handleRequest(request, PeriodicalDTO.class);
        adminService.createNewPeriodical(dto);
        return new ModelAndView("redirect:/periodicals/admin/managePeriodicals");
    }

    @PostMapping("/deletePeriodical")
    public ModelAndView deletePeriodicalByPeriodicalId(HttpServletRequest request) {
        Long periodicalId = Long.parseLong(request.getParameter("periodicalId"));
        adminService.deletePeriodicalByPeriodicalId(periodicalId);
        return new ModelAndView("redirect:/periodicals/admin/managePeriodicals");
    }

    @PostMapping("/deletePeriodicalForReaders")
    public ModelAndView deletePeriodicalForReaders(HttpServletRequest request) {
        Long periodicalId = Long.parseLong(request.getParameter("periodicalId"));
        adminService.deletePeriodicalForReaders(periodicalId);
        return new ModelAndView("redirect:/periodicals/admin/managePeriodicals");
    }

    @PostMapping("/restorePeriodicalForReaders")
    public ModelAndView restorePeriodicalForReaders(HttpServletRequest request) {
        Long periodicalId = Long.parseLong(request.getParameter("periodicalId"));
        adminService.restorePeriodicalForReaders(periodicalId);
        return new ModelAndView("redirect:/periodicals/admin/managePeriodicals");
    }

    @GetMapping("/getPeriodicalForEdit")
    public ModelAndView getPeriodicalById(HttpServletRequest request) {
        Long periodicalId = Long.parseLong(request.getParameter("periodicalId"));
        Periodical periodical = adminService.getPeriodicalById(periodicalId);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("periodical", periodical);
        modelAndView.setViewName("/admin/editPeriodical.jsp");
        return modelAndView;
    }

    @PostMapping("/editPeriodical")
    public ModelAndView editPeriodicalById(HttpServletRequest request) {
        PeriodicalDTO dto = queryParameterHandler.handleRequest(request, PeriodicalDTO.class);
        adminService.editPeriodicalById(dto);
        return new ModelAndView("redirect:/periodicals/admin/managePeriodicals");
    }

    @GetMapping("/manageReaders")
    public ModelAndView getAllReaders(HttpServletRequest request) {
        Map<Reader, Periodical> mapOfReaders = adminService.getAllReaders();
        List<Reader> readers = new LinkedList<>(mapOfReaders.keySet());
        List<Periodical> subscriptions = new LinkedList<>(mapOfReaders.values());

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("readers", readers);
        modelAndView.addObject("subscriptions", subscriptions);
        modelAndView.setViewName("/admin/manageReaders.jsp");
        return modelAndView;
    }

    @PostMapping("/lockReader")
    public ModelAndView lockReader(HttpServletRequest request) {
        Long readerId = Long.parseLong(request.getParameter("readerId"));
        adminService.lockReader(readerId);
        return new ModelAndView("redirect:/periodicals/admin/manageReaders");
    }

    @PostMapping("/unlockReader")
    public ModelAndView unlockReader(HttpServletRequest request) {
        Long readerId = Long.parseLong(request.getParameter("readerId"));
        adminService.unlockReader(readerId);
        return new ModelAndView("redirect:/periodicals/admin/manageReaders");
    }
}
