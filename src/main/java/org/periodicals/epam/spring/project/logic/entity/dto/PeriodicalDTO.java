package org.periodicals.epam.spring.project.logic.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PeriodicalDTO {
    private String name;
    private String topic;
    private Double cost;
    private String description;
    private Long periodicalId;
}
