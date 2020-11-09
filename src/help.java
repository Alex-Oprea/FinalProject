import java.util.ArrayList;

public class help
{
	private String help;
	private static ArrayList<help> commands = new ArrayList<help>();

	public help()
	{
		super();

	}

	public help(String help)
	{
		super();
		this.help = help;
	}

	public String getHelp()
	{
		return help;
	}

	public void setHelp(String help)
	{
		this.help = help;
	}

	public static void addCommands(help h)
	{
		commands.add(h);
	}

	public static ArrayList<help> getCommands()
	{
		return commands;
	}

	public void askHelp()
	{
		for (int i = 0; i < getCommands().size(); i++)
		{
			System.out.println(getCommands().get(i).getHelp());
		}
		System.out.println("Type \"C\" at anytime to see your commands.");
	}
}