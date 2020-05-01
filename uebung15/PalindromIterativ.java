public class PalindromIterativ implements Palindrom {
    @Override
    public boolean istPalindrom(String wort){
        for (int i = 0, j = wort.length()-1; i <= wort.length() / 2; i++, j--) {
            if (wort.charAt(i) != wort.charAt(j))
                return false;
        }
        return true;
    }
}
