public class GameWorld {

    private String name;
    private Player[] players;
    private Enemy[] enemies;
    private int difficulty; // 1-3

    public GameWorld() {
        this.name = "Crystalpath";
        this.players = new Player[0];
        this.enemies = new Enemy[0];
        this.difficulty = 1;
    }

    public GameWorld(String name, int difficulty, Player[] players, Enemy[] enemies) {
        this.name = name;
        this.difficulty = difficulty;

        this.players = new Player[players.length];
        for (int i = 0; i < players.length; i++) {
            this.players[i] = players[i];
        }

        this.enemies = new Enemy[enemies.length];
        for (int i = 0; i < enemies.length; i++) {
            this.enemies[i] = enemies[i];
        }
    }

    public void addPlayer(Player player) {
        Player[] newArr = new Player[players.length + 1];
        for (int i = 0; i < players.length; i++) {
            newArr[i] = players[i];
        }
        newArr[players.length] = player;
        players = newArr;
    }

    public void printAllPlayers() {
        for (int i = 0; i < players.length; i++) {
            System.out.println("------- Player " + (i + 1) + " -------");
            System.out.println(players[i].toString());
        }
    }

    public int getTotalValueOfWorld() {
        int total = 0;
        for (int i = 0; i < players.length; i++) {
            total += players[i].calculateInventoryValue();
        }
        return total;
    }

    @Override
    public String toString() {
        return "World Name: " + name + "\n" +
               "Difficulty: " + difficulty + "\n" +
               "Number of players: " + players.length;
    }

}
