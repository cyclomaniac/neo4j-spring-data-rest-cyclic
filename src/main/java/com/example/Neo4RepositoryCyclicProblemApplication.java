package com.example;

import com.example.domain.Player;
import com.example.domain.PlayerPosition;
import com.example.domain.Team;
import com.example.repositories.PlayerRepository;
import com.example.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Neo4RepositoryCyclicProblemApplication implements ApplicationListener<ApplicationReadyEvent>{

	@Autowired
	private PlayerRepository playerRepository;

	@Autowired
	private TeamRepository teamRepository;

	public static void main(String[] args) {
		SpringApplication.run(Neo4RepositoryCyclicProblemApplication.class, args);
	}


	@Override
	public void onApplicationEvent(ApplicationReadyEvent applicationStartedEvent) {
		Team cubs = new Team("Cubs");
		PlayerPosition secondBase = new PlayerPosition("Second Base", cubs);
		Player zobrist = new Player("Zobrist", "18");
		zobrist.setPosition(secondBase);

		playerRepository.save(zobrist);
		playerRepository.save(new Player("Fowler", "24", new PlayerPosition("Center Field", cubs)));
		playerRepository.save(new Player("Heyward", "22", new PlayerPosition("Right Field", cubs)));
		playerRepository.save(new Player("Ross", "2", new PlayerPosition("Catcher", cubs)));
	}

	@GetMapping("/play/{id}")
	public Player getPlayer(@PathVariable("id") Long id) {
		return playerRepository.findOne(id);
	}


}
