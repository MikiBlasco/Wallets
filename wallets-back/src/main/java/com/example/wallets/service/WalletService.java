package com.example.wallets.service;

import com.example.wallets.models.DTO.WalletDTO;
import com.example.wallets.models.User;
import com.example.wallets.models.Wallet;
import com.example.wallets.repositories.UserRepository;
import com.example.wallets.repositories.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class WalletService {

    @Autowired UserRepository userRepository;
    @Autowired WalletRepository walletRepository;


    public Wallet addWallet(WalletDTO walletDTO, UserDetails userDetails){
        if(userRepository.findById(walletDTO.getUser_id()).isPresent()){
            User userFound = userRepository.findById(walletDTO.getUser_id()).get();
            Wallet newWallet = new Wallet(walletDTO.getCurrency_name(), walletDTO.getCurrency_amount(), userFound);
            walletRepository.save(newWallet);
            userRepository.save(userFound);
            return newWallet;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public Wallet modifyAmount(long id, double amount, UserDetails userDetails){
        if(walletRepository.findById(id).isPresent()){
            Wallet walletToUpdate = walletRepository.findById(id).get();
            walletToUpdate.setCurrency_amount(amount);
            walletRepository.save(walletToUpdate);
            return walletToUpdate;

        } else {
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    public void deleteWallet(long id, UserDetails userDetails){
        if(walletRepository.findById(id).isPresent()){
            Wallet walletToDelete = walletRepository.findById(id).get();
            walletRepository.delete(walletToDelete);

        } else {
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}
