package com.krantikumar.project.RiderApp.services.impl;

import com.krantikumar.project.RiderApp.entities.WalletTransaction;
import com.krantikumar.project.RiderApp.repositories.WalletTransactionRepository;
import com.krantikumar.project.RiderApp.services.WalletTransactionService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WalletTransactionServiceImpl implements WalletTransactionService {

    private final WalletTransactionRepository walletTransactionRepository;
    private final ModelMapper modelMapper;

    @Override
    public void createNewWalletTransaction(WalletTransaction walletTransaction) {
        walletTransactionRepository.save(walletTransaction);
    }

}
