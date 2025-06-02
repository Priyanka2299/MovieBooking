package com.lld.MovieBookingSystem;

import com.lld.MovieBookingSystem.controllers.BookingController;
import com.lld.MovieBookingSystem.controllers.UserController;
import com.lld.MovieBookingSystem.dtos.BookTicketRequestDTO;
import com.lld.MovieBookingSystem.dtos.BookTicketResponseDTO;
import com.lld.MovieBookingSystem.dtos.SignUpRequestDTO;
import com.lld.MovieBookingSystem.dtos.SignUpResponseDTO;
import com.lld.MovieBookingSystem.models.Feature;
import com.lld.MovieBookingSystem.models.Region;
import com.lld.MovieBookingSystem.models.Screen;
import com.lld.MovieBookingSystem.models.Theatre;
import com.lld.MovieBookingSystem.repositories.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;

@SpringBootApplication
@EnableJpaAuditing
public abstract class MovieBookingSystemApplication implements CommandLineRunner {
	UserController userController;
	BookingController bookingController;
	RegionRepository regionRepository;

	@Autowired
 	MovieBookingSystemApplication(UserController userController,
								  BookingController bookingController,
								  RegionRepository regionRepository){
		this.userController = userController;
		this.bookingController = bookingController;
		this.regionRepository = regionRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		SignUpRequestDTO requestDTO = new SignUpRequestDTO();
		requestDTO.setEmail("priyankakushwaha229@gmail.com");
		requestDTO.setPassword("priyanka");

		SignUpResponseDTO responseDTO = userController.signUp(requestDTO);
		System.out.println(responseDTO.getMessage());

		loadDataForBookTicket();

		BookTicketRequestDTO requestDTO2 = new BookTicketRequestDTO();
		requestDTO2.setShowId(1);
		requestDTO2.setShowSeatIds(List.of(1, 2, 3));
		requestDTO2.setUserId(1);

		BookTicketResponseDTO responseDTO1 = bookingController.bookTicket(requestDTO2);

	}

	public void loadDataForBookTicket(){
		Region region = new Region();
		region.setRegionName("Bangalore");
		regionRepository.save(region);

		Theatre theatre = new Theatre();
		theatre.setRegion(region);
		theatre.setTheatreName("PVR : Director's cut");
		theatre.setTheatreAddress("Church Street, MG Road");
		//theatrerepository
		Screen screen = new Screen();
		screen.setTheatre(theatre);
		screen.setScreenName("Screen 1");
		screen.setFeatures(List.of(Feature.TWO_D));
		//screenrepository


	}
	public static void main(String[] args) {

		SpringApplication.run(MovieBookingSystemApplication.class, args);
	}

}
