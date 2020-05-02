/**
 * die Klasse PalindromIterativ die die Klasse Palindrom implementiert
 * 
 * @author A. Venet und H. Schall
 * @version 1.0
 */
public class PalindromIterativ implements Palindrom {
    /**
     * istPalindrom
     *
     * @param wort ein String nur mit buchstaben
     * @return true wenn das wort ein Palindrom ist false sonst
     */
    @Override
    public boolean istPalindrom(String wort){
        for (int i = 0, j = wort.length()-1; i <= wort.length() / 2; i++, j--) {
            if (wort.charAt(i) != wort.charAt(j))
                return false;
        }
        return true;
    }
}
