package org.periodicals.epam.spring.project.logic.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.periodicals.epam.spring.project.logic.entity.UserRole;


@Data
@AllArgsConstructor
public class ReaderCreateDTO {
    private Long id;
    private String login;
    private String password;
    private UserRole userRole;

    public ReaderCreateDTO() {
        this.userRole = UserRole.READER;
    }

    public ReaderCreateDTO(Long id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.userRole = UserRole.READER;
    }
}
