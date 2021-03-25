import java.io.*;

public class CaesarCipher {

    public boolean isEven(int n){
        if ((n % 2) == 0) return true; else return false;
    }

    public String encrypt(String input, int key) {
        StringBuilder encrypted = new StringBuilder(input);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet = alphabet.substring(key)+
                alphabet.substring(0,key);
        for(int i = 0; i < encrypted.length(); i++) {
            char currChar = encrypted.charAt(i);
            int idx = alphabet.indexOf(Character.toUpperCase(currChar));
            if(idx != -1){
                char newChar = shiftedAlphabet.charAt(idx);
                if (Character.isLowerCase(currChar)) newChar=Character.toLowerCase(newChar);
                if (Character.isUpperCase(currChar)) newChar=Character.toUpperCase(newChar);
                encrypted.setCharAt(i, newChar);
            }
        }
        return encrypted.toString();
    }

    public void testCaesar() {
        int key = 15;
        String intialMessage = "Can you imagine life WITHOUT the internet AND computers in your pocket?";
        String encrypted = encrypt(intialMessage, key);
        System.out.println("key is " + key + "\n" + encrypted);
        String decrypted = encrypt(encrypted, 26-key);
        System.out.println(decrypted);
    }

    public String encryptTwoKeys(String input, int key1, int key2){
        String encrypt1 = encrypt(input, key1);
        String encrypt2 = encrypt(input, key2);
        StringBuilder encrypted= new StringBuilder(input);

        for (int i=0; i< input.length();i=i+1){
            if (i%2==0)
                encrypted.setCharAt(i, encrypt1.charAt(i));
            else
                encrypted.setCharAt(i, encrypt2.charAt(i));
        }

        return encrypted.toString();
    }

    public void test_encryptTwoKeys(){
        String input = "Eren and Emily have evil eerie green eyes";
        int key1 = 22;
        int key2 = 19;
        System.out.println(input);
        System.out.println(encryptTwoKeys(input, key1, key2));
    }
     public static void main(String[] args)
    {
    	CaesarCipher c= new CaesarCipher();
    	c.test_encryptTwoKeys();
    	}

}
