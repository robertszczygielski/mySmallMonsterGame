package org.game.monsters;

import org.game.monsters.dto.Monster;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class MonstersApplication {

	public static void main(String[] args) {
		Monster monster = new Monster(UUID.randomUUID(), "Big Ant");

		System.out.println(monster);
	}

//	public static void main(String[] args) {
//		SpringApplication.run(MonstersApplication.class, args);
//	}

}
