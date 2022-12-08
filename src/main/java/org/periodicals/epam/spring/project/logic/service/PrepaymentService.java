package org.periodicals.epam.spring.project.logic.service;

import lombok.RequiredArgsConstructor;
import org.periodicals.epam.spring.project.logic.dao.PrepaymentDAO;
import org.periodicals.epam.spring.project.logic.entity.dto.PrepaymentDTO;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PrepaymentService {
    private final PrepaymentDAO prepaymentDAO;

    public void addSubscription(PrepaymentDTO dto) {
        prepaymentDAO.addSubscription(dto);
    }

    public void deleteSubscription(Long readerId, Long periodicalId) {
        prepaymentDAO.deleteSubscription(readerId, periodicalId);
    }
}
