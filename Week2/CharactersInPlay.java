import java.util.*;

public class CharactersInPlay {
    private ArrayList<String> names;
    private ArrayList<Integer> counts;

    public CharactersInPlay(){
        names = new ArrayList<String>();
        counts = new ArrayList<Integer>();
    }

    public void update(String person){
        if (!names.contains(person)){
            names.add(person);
            counts.add(1);
        }
        else{
            int updatedCount = counts.get(names.indexOf(person))+1;
            counts.set(names.indexOf(person), updatedCount);
        }

    }

    public void findAllCharacters(){
        FileResource f = new FileResource();
        for(String line : f.lines()){
            if (line.contains(".")){
                String name= line.substring(0, line.indexOf("."));
                update(name);
            }

        }
    }

    public void tester(){
        counts.clear();
        names.clear();
        findAllCharacters();
        for (int i=0; i < names.size(); i++){
            if (counts.get(i) > 1){
                System.out.println(names.get(i) + "\t" + counts.get(i));
            }
        }
        charactersWithNumParts(10,15);
    }

    public void charactersWithNumParts(int num1, int num2){
        System.out.println("Characters that have between "+ num1 + " and " + num2+ " lines:");
        for (int i=0; i < names.size(); i++){
            if (counts.get(i) >= num1 && counts.get(i)<= num2){
                System.out.println(names.get(i) + "\t" + counts.get(i));
            }
        }
    }

}
