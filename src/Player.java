import java.util.ArrayList;

public class Player extends Character {

    private ArrayList<Item> inventory;

    public Player(String name, int health, int level) {
        super(name, health, level);
        this.inventory = new ArrayList<>();
    }

    public Player(String name, int health, int level, ArrayList<Item> inventory) {
        super(name, health, level);
        this.inventory = new ArrayList<>(inventory);
    }

    public void addItem(Item item) {
        inventory.add(item);
    }

    public int calculateInventoryValue() {
        int val = 0;
        for (int i = 0; i < inventory.size(); i++) {
            val += inventory.get(i).getValue();
        }
        return val;
    }

    public boolean hasMagicalItem() {
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).isMagical())
                return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String items = "";
        for (int i = 0; i < inventory.size(); i++) {
            items += inventory.get(i).getName();
            if (i < inventory.size() - 1) {
                items += " | ";
            }
        }
        return super.toString() + "\nInventory: " + items + "\n" + "Inventory value: " + calculateInventoryValue();
    }
}
