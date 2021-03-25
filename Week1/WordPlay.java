public class WordPlay {

    public boolean IsVowel(char ch){
        char alphabet = Character.toLowerCase(ch);
        if ( (alphabet =='a') || (alphabet =='e') || (alphabet =='i') || (alphabet =='o') || (alphabet =='u'))
            return true;
        return false;
    }
    public String replaceVowels(String phrase, char ch){
        StringBuilder resultantString = new StringBuilder();
        for (int i=0; i<phrase.length();i++){
            char currChar =phrase.charAt(i);
            if (IsVowel(currChar))
                resultantString.append(ch);
            else
                resultantString.append(currChar);
        }
        return resultantString.toString();
    }


    public String emphasize(String phrase, char ch){
        StringBuilder newString =new StringBuilder();
        for (int i=0; i<phrase.length();i++){

            char currChar = phrase.charAt(i);

            if (Character.toLowerCase(currChar)==ch) {
                if ((i+1)%2==0)
                    newString.append("+");
                else
                    newString.append("*");
            }
            else
                newString.append(currChar);
        }
        return newString.toString();

    }

    public void test_emphasize(){
        String test1 = "dna ctgaaactga";
        String test2 = "Mary Bella Abracadabra";
        System.out.println(test1);
        System.out.println(emphasize(test1,'a'));
        System.out.println(test2);
        System.out.println(emphasize(test2,'a'));
    }
     public static void main(String[] args)
    {
    	WordPlay wp= new WordPlay();
    	wp.test_emphasize();
    	}
}
