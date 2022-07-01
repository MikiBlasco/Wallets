package com.example.wallets.service;

import com.example.wallets.models.User;
import com.example.wallets.models.Wallet;
import com.example.wallets.repositories.UserRepository;
import com.example.wallets.repositories.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired UserRepository userRepository;
    @Autowired WalletRepository walletRepository;

    public List<User> getAllUsers(){
       return userRepository.findAll();
    }

    public User getUserById(long id, UserDetails userDetails){
        if(userRepository.findById(id).isPresent()){
            return userRepository.findById(id).get();
        } else {
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public User updateUser(User user, long id, UserDetails userDetails){
        if(userRepository.findById(id).isPresent()){
            User userToUpdate = userRepository.findById(id).get();
            userToUpdate.setMail(user.getMail());
            userToUpdate.setName(user.getName());
            userToUpdate.setPassword(user.getPassword());
            userRepository.save(userToUpdate);
            return userToUpdate;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    public User updateName(String name, long id, UserDetails userDetails){
        if(userRepository.findById(id).isPresent()){
            User userToUpdate = userRepository.findById(id).get();
            userToUpdate.setName(name);
            userRepository.save(userToUpdate);
            return userToUpdate;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public User updateMail(String mail, long id, UserDetails userDetails){
        if(userRepository.findById(id).isPresent()){
            User userToUpdate = userRepository.findById(id).get();
            userToUpdate.setMail(mail);
            userRepository.save(userToUpdate);
            return userToUpdate;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }


    public User createUser(User user, UserDetails userDetails){
        User newUser = new User(user.getName(), user.getMail(), passwordEncoder.encode(user.getPassword()));
        userRepository.save(newUser);
        return newUser;
    }

    public void deleteUserWallets(long id, UserDetails userDetails){
        if(userRepository.findById(id).isPresent()){
            User user = userRepository.findById(id).get();
            List<Wallet> walletsToDelete =  user.getWalletList();
            walletRepository.deleteAll(walletsToDelete);

        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public void deleteUser(long id, UserDetails userDetails){
        if(userRepository.findById(id).isPresent()){
            User userToDelete = userRepository.findById(id).get();
            userRepository.delete(userToDelete);

        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }




}
