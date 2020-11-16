import java.util.*;
import java.io.*;

public class Driver
{
	public static void main(String[] args)
	{

		player player = new player();
		//int playerHP = 10;
		//int playerAttk = 20;
		boolean hasPotion = false;
		// open text file
		File roomFile = new File("RoomMap.txt");
		// open a Scanner to read data from File
		Scanner roomReader = null;
		try
		{
			roomReader = new Scanner(roomFile);
		} catch (FileNotFoundException e)
		{
			System.out.println("The RoomMap.txt file has not been found");
		}

		while (roomReader != null && roomReader.hasNext())
		{

			String roomNum = roomReader.nextLine();
			String desc = roomReader.nextLine();
			String visitedString = roomReader.nextLine();
			boolean visited = Boolean.parseBoolean(visitedString);
			String itemString = roomReader.nextLine();
			boolean item = Boolean.parseBoolean(itemString);
			String puzzleString = roomReader.nextLine();
			boolean puzzle = Boolean.parseBoolean(puzzleString);
			String monsterString = roomReader.nextLine();
			boolean monster = Boolean.parseBoolean(monsterString);
			String north = roomReader.nextLine();
			String east = roomReader.nextLine();
			String south = roomReader.nextLine();
			String west = roomReader.nextLine();

			room room = new room(roomNum, desc, visited, item, puzzle, monster, north, east, south, west);
			Map.addRoom(room);
		}
		// open text file
		File itemFile = new File("Items.txt");
		// open a Scanner to read data from File
		Scanner itemReader = null;
		try
		{
			itemReader = new Scanner(itemFile);
		} catch (FileNotFoundException e)
		{
			System.out.println("The Items.txt file has not been found");
		}

		while (itemReader != null && itemReader.hasNext())
		{

			String itemName = itemReader.nextLine();
			String itemDesc = itemReader.nextLine();
			String itemLocation = itemReader.nextLine();

			Item item = new Item(itemName, itemDesc, itemLocation);
			Item.addItem(item);
		}

		File puzzleFile = new File("Puzzles.txt");

		Scanner puzzleReader = null;
		try
		{
			puzzleReader = new Scanner(puzzleFile);
		} catch (FileNotFoundException e)
		{
			System.out.println("The Puzzles.txt file has not been found");
		}
		while (puzzleReader != null && puzzleReader.hasNext())
		{

			String puzzleLocation = puzzleReader.nextLine();
			String question = puzzleReader.nextLine();
			String answer = puzzleReader.nextLine();
			String attempts = puzzleReader.nextLine();

			Puzzle puzzle = new Puzzle(puzzleLocation, question, answer, attempts);
			Puzzle.addPuzzle(puzzle);
		}

		File monsterFile = new File("Monsters.txt");

		Scanner monsterReader = null;
		try
		{
			monsterReader = new Scanner(monsterFile);
		}catch (FileNotFoundException e)
		{
			System.out.println("The Monster.txt file has not been found");
		}
		while (monsterReader != null && monsterReader.hasNext())
		{
			String monsterLocation = monsterReader.nextLine();
			String monsterName = monsterReader.nextLine();
			String monsterDesc = monsterReader.nextLine();
			String monsterHp = monsterReader.nextLine();
			String monsterAttk = monsterReader.nextLine();

			Monster monster = new Monster(monsterLocation, monsterName, monsterDesc, monsterHp, monsterAttk);
			Monster.addMonster(monster);
		}

		File helpFile = new File("Help.txt");

		Scanner helpReader = null;
		try
		{
			helpReader = new Scanner(helpFile);
		} catch (FileNotFoundException e)
		{
			System.out.println("The Help.txt file has not been found");
		}

		while (helpReader != null && helpReader.hasNext())
		{
			String command = helpReader.nextLine();

			help help = new help(command);
			extracted(help);
		}

		File navFile = new File("Navigation.txt");

		Scanner navReader = null;
		try
		{
			navReader = new Scanner(navFile);
		} catch (FileNotFoundException e)
		{
			System.out.println("The Navigation.txt file has not been found");
		}

		while (navReader != null && navReader.hasNext())
		{
			String roomNav = navReader.nextLine();
			String beginningLine = navReader.nextLine();
			String nav = navReader.nextLine();
			String middleLine = navReader.nextLine();
			String header = navReader.nextLine();
			String north = navReader.nextLine();
			String east = navReader.nextLine();
			String south = navReader.nextLine();
			String west = navReader.nextLine();
			String endingLine = navReader.nextLine();

			navigation navi = new navigation(roomNav, beginningLine, nav, middleLine, header, north, east, south, west,
					endingLine);
			navigation.addNavigation(navi);
		}
		Scanner keyboard = new Scanner(System.in);

		int roomId = 0;
		boolean done = false;
		player.help.askHelp();

		while (!done)
		{
			while (Map.getRoomItems().get(roomId).hasPuzzle())
			{
				for (int i = 0; i < Puzzle.getPuzzleItems().size(); i++)
				{
					if (Map.getRoomItems().get(roomId).getRoomNum()
							.equals(Puzzle.getPuzzleItems().get(i).getPuzzleLocation()))
					{
						System.out.println(Puzzle.getPuzzleItems().get(i).getQuestion());
						System.out.println("To answer please type the response that is next to the number!");
						System.out.println("Or you can skip by typing 'skip'.");
						String input = keyboard.next();
						player.puzzle.solvePuzzle(input);
					}
				}
			}

			/*while(Map.getRoomItems().get(roomId).hasItem())
			{
				for (int i = 0; i < Item.getItemItems().size(); i++)
				{
					if (Map.getRoomItems().get(roomId).getRoomNum().equals(Item.getItemItems().get(i).getItemLocation()))
					{
						System.out.println("There is an item named: " +Item.getItemItems().get(i).getItemName());
					}
				}
			}*/

			System.out.println("You are currently in Room #" + Map.getRoomItems().get(roomId).getRoomNum());
			player.navigation.getNavigation(roomId);

			while (Map.getRoomItems().get(roomId).hasMonster())
			{
				for(int i = 0; i < Monster.getMonsterItems().size(); i++)
				{
					if (Map.getRoomItems().get(roomId).getRoomNum().equals(Monster.getMonsterItems().get(i).getMonsterLocation()))
					{
						System.out.println("There is a Monster in the room! Use the command 'fight' to interact with it.");
						System.out.println("But before you do that here are some helpful stats!: ");
						System.out.println("Name: " +Monster.getMonsterItems().get(i).getMonsterName());
						System.out.println("Description: " +Monster.getMonsterItems().get(i).getMonsterDesc());
						System.out.println("Health Points: " + Monster.getMonsterItems().get(i).getMonsterHp());
						System.out.println("Attack Power: " + Monster.getMonsterItems().get(i).getMonsterAttk());
					}
				}break;
			}


			String input = keyboard.next();
			if(input.equalsIgnoreCase("fight"))
			{
				player.monster.fightMonster();
			}
			if (input.equalsIgnoreCase("c"))
			{
				player.help.askHelp();
			} else if (input.equalsIgnoreCase("examine"))
			{
				String input2 = keyboard.next();
				if (input2.equalsIgnoreCase("room"))
				{
					player.map.examineRoom(input);
				} else if (input2.equalsIgnoreCase("inventory"))
				{
					player.examineInventory(input2);
				} else
				{
					player.item.examineItem(input2);
				}
			} else if (input.equalsIgnoreCase("pickup"))
			{
				String input2 = keyboard.next();
				player.item.pickUp(input2);
			} else if (input.equalsIgnoreCase("drop"))
			{
				String input2 = keyboard.next();
				player.item.drop(input2);
			}else if (input.equalsIgnoreCase("equip"))
			{
				String input2 = keyboard.next();
				player.item.equip(input2);
			}else if (input.equalsIgnoreCase("unequip"))
			{
				String input2 = keyboard.next();
				player.item.unEquip(input2);
			}
			else if (input.equalsIgnoreCase("n"))
			{
				String direction = Map.getRoomItems().get(roomId).getNorth();

				player.map.getRoom(direction);
			} else if (input.equalsIgnoreCase("e"))
			{
				String direction = Map.getRoomItems().get(roomId).getEast();

				player.map.getRoom(direction);
			} else if (input.equalsIgnoreCase("s"))
			{
				String direction = Map.getRoomItems().get(roomId).getSouth();

				player.map.getRoom(direction);
			} else if (input.equalsIgnoreCase("w"))
			{
				String direction = Map.getRoomItems().get(roomId).getWest();

				player.map.getRoom(direction);
			} else if (input.equalsIgnoreCase("quit"))
			{
				System.out.println("You have successfully quit the game.");
				done = true;
			} else
			{
				System.out.println("Invalid input. Please try again.");
			}

			Map.getRoomItems().get(roomId).setVisited(true);

			roomId = extracted(player);
		}
		keyboard.close();
	}

	private static void extracted(help help)
	{
		help.addCommands(help);
	}

	private static int extracted(player player)
	{
		return player.getPlayerLocation();
	}
}