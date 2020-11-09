
import java.util.ArrayList;

public class navigation
{
	private String roomNav;
	private String beginningLine;
	private String nav;
	private String middleLine;
	private String header;
	private String north;
	private String east;
	private String south;
	private String west;
	private String endingLine;
	private static ArrayList<navigation> directions = new ArrayList<navigation>();

	public navigation()
	{
		super();

	}

	public navigation(String roomNav, String beginningLine, String nav, String middleLine, String header, String north,
			String east, String south, String west, String endingLine)
	{
		super();
		this.roomNav = roomNav;
		this.beginningLine = beginningLine;
		this.nav = nav;
		this.middleLine = middleLine;
		this.header = header;
		this.north = north;
		this.east = east;
		this.south = south;
		this.west = west;
		this.endingLine = endingLine;
	}

	public String getRoomNav()
	{
		return roomNav;
	}

	public void setRoomNav(String roomNav)
	{
		this.roomNav = roomNav;
	}

	public String getBeginningLine()
	{
		return beginningLine;
	}

	public void setBeginningLine(String beginningLine)
	{
		this.beginningLine = beginningLine;
	}

	public String getNav()
	{
		return nav;
	}

	public void setNav(String nav)
	{
		this.nav = nav;
	}

	public String getMiddleLine()
	{
		return middleLine;
	}

	public void setMiddleLine(String middleLine)
	{
		this.middleLine = middleLine;
	}

	public String getHeader()
	{
		return header;
	}

	public void setHeader(String header)
	{
		this.header = header;
	}

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

	public String getEndingLine()
	{
		return endingLine;
	}

	public void setEndingLine(String endingLine)
	{
		this.endingLine = endingLine;
	}

	public static void addNavigation(navigation n)
	{
		directions.add(n);
	}

	public static ArrayList<navigation> getDirections()
	{
		return directions;
	}

	public void getNavigation(int roomId)
	{
		System.out.println(getDirections().get(roomId).getBeginningLine());
		System.out.println(getDirections().get(roomId).getNav());
		System.out.println(getDirections().get(roomId).getMiddleLine());
		System.out.println(getDirections().get(roomId).getHeader());
		System.out.println(getDirections().get(roomId).getNorth());
		System.out.println(getDirections().get(roomId).getEast());
		System.out.println(getDirections().get(roomId).getSouth());
		System.out.println(getDirections().get(roomId).getWest());
		System.out.println(getDirections().get(roomId).getEndingLine());
	}
}