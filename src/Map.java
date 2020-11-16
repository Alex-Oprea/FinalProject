
import java.util.*;

public class Map
{

	private static ArrayList<room> roomItems = new ArrayList<room>();

	public static void addRoom(room r)
	{
		roomItems.add(r);
	}

	public static ArrayList<room> getRoomItems()
	{
		return roomItems;
	}

	public void getRoom(String direction)
	{
		if (direction.equals("0"))
		{

			System.out.println(" You cannot go in this direction! Try typing in a different direction.");
		} else if (direction != "0")
		{
			int location = Integer.parseInt(direction) - 1;
			if (roomItems.get(location).isVisited())
			{
				System.out.println("This room looks familiar...");
			}
			if (direction.equals(roomItems.get(location).getRoomNum()))
			{

				player.setPlayerLocation(location);
			}
		}
	}

	public void examineRoom(String item)
	{
			System.out.println("You are in the: " + Map.getRoomItems().get(player.getPlayerLocation()).getDesc());
			if (Map.getRoomItems().get(player.getPlayerLocation()).hasItem())
			{
				System.out.println("The item(s) in this room: ");
				System.out.print("[");
				for (int i = 0; i < Item.getItemItems().size(); i++)
				{

					if (Map.getRoomItems().get(player.getPlayerLocation()).getRoomNum()
							.equals(Item.getItemItems().get(i).getItemLocation()))
					{

						System.out.print(" \"" + Item.getItemItems().get(i).getItemName() + "\"");
					}
				}
				System.out.println(" ]");
			} else
			{
				System.out.println("This room is empty.");
			}

	}
}