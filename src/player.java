import java.util.ArrayList;

public class player
{

	int playerHp = 100;
	int playerAttack = 20;
	public static final String Item = null;
	private static int roomId;

	private static ArrayList<Item> inventory = new ArrayList<Item>();

	Item item = new Item();

	help help = new help();

	Monster monster = new Monster();

	navigation navigation = new navigation();

	Map map = new Map();

	Puzzle puzzle = new Puzzle();

	public static void setPlayerLocation(int x)
	{
		roomId = x;
	}

	public static int getPlayerLocation()
	{
		return roomId;
	}

	public static ArrayList<Item> getInventory()
	{
		return inventory;
	}

	public void examineInventory(String item)
	{
		if (item.equalsIgnoreCase("inventory"))
		{
			if (getInventory().size() == 0)
			{
				System.out.println("Your inventory is empty.");
			} else
			{
				System.out.println("The item(s) in your inventory: ");
				System.out.print("[");
				for (int i = 0; i < getInventory().size(); i++)
				{
					System.out.print(" \"" + getInventory().get(i).getItemName() + "\"");
				}
				System.out.println(" ]");
			}
		}
	}
}