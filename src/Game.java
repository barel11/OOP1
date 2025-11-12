import java.util.ArrayList;

public class Game {

	public static void main(String[] args) {
		
		Item sword = new Item("Knight" , 150 , true);
		Item bow = new Item("Bow" , 250 , false);
		Item gun = new Item("Glock 47" , 500 , false);
		
		Player human1 = new Player("Dave" , 10 , 2);
		Player human2 = new Player("John" , 10 , 5);
		
		human1.addItem(sword);
		human1.addItem(bow);
		human2.addItem(gun);
		
		Enemy enemy = new Enemy("Goblin" , 10 , 1  , 2);
		
		ArrayList<Player> players = new ArrayList<>();
		players.add(human1);
		players.add(human2);
		
		ArrayList<Enemy> enemies = new ArrayList<>();
		enemies.add(enemy);
		
		GameWorld game = new GameWorld("peaceWorld" , 1 , players , enemies);
		
		game.printAllPlayers();
		
		simulateBattle(human1 , enemy);
		
	}
	
	public static void simulateBattle(Player player , Enemy enemy) {
		System.out.println("\n" + player.getName() + " - level : " + player.getLevel() + " VS " + enemy.getName() + "- level : " + enemy.getLevel()) ;
		if (player.getLevel() < enemy.getLevel()) {
			enemy.levelUp();
			System.out.println(enemy.getName() + " Wins!");
		}
		else
			player.levelUp();
		System.out.println(player.getName() + " Wins!");

	}

}
