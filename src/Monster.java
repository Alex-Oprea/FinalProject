import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Monster {
    private String monsterLocation;
    private String monsterName;
    private String monsterDesc;
    private String monsterHp;
    private String monsterAttk;
    private static ArrayList<Monster> monsterItems = new ArrayList<Monster>();

    public Monster()
    {
        super();
    }

    public Monster(String monsterLocation, String monsterName, String monsterDesc, String monsterHp, String monsterAttk)
    {
        super();
        this.monsterLocation = monsterLocation;
        this.monsterName = monsterName;
        this.monsterDesc = monsterDesc;
        this.monsterHp = monsterHp;
        this.monsterAttk = monsterAttk;
    }

    public String getMonsterLocation()
    {
        return monsterLocation;
    }

    public void setMonsterLocation(String monsterLocation) {
        this.monsterLocation = monsterLocation;
    }

    public String getMonsterName() {
        return monsterName;
    }

    public void setMonsterName(String monsterName) {
        this.monsterName = monsterName;
    }

    public String getMonsterDesc() {
        return monsterDesc;
    }

    public void setMonsterDesc(String monsterDesc) {
        this.monsterDesc = monsterDesc;
    }

    public String getMonsterHp() {
        return monsterHp;
    }

    public void setMonsterHp(String monsterHp) {
        this.monsterHp = monsterHp;
    }

    public String getMonsterAttk() {
        return monsterAttk;
    }

    public void setMonsterAttk(String monsterAttk) {
        this.monsterAttk = monsterAttk;
    }

    public static void addMonster(Monster i)
    {
        monsterItems.add(i);
    }

    public static void removeMonster(Monster i)
    {
        monsterItems.remove(i);
    }

    public static ArrayList<Monster> getMonsterItems()
    {
        return monsterItems;
    }

    public void examineMonster (String monster)
    {
        for (int i = 0; i < getMonsterItems().size(); i++)
        {
            if(monster.equalsIgnoreCase(getMonsterItems().get(i).getMonsterName()))
            {
                System.out.println(getMonsterItems().get(i).getMonsterDesc());
                System.out.println("Health Points: " +getMonsterItems().get(i).getMonsterHp());
                System.out.println("Attack Power: " +getMonsterItems().get(i).getMonsterAttk());
            }
        }
    }

    public void fightMonster ()
    {
        for (int i = 0; i < getMonsterItems().size(); i++)
        {
            Random rn = new Random();
            int min = 0;
            int playerHp = 30;
            int playerAttack = 10;
            int damageGiven = playerAttack;
            String monsterHp = Monster.getMonsterItems().get(i).getMonsterHp();
            int monstHp = Integer.parseInt(monsterHp);
            String damageTake = Monster.getMonsterItems().get(i).monsterAttk;
            int damTake = Integer.parseInt(damageTake);
            boolean fighting = true;
            while (fighting)
            {
                Scanner keyboard = new Scanner(System.in);
                System.out.println("What would you like to do? Type in *Attack or Run*");
                String input = keyboard.next();
                if (input.equalsIgnoreCase("attack"))
                {
                    int rand1 = rn.nextInt(damTake);
                    int rand2 = rn.nextInt(damageGiven);
                    playerHp -= rand1;
                    monstHp -= rand2;
                    System.out.println("You attack for: " + rand2);
                    System.out.println("You have been attacked for: " + rand1);
                    System.out.println("You have " + playerHp + " health left.");
                    System.out.println("The monster has " +monstHp + " health left.");
                }else if (input.equalsIgnoreCase("run"))
                {
                    break;
                }
                if (playerHp <= 0) {
                    System.out.println("You have died.");
                    fighting = false;
                    System.exit(0);
                }
                else if (monstHp <= 0)
                {
                    System.out.println("You win!");
                    System.out.println("You feel a mysterious tingle inside of you, you feel well rested and healed'");
                    fighting = false;
                    removeMonster(getMonsterItems().get(i));
                    Map.getRoomItems().get(player.getPlayerLocation()).setMonster(false);
                    return;
                }
            }
        }
    }

}
