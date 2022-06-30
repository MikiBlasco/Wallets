package com.example.wallets;


import com.example.wallets.models.User;
import com.example.wallets.models.Wallet;
import com.example.wallets.repositories.UserRepository;
import com.example.wallets.repositories.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class WalletsApplication implements CommandLineRunner {

	PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@Autowired
	UserRepository userRepository;
	@Autowired
	WalletRepository walletRepository;

	public static void main(String[] args) {
		SpringApplication.run(WalletsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{

		User user1 = new User("Jeff", "jeff@gmail.com", passwordEncoder.encode("1234"));
		userRepository.save(user1);
		User user2 = new User("Barret", "barret@gmail.com", passwordEncoder.encode("1234"));
		userRepository.save(user2);
		User user3 = new User("Joe", "joe@gmail.com", passwordEncoder.encode("1234"));
		userRepository.save(user3);
		Wallet wallet1 = new Wallet("BTC", 3.00, user1);
		walletRepository.save(wallet1);
		userRepository.save(user1);
		Wallet wallet2 = new Wallet("ETH", 1.5, user1);
		walletRepository.save(wallet2);
		userRepository.save(user1);
		Wallet wallet3 = new Wallet("ADA", 500.00, user1);
		walletRepository.save(wallet3);
		userRepository.save(user1);
		Wallet wallet4 = new Wallet("ETH", 15.00, user2);
		walletRepository.save(wallet4);
		userRepository.save(user2);
		Wallet wallet5 = new Wallet("BTC", 2.00, user2);
		walletRepository.save(wallet5);
		userRepository.save(user2);
		Wallet wallet6 = new Wallet("ADA", 3000.00, user3);
		walletRepository.save(wallet6);
		userRepository.save(user3);

	}

}
