/**
 * 
 * @author A. Venet und H. Schall
 * @version 1.0
 */
public interface Palindrom
{
    boolean istPalindrom(String wort);
}
public class PalindromRekursiv implements Palindrom {
    @Override
    boolean istPalindrom(String wort){
        if (wort.length() <= 1)
            return true;
        else
            return wort.charAt(0) == wort.charAt(wort.length() - 1) && 
                        istPalindrom(wort.substring(1, wort.length() - 1));
    }
}
public class PalindromIterativ implements Palindrom {
    @Override
    boolean istPalindrom(String wort){
        for (int i = 0, j = wort.length()-1; i <= wort.length() / 2; i++, j--) {
            if (wort.charAt(i) != wort.charAt(j))
                return false;
        }
        return true;
    }
}

