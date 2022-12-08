package org.periodicals.epam.spring.project.logic.service;

import lombok.AllArgsConstructor;
import org.periodicals.epam.spring.project.logic.dao.AdminDAO;
import org.periodicals.epam.spring.project.logic.entity.Periodical;
import org.periodicals.epam.spring.project.logic.entity.Reader;
import org.periodicals.epam.spring.project.logic.entity.dto.PeriodicalDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class AdminService {
    private final AdminDAO adminDAO;

    public List<Periodical> getAllPeriodicals() {
        return adminDAO.getAllPeriodicals();
    }

    public void createNewPeriodical(PeriodicalDTO dto) {
        adminDAO.createNewPeriodical(dto);
    }

    public void deletePeriodicalByPeriodicalId(Long periodicalId) {
        adminDAO.deletePeriodicalByPeriodicalId(periodicalId);
    }

    public void deletePeriodicalForReaders(Long periodicalId) {
        adminDAO.deletePeriodicalForReaders(periodicalId);
    }

    public void restorePeriodicalForReaders(Long periodicalId) {
        adminDAO.restorePeriodicalForReaders(periodicalId);
    }

    public Periodical getPeriodicalById(Long periodicalId) {
        return adminDAO.getPeriodicalById(periodicalId);
    }

    public void editPeriodicalById(PeriodicalDTO dto) {
        adminDAO.editPeriodicalById(dto);
    }

    public Map<Reader, Periodical> getAllReaders() {
        return adminDAO.getAllReaders();
    }

    public void lockReader(Long readerId) {
        adminDAO.lockReader(readerId);
    }

    public void unlockReader(Long readerId) {
        adminDAO.unlockReader(readerId);
    }
}
