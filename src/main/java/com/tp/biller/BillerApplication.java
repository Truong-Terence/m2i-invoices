package com.tp.biller;

import com.tp.biller.entity.User;
import com.tp.biller.repository.BillRepository;
import com.tp.biller.repository.CustomerRepository;
import com.tp.biller.repository.ProductRepository;
import com.tp.biller.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@EnableJpaRepositories("com.tp.biller.repository")
@ComponentScan("com.tp.biller.service")
@ComponentScan("com.tp.biller.controller")
@ComponentScan("com.tp.biller.entity")
@ComponentScan("com.tp.biller.security")
@SpringBootApplication
public class BillerApplication {
	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(BillerApplication.class, args);
	}

//	@Bean
//	CommandLineRunner start(UserRepository userRepository, CustomerRepository customerRepository, ProductRepository productRepository, BillRepository billRepository) {
//		return args -> {
//			User user = new User();
//			user.setEmail("admin@my-invoice.fr");
//			user.setPassword(passwordEncoder.encode("qwerty"));
//			userRepository.save(user);
//		};
//	}


//	INSERT INTO user (email, password) VALUES ('admin@my-invoice.fr', 'qwerty');
//	INSERT INTO customer (company, address, phone) VALUES ('John Factory', '1589 Rue Principale, Saint-Amable, QC J0L 1N0, Canada', '+14388214666');
//	INSERT INTO customer (company, address, phone) VALUES ('Jane Factory', '1992 Seymour St, North Bay, ON P1A 0E3, Canada', '+17054767369');
//	INSERT INTO product (name, description, priceHT) VALUES ('Palmier Areca Dyspis Lutescens', 'The well-known and extremely popular Areca Dypsis Lutescens palm originates from the humid tropics of Madagascar. In the wild, the Areca palm can reach 12 meters in height.', 39.99);
//	INSERT INTO product (name, description, priceHT) VALUES ('Monstera Deliciosa', 'The Monstera Deliciosa, from the Araceae family, is making a comeback in our interiors and is part of the decor trends. Its large oval-shaped leaves are cut and give it a very original appearance.', 29.99);
//	INSERT INTO bill (billing_date, due_date, payment, id_customer, id_product) VALUES (NOW(), DATE_ADD(NOW(), INTERVAL 1 MONTH ), 'cash', 1, 1 );
//	INSERT INTO bill (billing_date, due_date, payment, id_customer, id_product) VALUES (NOW(), DATE_ADD(NOW(), INTERVAL 1 MONTH ), 'CB', 2, 2 );

}
