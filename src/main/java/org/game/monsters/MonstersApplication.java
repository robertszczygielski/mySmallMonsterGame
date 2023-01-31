package org.game.monsters;

import org.game.monsters.configuration.MonsterConfiguration;
import org.game.monsters.dto.Monster;
import org.game.monsters.service.GameService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class MonstersApplication {

	public static void main(String[] args) {
		GameService gameService = new GameService();

		for(;;) {
			boolean playing = gameService.play();
			if (!playing) break;
		}

	}

//	public static void main(String[] args) {
//		SpringApplication.run(MonstersApplication.class, args);
//	}

}
