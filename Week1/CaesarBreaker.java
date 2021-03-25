public class CaesarBreaker {
    public String decryptTwoKeys(String encrypted){
        CaesarCipher cc1 = new CaesarCipher();
        CaesarCipher cc2 = new CaesarCipher();

        String message1 = halfOfString(encrypted,0);
        String message2 = halfOfString(encrypted,1);
        StringBuilder theAnswer = new StringBuilder(encrypted);
        int key1= getKey(message1);
        int key2= getKey(message2);

        String d_message1=cc1.encrypt(message1,(26-key1));
        String d_message2=cc1.encrypt(message2,(26-key2));

        for (int k=0; k<(message1.length());k++){
            theAnswer.setCharAt((2*k), d_message1.charAt(k) );
        }

        for (int k=0; k<(message2.length());k++){
            theAnswer.setCharAt((2*k)+1, d_message2.charAt(k) );
        }

        System.out.println(key1+" "+key2+" " + theAnswer.toString());


        return theAnswer.toString();
    }
    public void test_decryptTwoKeys(){
        FileResource resource = new FileResource("data/mysteryTwoKeysPractice.txt");
        //FileResource resource = new FileResource("data/wordsLotsOfEs.txt");
        //String message = resource.asString();
        String message = "Akag tjw Xibhr awoa aoee xakex znxag xwko";
        String d_TwoKeyMessage = decryptTwoKeys(message);

        System.out.println(message);
        System.out.println(d_TwoKeyMessage);
    }

    public String decrypt(String encrypted){
        CaesarCipher cc1 = new CaesarCipher();
        int key = getKey(encrypted);
        return cc1.encrypt(encrypted,(26-key));
    }

    public int maxIndex(int[] values){
        int maxLength =0;
        int indexOfMax =0;

        for (int k=0; k<values.length; k++){
            if (values[k]>maxLength){
                maxLength =values[k];
                indexOfMax = k;
            }
        }
        return indexOfMax;
    }

    public int[] countLetters(String message){
        String alph = "abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[26];

        for(int k=0; k<message.length(); k++){
            char ch = Character.toLowerCase(message.charAt(k));
            int dex = alph.indexOf(ch);
            if (dex != -1){
                counts[dex] +=1;
            }
        }
        return counts;
    }

    public String halfOfString(String message, int start){
        String halfMessage = "";
        for (int i= start; i<message.length(); i=i+2){
            halfMessage = halfMessage + message.charAt(i);
        }
        return halfMessage;
    }
    public int getKey(String e_message){
        int[] freqs = countLetters(e_message);
        int maxDex = maxIndex(freqs);
        int dkey = maxDex-4;
        if (maxDex < 4) {
            dkey = 26 - (4-maxDex);
        }
        
        return dkey;
    }
    public static void main(String[] args)
    {
    	CaesarBreaker c= new CaesarBreaker();
    	c.test_decryptTwoKeys();
    	}
}
