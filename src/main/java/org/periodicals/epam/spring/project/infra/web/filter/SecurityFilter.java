package org.periodicals.epam.spring.project.infra.web.filter;

import lombok.extern.log4j.Log4j2;
import org.periodicals.epam.spring.project.logic.entity.User;
import org.periodicals.epam.spring.project.logic.entity.UserRole;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Log4j2
public class SecurityFilter implements Filter {
    private List<RequestMatcher> pathMatchers;

    @Override
    public void init(FilterConfig filterConfig) {
        List<RequestMatcher> pathMatchers = new ArrayList<>();

        pathMatchers.add(new RequestMatcher("/admin/adminHome.jsp", UserRole.ADMIN));
        pathMatchers.add(new RequestMatcher("/admin/editPeriodical.jsp", UserRole.ADMIN));
        pathMatchers.add(new RequestMatcher("/admin/managePeriodical.jsp", UserRole.ADMIN));
        pathMatchers.add(new RequestMatcher("/admin/manageReaders.jsp", UserRole.ADMIN));
        pathMatchers.add(new RequestMatcher("/periodicals/admin/managePeriodicals", UserRole.ADMIN));
        pathMatchers.add(new RequestMatcher("/periodicals/admin/manageReaders", UserRole.ADMIN));
        pathMatchers.add(new RequestMatcher("/periodicals/admin/getPeriodicalForEdit", UserRole.ADMIN));
        pathMatchers.add(new RequestMatcher("/reader/readerHome.jsp", UserRole.READER));
        pathMatchers.add(new RequestMatcher("/periodicals/periodical/readerSubscriptions", UserRole.READER));
        pathMatchers.add(new RequestMatcher("/periodicals/periodical/periodicalsForSubscribing", UserRole.READER));
        pathMatchers.add(new RequestMatcher("/periodicals/account/getAccountInfo", UserRole.READER));
        pathMatchers.add(new RequestMatcher("/periodicals/periodical/getByTopicReaderSubscriptions", UserRole.READER));
        pathMatchers.add(new RequestMatcher("/periodicals/periodical/findByNameReaderSubscriptions", UserRole.READER));
        pathMatchers.add(new RequestMatcher("/periodicals/periodical/getByTopicPeriodicalsForSubscribing", UserRole.READER));
        pathMatchers.add(new RequestMatcher("/periodicals/periodical/findByNamePeriodicalsForSubscribing", UserRole.READER));
        pathMatchers.add(new RequestMatcher("/periodical/periodicalsForSubscribing.jsp", UserRole.READER));
        pathMatchers.add(new RequestMatcher("/periodical/watchSubscriptions.jsp", UserRole.READER));

        this.pathMatchers = pathMatchers;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String pathWithoutContext = getPathWithoutContext(request);

        Boolean hasAccess = pathMatchers.stream()
                .filter(authorizationPathMatcher -> authorizationPathMatcher.pathMatch(pathWithoutContext))
                .findFirst()
                .map(authorizationPathMatcher -> hasRole(authorizationPathMatcher, request))
                .orElse(true);

        if (hasAccess) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/error/forbidden.jsp");
        requestDispatcher.forward(request, response);
        log.info("Someone trying to enter system. Access forbidden!");
    }

    @Override
    public void destroy() {
        pathMatchers.clear();
    }

    private String getPathWithoutContext(HttpServletRequest httpServletRequest) {
        int contextPathLength = httpServletRequest.getContextPath().length();
        return httpServletRequest.getRequestURI().substring(contextPathLength);
    }

    private boolean hasRole(RequestMatcher authorizationMatcher, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        return session != null && authorizationMatcher.hasRole((User) session.getAttribute("user"));
    }
}

