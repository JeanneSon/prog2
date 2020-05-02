/**
 * die Klasse PalindromRekursiv die die Klasse Palindrom implementiert
 * 
 * @author A. Venet und H. Schall
 * @version 1.0
 */
public class PalindromRekursiv implements Palindrom {
    /**
     * istPalindrom
     *
     * @param wort ein String nur mit buchstaben
     * @return true wenn das wort ein Palindrom ist false sonst
     */
    @Override
    public boolean istPalindrom(String wort){
        if (wort.length() <= 1)
            return true;
        else
            return wort.charAt(0) == wort.charAt(wort.length() - 1) && 
                        istPalindrom(wort.substring(1, wort.length() - 1));
    }
}
