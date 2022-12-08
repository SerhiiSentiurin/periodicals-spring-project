package org.periodicals.epam.spring.project.logic.service;

import lombok.RequiredArgsConstructor;
import org.periodicals.epam.spring.project.logic.dao.AccountDAO;
import org.periodicals.epam.spring.project.logic.entity.dto.AccountDTO;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountDAO accountDAO;

    public void topUpAccountAmount(AccountDTO accountDTO) {
        accountDAO.topUpAccountAmount(accountDTO);
    }

    public Double getAmountOfMoneyByReaderId(AccountDTO accountDTO) {
        return accountDAO.getAmountOfMoneyByReaderId(accountDTO);
    }
}
