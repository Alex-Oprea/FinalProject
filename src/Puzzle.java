
import java.util.ArrayList;

public class Puzzle
{
	private String puzzleLocation;
	private String question;
	private String answer;
	private String attempts;
	private static ArrayList<Puzzle> puzzleItems = new ArrayList<Puzzle>();

	public Puzzle()
	{
		super();

	}

	public Puzzle(String puzzleLocation, String question, String answer, String attempts)
	{
		super();
		this.puzzleLocation = puzzleLocation;
		this.question = question;
		this.answer = answer;
		this.attempts = attempts;
	}

	public String getPuzzleLocation()
	{
		return puzzleLocation;
	}

	public void setPuzzleLocation(String puzzleLocation)
	{
		this.puzzleLocation = puzzleLocation;
	}

	public String getQuestion()
	{
		return question;
	}

	public void setQuestion(String question)
	{
		this.question = question;
	}

	public String getAnswer()
	{
		return answer;
	}

	public void setAnswer(String answer)
	{
		this.answer = answer;
	}

	public String getAttempts()
	{
		return attempts;
	}

	public void setAttempts(String attempts)
	{
		this.attempts = attempts;
	}

	public static ArrayList<Puzzle> getPuzzleItems()
	{
		return puzzleItems;
	}

	public static void addPuzzle(Puzzle p)
	{
		puzzleItems.add(p);
	}

	public static void removePuzzle(Puzzle p)
	{
		puzzleItems.remove(p);
	}

	public void solvePuzzle(String answer)
	{
		for (int i = 0; i < getPuzzleItems().size(); i++)
		{
			int attempts = Integer.parseInt(getPuzzleItems().get(i).getAttempts());
			if (answer.equalsIgnoreCase(getPuzzleItems().get(i).getAnswer()))
			{
				System.out.println("You solved the puzzle correctly!");
				removePuzzle(getPuzzleItems().get(i));
				Map.getRoomItems().get(player.getPlayerLocation()).setPuzzle(false);
			} else
			{
				attempts--;
				String attempted = Integer.toString(attempts);
				getPuzzleItems().get(i).setAttempts(attempted);
				if (attempts > 0)
				{
					System.out.println("The answer you provided is wrong, you still have " + attempts
							+ " more attempt(s). Try one more time");
				} else
				{
					System.out.println("Failed to solve");
					removePuzzle(getPuzzleItems().get(i));

					Map.getRoomItems().get(player.getPlayerLocation()).setPuzzle(false);
				}
			}
		}
	}
}