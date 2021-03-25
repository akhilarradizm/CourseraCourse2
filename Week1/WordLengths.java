public class WordLengths {
    public void countWordLengths(FileResource resource,  int[] counts){
        for(String word : resource.words()){
            int originalLength = word.length();
            for(int k=0; k<word.length();k++){
                if( (k==0) || (k==(word.length()-1) )) {
                    if (!Character.isLetter(word.charAt(k))) originalLength--;}
            }
            counts[originalLength]++;
        }
    }

    void test_countWordLengths(){
        int[] counts = new int[30];
        FileResource resource = new FileResource();
        countWordLengths(resource,counts);
        for(int k=0; k < counts.length; k++){
            System.out.println(k + "  " + counts[k]);
        }

        System.out.println(indexOfMax(counts));
    }


    public int indexOfMax(int[] counts){
        int maxIndex = 0;
        int maxCount = 0;

        for (int k = 0; k< counts.length; k++){
            if (counts[k]>maxCount) {
                maxIndex=k;
                maxCount= counts[k];
            }
        }
        return maxIndex;
    }
     public static void main(String[] args)
    {
    	WordLengths wl= new WordLengths();
    	wl.test_countWordLengths();
    	}
}
