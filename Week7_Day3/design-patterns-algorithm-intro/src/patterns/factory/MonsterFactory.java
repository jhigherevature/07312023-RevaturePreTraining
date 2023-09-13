package patterns.factory;

/*
 * The Factory Design pattern is used to instantiate and return an implementation of
 * an interface during runtime.
 */
public class MonsterFactory {
	public Monster getMonster(String monsterType) {
		if (monsterType == null) {
			System.out.println("Provide a valid Monster Type");
			return null;
		}
		
		switch (monsterType.toUpperCase()) {
			case "CENTAUR": return new Centaur();
			case "DRAGON": return new Dragon();
			case "GOBLIN": return new Goblin();
			case "HYDRA": return new Hydra();
		}
		
		return null;
	}
}
