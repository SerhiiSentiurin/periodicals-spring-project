package org.periodicals.epam.spring.project.logic.controller;

import lombok.AllArgsConstructor;
import org.periodicals.epam.spring.project.infra.web.QueryParameterHandler;
import org.periodicals.epam.spring.project.logic.entity.dto.ReaderCreateDTO;
import org.periodicals.epam.spring.project.logic.service.ReaderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@AllArgsConstructor
public class ReaderController {
    private final ReaderService readerService;
    private final QueryParameterHandler queryParameterHandler;

    @PostMapping("/reader/create")
    public ModelAndView createReader(HttpServletRequest request) {
        ReaderCreateDTO dto = queryParameterHandler.handleRequest(request, ReaderCreateDTO.class);
        readerService.createReader(dto);
        return new ModelAndView("redirect:/periodicals/reader/successRegister.jsp");
    }
}
