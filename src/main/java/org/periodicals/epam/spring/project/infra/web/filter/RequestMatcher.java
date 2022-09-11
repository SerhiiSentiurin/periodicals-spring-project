package org.periodicals.epam.spring.project.infra.web.filter;

import lombok.Value;
import org.periodicals.epam.spring.project.logic.entity.User;
import org.periodicals.epam.spring.project.logic.entity.UserRole;

import java.util.Arrays;
import java.util.List;

@Value
public class RequestMatcher {
    String pathRegex;
    List<UserRole> accessRoles;

    public RequestMatcher(String pathRegex, UserRole... roles) {
        this.pathRegex = pathRegex;
        this.accessRoles = Arrays.asList(roles);
    }

    public boolean pathMatch(String path) {
        return path.matches(pathRegex);
    }

    public boolean hasRole(User user) {
        return user != null && accessRoles.contains(user.getUserRole());
    }
}
