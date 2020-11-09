
import java.util.ArrayList;

public class Item
{
	private String itemName;
	private String itemDesc;
	private String itemLocation;
	private static ArrayList<Item> itemItems = new ArrayList<Item>();

	private int count;

	public Item(String itemName2, String itemDesc2, String itemLocation2)
	{

	}

	public Item()
	{
		super();

	}

	public void Items(String itemName, String itemDesc, String itemLocation)
	{

		this.itemName = itemName;
		this.itemDesc = itemDesc;
		this.itemLocation = itemLocation;
	}

	public String getItemName()
	{
		return itemName;
	}

	public void setItemName(String itemName)
	{
		this.itemName = itemName;
	}

	public String getItemDesc()
	{
		return itemDesc;
	}

	public void setItemDesc(String itemDesc)
	{
		this.itemDesc = itemDesc;
	}

	public String getItemLocation()
	{
		return itemLocation;
	}

	public void setItemLocation(String itemLocation)
	{
		this.itemLocation = itemLocation;
	}

	public static void addItem(Item i)
	{
		itemItems.add(i);
	}

	public static void removeItem(Item i)
	{
		itemItems.remove(i);
	}

	public static ArrayList<Item> getItemItems()
	{
		return itemItems;
	}

	public void examineItem(String item)
	{
		for (int i = 0; i < getItemItems().size(); i++)
		{
			if (item.equalsIgnoreCase(getItemItems().get(i).getItemName()))
			{
				System.out.println(getItemItems().get(i).getItemDesc());
			}
		}
		for (int i = 0; i < player.getInventory().size(); i++)
		{
			if (item.equalsIgnoreCase(player.getInventory().get(i).getItemName()))
			{
				System.out.println(player.getInventory().get(i).getItemDesc());
			}
		}
	}

	public void pickUp(String item)
	{
		count = 0;
		for (int i = 0; i < getItemItems().size(); i++)
		{
			if (item.equalsIgnoreCase(getItemItems().get(i).getItemName()))
			{
				player.getInventory().add(getItemItems().get(i));
				removeItem(getItemItems().get(i));
				for (i = 0; i < player.getInventory().size(); i++)
				{
					if (item.equalsIgnoreCase(player.getInventory().get(i).getItemName()))
					{
						System.out.println(player.getInventory().get(i).getItemName()
								+ " has been picked up and has been added to your inventory.");
					}
				}
				for (i = 0; i < getItemItems().size(); i++)
				{

					if (Map.getRoomItems().get(player.getPlayerLocation()).hasItem())
					{
						if (Map.getRoomItems().get(player.getPlayerLocation()).getRoomNum()
								.equals(getItemItems().get(i).getItemLocation()))
						{
							count++;
						}
						if (count == 0)
						{
							Map.getRoomItems().get(player.getPlayerLocation()).setItem(false);
						}
					}
				}
				if (getItemItems().size() == 0)
				{
					Map.getRoomItems().get(player.getPlayerLocation()).setItem(false);
				}
			}
		}
	}

	public void drop(String item)
	{
		count = 0;
		for (int i = 0; i < player.getInventory().size(); i++)
		{
			if (item.equalsIgnoreCase(player.getInventory().get(i).getItemName()))
			{
				addItem(player.getInventory().get(i));
				player.getInventory().get(i)
						.setItemLocation(Map.getRoomItems().get(player.getPlayerLocation()).getRoomNum());
				player.getInventory().remove(i);
				for (i = 0; i < getItemItems().size(); i++)
				{
					if (item.equalsIgnoreCase(getItemItems().get(i).getItemName()))
					{
						System.out.println(getItemItems().get(i).getItemName()
								+ " has been dropped from your inventory and been placed in the "
								+ Map.getRoomItems().get(player.getPlayerLocation()).getDesc());
					}
					if (Map.getRoomItems().get(player.getPlayerLocation()).hasItem() == false)
					{
						if (Map.getRoomItems().get(player.getPlayerLocation()).getRoomNum()
								.equals(getItemItems().get(i).getItemLocation()))
						{
							count++;
						}
						if (count > 0)
						{
							Map.getRoomItems().get(player.getPlayerLocation()).setItem(true);
						}
					}
				}
			}
		}
	}
}