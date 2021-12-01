package com.codemerchant.sufficient365;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.codemerchant.sufficient365.domain.Crop;
import com.codemerchant.sufficient365.domain.CropRepository;
import com.codemerchant.sufficient365.domain.MyCrops;
import com.codemerchant.sufficient365.domain.MyCropsRepository;
import com.codemerchant.sufficient365.domain.User;
import com.codemerchant.sufficient365.domain.UserRepository;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class Sufficient365Application {

	private final CropRepository cropRepository;

	private final UserRepository userRepository;

	private final SudoUserRepository sudoUserRepository;

	private final MyCropsRepository cropsRepository;

	public static void main(String[] args) {
		SpringApplication.run(Sufficient365Application.class, args);

	}

	@Bean

	CommandLineRunner runner() {
		String rodade = "An open-pollinated determinate tomato plant which can grow up to 1,5 metres.";
		String crimson = "Sporting an outer shell that has dark"
				+ " and light green striping as well as deep red inner flesh, Crimson Sweet is"
				+ " very sweet watermelon with a sugar content of 12%. ";
		return args -> {

			User caleb = new User("Barry", "Bonds");
			User john = new User("John", "Wick");

			userRepository.save(caleb);
			userRepository.save(john);

			Crop crop1 = new Crop("Tomato", "Rodade", rodade, "direct", "Spring,Summer", 7, 14, 80, 90, "Full",
					"horn worm", john);

			cropRepository.save(crop1);

			Crop crop2 = new Crop("Watermelon", "Crimson Sweet", crimson, "direct, trays", "Spring, Summer", 10, 14, 80,
					90, "Full", "snails, cutworm", caleb);
			cropRepository.save(crop2);

			// username = user, password = user

			sudoUserRepository
					.save(new SudoUser("user", "$2a$12$wzO9aZ2WAbAL02Af7zMKq.MOlxcSmoaLQPXL8ytbDyfM.N4BD210u", "USER"));

			// username = admin , password = admin

			sudoUserRepository.save(
					new SudoUser("admin", "$2a$12$800ionWwCs77Cf.B0uq0yuR1GNXVFKOa.ogi7afjcSIV9MuULUlxu", "ADMIN"));

			cropsRepository.save(new MyCrops(john,crop1));
		};
	}

}
