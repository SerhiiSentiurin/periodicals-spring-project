package org.periodicals.epam.spring.project.logic.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Admin extends User {
    public Admin(){
        super();
    }
}
