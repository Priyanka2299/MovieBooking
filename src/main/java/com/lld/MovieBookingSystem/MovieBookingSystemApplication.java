package com.lld.MovieBookingSystem;

import com.lld.MovieBookingSystem.controllers.UserController;
import com.lld.MovieBookingSystem.dtos.SignUpRequestDTO;
import com.lld.MovieBookingSystem.dtos.SignUpResponseDTO;
import com.lld.MovieBookingSystem.models.Feature;
import com.lld.MovieBookingSystem.models.Region;
import com.lld.MovieBookingSystem.models.Screen;
import com.lld.MovieBookingSystem.models.Theatre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;

@SpringBootApplication
@EnableJpaAuditing
public abstract class MovieBookingSystemApplication implements CommandLineRunner {
	@Autowired
	UserController userController;

	@Override
	public void run(String... args) throws Exception {
		SignUpRequestDTO requestDTO = new SignUpRequestDTO();
		requestDTO.setEmail("priyankakushwaha229@gmail.com");
		requestDTO.setPassword("priyanka");

		SignUpResponseDTO responseDTO = userController.signUp(requestDTO);
		System.out.println(responseDTO.getMessage());

		loadDataForBookTicket();
	}

	public static void loadDataForBookTicket(){
		Region region = new Region();
		region.setRegionName("Bangalore");

		Theatre theatre = new Theatre();
		theatre.setRegion(region);
		theatre.setTheatreName("PVR : Director's cut");
		theatre.setTheatreAddress("Church Street, MG Road");

		Screen screen = new Screen();
		screen.setTheatre(theatre);
		screen.setScreenName("Screen 1");
		screen.setFeatures(List.of(Feature.TWO_D));


	}
	public static void main(String[] args) {

		SpringApplication.run(MovieBookingSystemApplication.class, args);
	}

}
