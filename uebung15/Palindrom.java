/**
 * 
 * @author A. Venet und H. Schall
 * @version 1.0
 */
public interface Palindrom
{
    boolean istPalindrom();
}
public class PalindromRekursiv implements Palindrom {
    @Override
    boolean istPalindrom(String wort){
        int first = 0;
        int last = wort.length() - 1;
        if (wort.charAt(first) != wort.charAt(last))
            return false;
        else {
            if (wort.length() == 2)
                return true;
                else {
                    String neuesWort = wort.substring(1,last);
                    return istPalindrom(neuesWort);
                }   
        }
    }
}
public class PalindromIterativ implements Palindrom {
    @Override
    boolean istPalindrom(String wort){
        int leftPos = 0;
        int rightPos = wort.length() - 1;
        boolean palindrome=true;
        while ((leftPos < rightPos) && palindrome) {
            if (wort.charAt(leftPos) != wort.charAt(rightPos)) {
                palindrome=false;
            }
            leftPos++;
            rightPos--;
        }
        return palindrome;
    }
}

