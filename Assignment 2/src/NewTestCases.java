import java.sql.SQLOutput;

public class NewTestCases {

    public static int passed = 0;
    public static int tested = 0;

    public static void main(String[] args) {
        //--------------------
        Letter letter1 = new Letter('J');
        Letter letter2 = new Letter('V');
        Letter letter3 = new Letter('J');

        // ********** Letter equals
        test(1,"Letter equals", !letter1.equals(letter2) && letter1.equals(letter3));
//		_____DONE1^____

        letter1.setCorrect();
        letter2.setUsed();
        letter3.setUnused();
        // ********** Letter set methods
        test(2,"Letter set methods", (letter1.toString()+letter2.toString()+letter3.toString()).equals("!J!+V+-J-"));
//		_____DONE2^____
        // TODO IS CORRECT THIS TESTING LETTER CLASS </>

        // ********** Letter fromString
        Letter[] array = Letter.fromString("JAVA");
        test(3,"Letter fromString", array[1].equals(array[3]) && array[0].equals(letter1));
//		_____DONE3^____
        Word password1 = new Word(Letter.fromString("BOOKKEEPER"));
        Word password2 = new Word(Letter.fromString("SUCCESSFUL"));
        Word password3 = new Word(Letter.fromString("ACCELERATION"));
        Word password4 = new Word(Letter.fromString("COMMITTEE"));
        Word password5 = new Word(Letter.fromString("MISSISSIPPI"));
        Word password6 = new Word(Letter.fromString("YELLOW"));
        Word password7 = new Word(Letter.fromString("A"));
        Word password8 = new Word(Letter.fromString("POOOPOOO"));
        Word password9 = new Word(Letter.fromString("BESERKISTHEBEST"));
        Word password10 = new Word(Letter.fromString("VS"));

        // TODO Passwords^

        Word word1 = new Word(Letter.fromString("BOOK"));
        Word word2 = new Word(Letter.fromString("SUCKERXZY"));
        Word word3 = new Word(Letter.fromString("APPOINTMENT"));
        Word word4 = new Word(Letter.fromString("STRESSED"));
        Word word5 = new Word(Letter.fromString("MISSISSIPPI"));
        Word word6 = new Word(Letter.fromString("YELLOW"));
        Word word7 = new Word(Letter.fromString("A"));
        Word word8 = new Word(Letter.fromString("POOOPOOOO"));
        Word word9 = new Word(Letter.fromString("BESERKISTHEBEST"));
        Word word10 = new Word(Letter.fromString("AS"));
        // TODO WORDS^

        word1.labelWord(password1);
        word2.labelWord(password2);
        word3.labelWord(password3);
        word4.labelWord(password4);
        word5.labelWord(password5);
        word6.labelWord(password6);
        word7.labelWord(password7);
        word8.labelWord(password8);
        word9.labelWord(password9);
        word10.labelWord(password10);


        //TODO DOING METHODS


        // ********** Word toString + Constructor
        test(4,"Test 1 word1", word1.toString().equals("Word: !B! !O! !O! !K! "));
        //		_____DONE4^____
        test(5,"Test 2 word2", word2.toString().equals("Word: !S! !U! !C! -K- !E! -R- -X- -Z- -Y- "));
        test(6,"Test 3 word3", word3.toString().equals("Word: !A! -P- -P- +O+ +I+ +N+ +T+ -M- +E+ +N+ +T+ "));
        test(7,"Test 4 word4", word4.toString().equals("Word: -S- +T+ -R- +E+ -S- -S- +E+ -D- "));
        test(8,"Test 5 word5", word5.toString().equals("Word: !M! !I! !S! !S! !I! !S! !S! !I! !P! !P! !I! "));
        test(9,"Test 6 word6", word6.toString().equals("Word: !Y! !E! !L! !L! !O! !W! "));
        test(10,"Test 7 word7", word7.toString().equals("Word: !A! "));
        test(11,"Test 8 word8", word8.toString().equals("Word: !P! !O! !O! !O! !P! !O! !O! !O! +O+ "));
        test(12,"Test 9 word9", word9.toString().equals("Word: !B! !E! !S! !E! !R! !K! !I! !S! !T! !H! !E! !B! !E! !S! !T! "));
        test(13,"Test 10 word10", word10.toString().equals("Word: -A- !S! "));

        // ********** Word label

        WordLL wll = new WordLL(new Word(Letter.fromString("OBJECT"))); // OBJECT IR OUR PASSWORD
        String[] arr = {"JOB","TESTING","OBJECTS"};
        for(int i=0;i<arr.length;i++) {
            wll.tryWord( new Word(Letter.fromString(arr[i])) );
        }
//		System.out.println(wll); //Testing erase this

        // ********** WordLL tryWord +
        test(10,"WordLL tryWord +", wll.toString().contains("Word: !O! !B! !J! !E! !C! !T! -S- ") &&
                wll.toString().contains("Word: +T+ +E+ -S- +T+ -I- -N- -G- ") &&
                wll.toString().contains("Word: +J+ +O+ +B+ ") );
        ExtendedLetter el1 = new ExtendedLetter("@");
        ExtendedLetter el2 = new ExtendedLetter(":)",1);
        ExtendedLetter el3 = new ExtendedLetter(":(",1);

        // ********** ExtendedLetter equals
        test(11,"ExtendedLetter equals", el1.equals(el1) && !el1.equals(el2) && !el3.equals(el2));
        el1.setCorrect();
        el2.setUnused();
        el3.setUnused();

        // ********** ExtendedLetter toString
        test(12,"ExtendedLetter toString", (el1.toString()+el2.toString()+el3.toString()).equals("!@!-:)-.:(."));
        String[][] stArr={{"JD","AD","9H","10S"},
                {"JC","9H","KH","AS"},
                {"10C","JC","9D","KH"},
                {"JC","10D","9H","QH"},
                {"10C","AD","9H","KH"},
                {"10C","QC","QD","10H"},
                {"JC","9D","KH","9S"}};
        int[][] intArr = {{2,5,0,1},
                {2,0,4,5},
                {1,2,0,4},
                {2,1,0,3},
                {1,5,0,4},
                {1,3,3,1},
                {2,0,4,0}};

        WordLL wll2 = new WordLL(new Word(ExtendedLetter.fromStrings(stArr[stArr.length-1],intArr[stArr.length-1])));
        for (int i = 0; i < stArr.length; i++) {
            wll2.tryWord(new Word(ExtendedLetter.fromStrings(stArr[i],intArr[i])));
        }

        // ********** ExtendLetter WordLL tryWord +
        test(13,"ExtendLetter WordLL tryWord +", wll2.toString().contains("Word: !JC! !9D! !KH! !9S! ") &&
                wll2.toString().contains("Word: -10C- -QC- -QD- -10H- ") &&
                wll2.toString().contains("Word: -10C- -AD- .9H. +KH+ ") &&
                wll2.toString().contains("Word: !JC! -10D- .9H. -QH- ") &&
                wll2.toString().contains("Word: -10C- +JC+ +9D+ +KH+ ") &&
                wll2.toString().contains("Word: !JC! .9H. !KH! -AS- ") &&
                wll2.toString().contains("Word: .JD. -AD- .9H. -10S- ") );
        System.out.println("Your code scored: " + passed + " / " + tested);
        //--------------------
    }

    public static void test(int testNumber, String message, boolean testStatus) {
        tested++;
        System.out.println("Test " + testNumber + " (" + message + ") " + (testStatus ? "passed" : "failed"));
        if (testStatus)
            passed++;
    }
}
