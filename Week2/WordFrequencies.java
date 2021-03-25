import java.util.*;
public class WordFrequencies {
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;

    public WordFrequencies(){
        myWords = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
    }
    public void findUnique(){
        myWords.clear();
        myFreqs.clear();
        FileResource f = new FileResource();
        for(String word : f.words()){
            word = word.toLowerCase();
            int index = myWords.indexOf(word);
            if (index == -1){
                myWords.add(word);
                myFreqs.add(1);
            }
            else{
                int value = myFreqs.get(index);
                myFreqs.set(index,value+1);
            }
        }
    }

    public void tester(){
        findUnique();
        System.out.println("Number of unique words: " + myWords.size());
        for(int i=0; i < myWords.size(); i++){
            System.out.println(myWords.get(i) + "\t" + myFreqs.get(i));
        }
        findIndexOfMax();
    }

    public void findIndexOfMax(){
        //findUnique();
        int value = myFreqs.get(0);
        int maxIndex = value;
        String word = myWords.get(0);
        String maxWord = word;
        for (int i=0; i < myFreqs.size(); i++){
            int index = myFreqs.get(i);
            word = myWords.get(i);
            if (index > maxIndex){
                maxIndex = index;
                maxWord = word;

            }
            else{
                maxIndex = maxIndex;
                maxWord = maxWord;
            }
        }
        System.out.println("The word that occurs most often and its count are: "+ maxWord +" "+ maxIndex );
    }
}