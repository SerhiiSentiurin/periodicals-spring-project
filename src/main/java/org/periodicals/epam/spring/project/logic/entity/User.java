package org.periodicals.epam.spring.project.logic.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class User {
    private long id;
    private String login;
    private String password;
    private UserRole userRole;
}
