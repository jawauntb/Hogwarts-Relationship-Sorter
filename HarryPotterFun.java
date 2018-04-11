/*   @author Jawaun Brown  */

import java.util.*;
import java.io.*;

public class HarryPotterFun{
    
    //Create an ArrayList of all characters using the data in characters.csv file
    static ArrayList<Character> loadCharacters(){
        //Create Scanner object to read characters.csv
        //Read each sentence (except the first line. Why?)
        //Split the sentence and create a Character object using the Character() constructor
        //Add the Character object to allCharacters
        //Close the Scanner object
        
        ArrayList<Character> allCharacters = new ArrayList<Character>();
        try{
            Scanner characters = new Scanner(new File("characters.csv"));
            
            characters.nextLine();
            while(characters.hasNextLine()){
                String s = characters.nextLine();
                String[] parts = s.split(",");
                Character tempCharacter = new Character(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5]);
                allCharacters.add(tempCharacter);
            }
            
            return allCharacters;
        }
        catch (FileNotFoundException e){
            System.out.println("File not found");
        }
        return allCharacters;
    }
    
    
    //Add friends and enemies to all the characters using the data in relations.csv file
    static ArrayList<Character> loadRelations(ArrayList<Character> allCharacters)
    {
        
        //Create Scanner object to read relations.csv
        //Read each sentence (except the first line. Why?)
        //Split the sentence and retrieve the source and targer Character objects from allCharacters
        //Check if target is a friend or enemy and add as friend or enemy of the source.
        //Close the Scanner object
        
        try{
            Scanner relations = new Scanner(new File("relations.csv"));
            
            relations.nextLine();
            while(relations.hasNextLine()){
                String s = relations.nextLine();
                String [] parts = s.split(",");
                Character temp = allCharacters.get(Integer.valueOf(parts[1]));
                if(parts[2].equals("+")){
                    allCharacters.get(Integer.valueOf(parts[0])).addFriend(temp.getName());
                }
                if(parts[2].equals("-")){
                    Character source = allCharacters.get(Integer.valueOf(parts[0]));
                    source.addEnemy(temp.getName());
                }
            }
        }
        catch (FileNotFoundException e){
            System.out.println("File not found");
        }
        
        return allCharacters;
    }
    
    // static void addRelations()
    // {
    // 	try
    // 	{
    // 		Scanner infile = new Scanner(new FileReader("relations.csv"));
    // 		while(infile.hasNext())
    // 		{
    // 			String s = infile.nextLine();
    // 			String[] parts = s.split(","); //0,1,+ or 0,1,-
    // 			Character c = Character.getId(Integer.parseInt(parts[0]));
    // 			Character related = Character.getId(Integer.parseInt(parts[1]));
    
    // 			if(parts[2]=="+")
    // 				c.addFriend(related.getName());
    // 			else if(parts[2]=="-")
    // 				c.addEnemy(related.getName());
    // 		}
    // 		infile.close();
    // 	}
    // 	catch(FileNotFoundException ex)
    // 	{
    // 		ex.printStackTrace();
    // 	}
    // }
    
    public static void main(String[] args)
    {
        ArrayList<Character> allCharacters = loadCharacters();
        allCharacters = loadRelations(allCharacters);
        
        System.out.println("\n\n\n");
        System.out.println("Dumbledore's army:");
        for (int i = 0; i < allCharacters.size(); i++){
            Character tempChar = allCharacters.get(i);
            if(tempChar.getRole().equals("Dumbledore's Army")){
                System.out.println(tempChar.getName());
            }
        }
        System.out.println("*****");
        
        
        System.out.println("\n\n\n");
        System.out.println("The Order of Phoenix:");
        for (int i = 0; i<allCharacters.size(); i++){
            Character tempChar = allCharacters.get(i);
            if(tempChar.getRole().equals("Order of Phoenix")){
                System.out.println(tempChar.getName());
            }
        }
        
        System.out.println("*****");
        
        System.out.println("\n\n\n");
        System.out.println("Friends of Harry Potter");
        for(int i = 0; i<allCharacters.size(); i++){
            Character tempChar = allCharacters.get(i);
            if(tempChar.getName().equals("Harry Potter")){
                ArrayList<String> friends = tempChar.allFriends();
                Iterator<String> friendI = friends.iterator();
                while(friendI.hasNext()){
                    System.out.println(friendI.next());
                }
            }
        }
        
        System.out.println("");
        
        System.out.println("\n\n\n");
        System.out.println("Enemies of Harry Potter");
        for(int i = 0; i<allCharacters.size(); i++){
            Character tempChar = allCharacters.get(i);
            if(tempChar.getName().equals("Harry Potter")){
                ArrayList<String> enemies = tempChar.allEnemies();
                Iterator<String> enemieI = enemies.iterator();
                while(enemieI.hasNext()){
                    System.out.println(enemieI.next());
                }
            }
        }
        System.out.println("*****");
        
        System.out.println("\n\n\n");
        System.out.println("Characters belonging to Gryffindor");
        for (int i = 0; i<allCharacters.size(); i++){
            Character tempChar = allCharacters.get(i);
            if(tempChar.getHouse().equals("Gryffindor")){
                System.out.println(tempChar.getName());
            }
        }
        System.out.println("*****");
        
        System.out.println("\n\n\n");
        System.out.println("People with stag patronus");
        for (int i = 0; i<allCharacters.size(); i++){
            Character tempChar = allCharacters.get(i);
            if(tempChar.getPatronus().equals("Stag")){
                System.out.println(tempChar.getName());
            }
        }
        System.out.println("*****");
        
        System.out.println("\n\n\n");
        System.out.println("Black family");
        for (int i = 0; i<allCharacters.size(); i++){
            Character tempChar = allCharacters.get(i);
            if(tempChar.getName().contains(" Black")){
                System.out.println(tempChar.getName());
            }
        }
        System.out.println("*****");
        
        System.out.println("\n\n\n");
        System.out.println("Weasley family");
        for (int i = 0; i<allCharacters.size(); i++){
            Character tempChar = allCharacters.get(i);
            if(tempChar.getName().contains(" Weasley")){
                System.out.println(tempChar.getName());
            }
        }
        System.out.println("*****");
        
        System.out.println("\n\n\n");
        System.out.println("People with unknown patronus and their roles");
        for (int i = 0; i<allCharacters.size(); i++){
            Character tempChar = allCharacters.get(i);
            if(tempChar.getPatronus().equals("unknown")){
                System.out.println(tempChar.getName() + ", " + tempChar.getRole());
            }
        }
        System.out.println("*****");
        
        System.out.println("\n\n\n");
        System.out.println("Death Eaters");
        for (int i = 0; i<allCharacters.size(); i++){
            Character tempChar = allCharacters.get(i);
            if(tempChar.getRole().equals("Death Eater")){
                System.out.println(tempChar.getName());
            }
        }
        System.out.println("*****");
        
        System.out.println("\n\n\n");
        System.out.println("Dumbledore Army and their patronuses");
        for (int i = 0; i<allCharacters.size(); i++){
            Character tempChar = allCharacters.get(i);
            if(tempChar.getRole().equals("Dumbledore's Army")){
                System.out.println(tempChar.getName() + ", " + tempChar.getPatronus());
            }
        }
        System.out.println("*****");
        
        System.out.println("\n\n\n");
        System.out.println("What Harry Potter Character are you? Bonus quiz!");
        System.out.println("*****");
        
    }
}
