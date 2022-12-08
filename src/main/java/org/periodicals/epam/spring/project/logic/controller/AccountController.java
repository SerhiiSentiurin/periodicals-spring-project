package org.periodicals.epam.spring.project.logic.controller;

import lombok.AllArgsConstructor;
import org.periodicals.epam.spring.project.infra.web.QueryParameterHandler;
import org.periodicals.epam.spring.project.logic.entity.dto.AccountDTO;
import org.periodicals.epam.spring.project.logic.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/account")
@AllArgsConstructor
public class AccountController {
    private final AccountService accountService;
    private final QueryParameterHandler queryParameterHandler;

    @PostMapping("/topUpAccountAmount")
    public ModelAndView topUpAccountAmount(HttpServletRequest request) {
        AccountDTO dto = queryParameterHandler.handleRequest(request, AccountDTO.class);
        accountService.topUpAccountAmount(dto);
        return new ModelAndView("redirect:/periodicals/account/getAccountInfo?readerId=" + dto.getReaderId());
    }

    @GetMapping("/getAccountInfo")
    public ModelAndView getAmountOfMoneyByReaderId(HttpServletRequest request) {
        AccountDTO dto = queryParameterHandler.handleRequest(request, AccountDTO.class);
        Double amountOfMoney = accountService.getAmountOfMoneyByReaderId(dto);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("amountOfMoney", amountOfMoney);
        modelAndView.setViewName("/account/manageAccount.jsp");
        return modelAndView;
    }
}
