import java.util.ArrayList;

public class GameWorld {

    private String name;
    private ArrayList<Player> players;
    private ArrayList<Enemy> enemies;
    private int difficulty; // 1-3

    public GameWorld() {
        this.name = "Crystalpath";
        this.players = new ArrayList<>();
        this.enemies = new ArrayList<>();
        this.difficulty = 1;
    }

    public GameWorld(String name, int difficulty, ArrayList<Player> players, ArrayList<Enemy> enemies) {
        this.name = name;
        this.difficulty = difficulty;
        this.players = new ArrayList<>(players);
        this.enemies = new ArrayList<>(enemies);
    }

    public void addPlayer(Player player) {
        players.add(player);
    }
    
    public void printAllPlayers() {
        for (int i = 0; i < players.size(); i++) {
            System.out.println("------- Player " + (i + 1) + " -------");
            System.out.println(players.get(i).toString());
        }
    }
    
    public int getTotalValueOfWorld() {
    	int total = 0;
    	for(int i = 0 ; i < players.size() ; i++) {
    		total += players.get(i).calculateInventoryValue();
    	}
    	return total;
    }
    
    @Override
    public String toString() {
    	return "World Name: " + name + "\n" + "Difficulty: " + difficulty + "\n" +
    			"Number of players: " + players.size();
    }

}
