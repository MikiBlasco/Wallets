package com.example.wallets.controllers;

import com.example.wallets.models.DTO.WalletDTO;
import com.example.wallets.models.Wallet;
import com.example.wallets.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
public class WalletController {

    @Autowired
    WalletService walletService;


    @PostMapping ("/add-wallet")
    @CrossOrigin
    public Wallet addWalletToUserPortfolio(@RequestBody WalletDTO walletDTO, @AuthenticationPrincipal UserDetails userDetails){
        return walletService.addWallet(walletDTO, userDetails);
    }

    @PatchMapping ("/modify-amount/{id}")
    @CrossOrigin
    public Wallet modifyWalletAmount(@PathVariable long id, @RequestParam double amount, @AuthenticationPrincipal UserDetails userDetails){
        return walletService.modifyAmount(id, amount, userDetails);
    }

    @DeleteMapping ("/delete-wallet/{id}")
    @CrossOrigin
    public void deleteWallet(@PathVariable long id, @AuthenticationPrincipal UserDetails userDetails){
        walletService.deleteWallet(id, userDetails);
    }

}
