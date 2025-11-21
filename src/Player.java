public class Player extends Character {

    private Item[] inventory;

    public Player(String name, int health, int level) {
        super(name, health, level);
        this.inventory = new Item[0];
    }

    public Player(String name, int health, int level, Item[] inventory) {
        super(name, health, level);

        this.inventory = new Item[inventory.length];
        for (int i = 0; i < inventory.length; i++) {
            this.inventory[i] = inventory[i];
        }
    }

    public void addItem(Item item) {
        Item[] newArr = new Item[inventory.length + 1];
        for (int i = 0; i < inventory.length; i++) {
            newArr[i] = inventory[i];
        }
        newArr[inventory.length] = item;
        inventory = newArr;
    }

    public int calculateInventoryValue() {
        int val = 0;
        for (int i = 0; i < inventory.length; i++) {
            val += inventory[i].getValue();
        }
        return val;
    }

    public boolean hasMagicalItem() {
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i].isMagical())
                return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String items = "";
        for (int i = 0; i < inventory.length; i++) {
            items += inventory[i].getName();
            if (i < inventory.length - 1) {
                items += " | ";
            }
        }
        return super.toString() + "\nInventory: " + items + "\n" +
               "Inventory value: " + calculateInventoryValue();
    }
}
