package org.game.monsters;

import org.game.monsters.configuration.MonsterConfiguration;
import org.game.monsters.dto.Monster;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class MonstersApplication {

	public static void main(String[] args) {
		MonsterConfiguration monsterConfiguration = new MonsterConfiguration();
		List<Monster> monsters = monsterConfiguration.getMonsters();

		for (Monster monster: monsters) {
			System.out.println(monster);
		}
	}

//	public static void main(String[] args) {
//		SpringApplication.run(MonstersApplication.class, args);
//	}

}
