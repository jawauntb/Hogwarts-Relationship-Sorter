//@author Jawaun Brown

import java.util.ArrayList;
public class Character
{
    String id;
    String name;
    String bio;
    String role;
    String patronus;
    String house;
    ArrayList<String> friends;
    ArrayList<String> enemies;
    
    public Character(String id, String name, String bio, String role, String patronus, String house)
    {
        this.id=id;
        this.name = name;
        this.bio = bio;
        this.patronus = patronus;
        this.house = house;
        this.role = role;
        friends = new ArrayList<String>();
        enemies = new ArrayList<String>();
    }
    
    public String getName()
    {
        return name;
    }
    
    public String getBio()
    {
        return bio;
    }
    
    public String getPatronus()
    {
        return patronus;
    }
    
    public String getHouse()
    {
        return house;
    }
    
    public String getRole()
    {
        return role;
    }
    
    public void addFriend(String name)
    {
        friends.add(name);
    }
    
    public void addEnemy(String name)
    {
        enemies.add(name);
    }
    
    public ArrayList<String> allFriends()
    {
        return friends;
    }
    
    public ArrayList<String> allEnemies()
    {
        return enemies;
    }
    
}
