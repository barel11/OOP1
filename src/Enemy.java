public class Enemy extends Character{
	
	private int damage; // 1-5
	
	public Enemy(String name , int health , int level , int damage) {
		super(name , health , level);
		if (damage > 5) {
			this.damage = 5;
			System.out.println("Damage cannot be higher then 5. Damage has been set to 5");
		} else if (damage < 0) {
			this.damage = 1;
			System.out.println("Damage cannot be lower then 1. Damage has been set to 1");
		} else
			this.damage = damage;
	}
	
	public int getDamage() {
		return damage;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\n" + "Damage: " + damage;
	}
}
