
public class room
{
	private String roomNum;
	private String desc;
	private boolean visited;
	private boolean item;
	private boolean puzzle;
	private boolean monster;
	private String north;
	private String east;
	private String south;
	private String west;

	public room()
	{
		super();
	}

	public room(String roomNum, String desc, boolean visited, boolean item, boolean puzzle, boolean monster, String north, String east,
			String south, String west)
	{
		super();
		this.north = north;
		this.east = east;
		this.south = south;
		this.west = west;
		this.roomNum = roomNum;
		this.desc = desc;
		this.visited = false;
		this.item = item;
		this.puzzle = puzzle;
		this.monster = monster;

	}

	public String getRoomNum()
	{
		return roomNum;
	}

	public void setRoomNum(String roomNum)
	{
		this.roomNum = roomNum;
	}

	public String getDesc()
	{
		return desc;
	}

	public void setDesc(String desc)
	{
		this.desc = desc;
	}

	public boolean isVisited()
	{
		return visited;
	}

	public void setVisited(boolean visited)
	{
		this.visited = visited;
	}

	public boolean hasItem()
	{
		return item;
	}

	public void setItem(boolean item)
	{
		this.item = item;
	}

	public boolean hasPuzzle()
	{
		return puzzle;
	}

	public void setPuzzle(boolean puzzle)
	{
		this.puzzle = puzzle;
	}

	public boolean hasMonster() {return monster;}

	public void setMonster(boolean monster) {this.monster = monster;}

	public String getNorth()
	{
		return north;
	}

	public void setNorth(String north)
	{
		this.north = north;
	}

	public String getEast()
	{
		return east;
	}

	public void setEast(String east)
	{
		this.east = east;
	}

	public String getSouth()
	{
		return south;
	}

	public void setSouth(String south)
	{
		this.south = south;
	}

	public String getWest()
	{
		return west;
	}

	public void setWest(String west)
	{
		this.west = west;
	}
}