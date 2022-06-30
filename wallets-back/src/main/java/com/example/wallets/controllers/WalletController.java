package com.example.wallets.controllers;

import com.example.wallets.models.DTO.WalletDTO;
import com.example.wallets.models.Wallet;
import com.example.wallets.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class WalletController {

    @Autowired
    WalletService walletService;


    @PostMapping ("/add-wallet")
    @CrossOrigin
    public void addWalletToUserPortfolio(@RequestBody WalletDTO walletDTO){ walletService.addWallet(walletDTO); }

    @PatchMapping ("/modify-amount/{id}")
    @CrossOrigin
    public void modifyWalletAmount(@PathVariable long id, double amount){ walletService.modifyAmount(id, amount); }

}
