import java.lang.reflect.Array;
import java.util.ArrayList;

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
                System.out.println(getMonsterItems().get(i).getMonsterHp());
            }
        }
    }
}
