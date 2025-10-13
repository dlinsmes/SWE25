public class CharDemo {

    public static void main(String [] args) {

        //character data type - char - use single quotes
        char letter = 'a';
        System.out.println(letter);

        //split string into char array
        String word = "potato";
        char [] letters = word.toCharArray();

        for (int i = 0; i < letters.length; i++)
            System.out.print(letters[i] + " ");
        System.out.println();

        //use == for char equality, single quotes for value
        int oCount = 0;
        for (char c: letters)
            if (c == 'o')
                oCount++;
        System.out.println(oCount + " letter Os in " + word);
    }
}
