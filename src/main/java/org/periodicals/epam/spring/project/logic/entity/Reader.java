package org.periodicals.epam.spring.project.logic.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Reader extends User{
    private Account account;
    private boolean Lock;

    public Reader(){
        this.setUserRole(UserRole.READER);
    }
}
