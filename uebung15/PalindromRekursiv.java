public class PalindromRekursiv implements Palindrom {
    @Override
    public boolean istPalindrom(String wort){
        if (wort.length() <= 1)
            return true;
        else
            return wort.charAt(0) == wort.charAt(wort.length() - 1) && 
                        istPalindrom(wort.substring(1, wort.length() - 1));
    }
}
