package com.codeclan.example.PirateService;

import com.codeclan.example.PirateService.models.Pirate;
import com.codeclan.example.PirateService.models.Raid;
import com.codeclan.example.PirateService.models.Ship;
import com.codeclan.example.PirateService.repositories.PirateRepository;
import com.codeclan.example.PirateService.repositories.RaidRepository;
import com.codeclan.example.PirateService.repositories.ShipRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PirateServiceApplicationTests {

//	this is what will generate an instance of pirateRepository to then do dependency injection into the jpa repository
//	autowired is always at the top of the class
	@Autowired
	PirateRepository pirateRepository;

	@Autowired
	ShipRepository shipRepository;

	@Autowired
	RaidRepository raidRepository;

//	could do an @Before with pirateRepository.deleteAll() in it


	@Test
	public void contextLoads() {
	}
//
//	@Test
//	public void canCreatePirate() {
//		pirateRepository.deleteAll();
//		Pirate jack = new Pirate("Jack", "Sparrow", 32);
//		pirateRepository.save(jack);
////		to get all pirates back you'd use
////		List<Pirate> allPirates = pirateRepository.findAll();
////		you could then use assertEquals(1, allPirates.size()); (though you'd need to run a delete first
////		remember it would add the same object again
//	}

//	@Test
//	public void canCreatePirateAndShip() {
//		Ship ship1 = new Ship("The Flying Dutchman");
//		shipRepository.save(ship1);
//		Pirate pirate1 = new Pirate("Jack", "Sparrow", 32, ship1);
//		pirateRepository.save(pirate1);
//	}

	@Test
	public void pirateCanGoOnRaid() {
		Ship ship2 = new Ship("Marie Celeste");
		shipRepository.save(ship2);
		Pirate pirate2 = new Pirate("Joe", "Bloggs", 57, ship2);
		Raid raid = new Raid("Bermuda", 100);
		ArrayList<Raid> raids = new ArrayList<>();
		raids.add(raid);
		pirate2.setRaids(raids);
		pirateRepository.save(pirate2);
	}
}
