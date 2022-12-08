package org.periodicals.epam.spring.project.logic.service;

import lombok.RequiredArgsConstructor;
import org.periodicals.epam.spring.project.infra.web.exception.ApplicationException;
import org.periodicals.epam.spring.project.logic.dao.ReaderDAO;
import org.periodicals.epam.spring.project.logic.entity.Reader;
import org.periodicals.epam.spring.project.logic.entity.dto.ReaderCreateDTO;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ReaderService {
    private final ReaderDAO readerDAO;

    public void createReader(ReaderCreateDTO readerCreateDTO) {
        readerDAO.insertReader(readerCreateDTO);
    }

    public Reader getReaderById(Long id) {
        return readerDAO.getReaderById(id)
                .orElseThrow(() -> new ApplicationException("can't find reader"));
    }
}
