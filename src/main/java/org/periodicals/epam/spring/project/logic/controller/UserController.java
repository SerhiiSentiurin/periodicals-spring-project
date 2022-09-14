package org.periodicals.epam.spring.project.logic.controller;

import lombok.RequiredArgsConstructor;
import org.periodicals.epam.spring.project.infra.web.QueryParameterHandler;
import org.periodicals.epam.spring.project.infra.web.ViewMapConfig;
import org.periodicals.epam.spring.project.logic.entity.User;
import org.periodicals.epam.spring.project.logic.entity.UserRole;
import org.periodicals.epam.spring.project.logic.entity.dto.UserDto;
import org.periodicals.epam.spring.project.logic.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Locale;
import java.util.Map;

@Controller

public class UserController {


    private final UserService userService;
    private final QueryParameterHandler queryParameterHandler;
//    private final Map<UserRole, String> mapView;
    private final ViewMapConfig mapView;

    public UserController(UserService userService, QueryParameterHandler queryParameterHandler, ViewMapConfig mapView) {
        this.userService = userService;
        this.queryParameterHandler = queryParameterHandler;
        this.mapView = mapView;
    }

    @PostMapping("/login")
    public RedirectView login(HttpServletRequest request) {
        UserDto userDto = queryParameterHandler.handleRequest(request, UserDto.class);
        User userByLogin = userService.getUserByLogin(userDto);
        HttpSession session = request.getSession(true);
        session.setAttribute("user", userByLogin);
        return new RedirectView(mapView.get(userByLogin.getUserRole()));
    }

    @PostMapping("/logout")
    public RedirectView logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return new RedirectView("/app/index.jsp");
    }

    @PostMapping("/changeLocale")
    public RedirectView changeLocale(HttpServletRequest request) {
        String selectedLocale = request.getParameter("selectedLocale");
        String view = request.getParameter("view");
        Locale locale = new Locale(selectedLocale);
        HttpSession session = request.getSession(false);
        session.setAttribute("selectedLocale", locale);
        return new RedirectView("/app" + view);
    }

}
