public class Character {

	private String name;
	private int health; // 0 - 10
	private int level; // 0 - 5

	public Character() {
		this.name = "Unknown";
		this.health = 0;
		this.level = 0;
	}

	public Character(String name, int health, int level) {
		this.name = name;

		if (health > 10) {
			this.health = 10;
			System.out.println("Health cannot be higher then 10. Health has been set to 10");
		} else if (health < 0) {
			this.health = 0;
			System.out.println("Health cannot be lower then 0. Health has been set to 0");
		} else
			this.health = health;

		if (level > 5) {
			this.level = 5;
			System.out.println("Level cannot be higher then 5. Health has been set to 5");
		} else if (level < 0) {
			this.level = 0;
			System.out.println("Level cannot be lower then 0. level has been set to 5");
		} else
			this.level = level;

	}

	public String getName() {
		return name;
	}

	public int getHealth() {
		return health;
	}

	public int getLevel() {
		return level;
	}

	public void levelUp() {
		if (this.level >= 5)
			System.out.println("Max level!");
		else
			level++;
	}

	public void heal(int amount) {
		if (health + amount > 10)
			health = 10;
		else
			health += amount;
	}

	@Override
	public String toString() {
		return "Name: " + name + "\n" + "Health: " + health + "\n" + "Level: " + level;

	}

}
