package org.periodicals.epam.spring.project.logic.controller;

import lombok.AllArgsConstructor;
import org.periodicals.epam.spring.project.infra.web.QueryParameterHandler;
import org.periodicals.epam.spring.project.logic.entity.dto.PrepaymentDTO;
import org.periodicals.epam.spring.project.logic.service.PrepaymentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/prepayment")
@AllArgsConstructor
public class PrepaymentController {
    private final PrepaymentService prepaymentService;
    private final QueryParameterHandler queryParameterHandler;

    @PostMapping("/addSubscription")
    public ModelAndView addSubscription(HttpServletRequest request) {
        PrepaymentDTO dto = queryParameterHandler.handleRequest(request, PrepaymentDTO.class);
        prepaymentService.addSubscription(dto);
        return new ModelAndView("redirect:/periodicals/periodical/periodicalsForSubscribing?readerId=" + dto.getReaderId());
    }

    @PostMapping("/deleteSubscription")
    public ModelAndView deleteSubscription(HttpServletRequest request) {
        long readerId = Long.parseLong(request.getParameter("readerId"));
        long periodicalId = Long.parseLong(request.getParameter("periodicalId"));
        prepaymentService.deleteSubscription(readerId, periodicalId);
        return new ModelAndView("redirect:/periodicals/periodical/readerSubscriptions?readerId=" + readerId);
    }
}
