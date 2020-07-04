import java.util.*; 
import java.nio.charset.StandardCharsets; 
import java.nio.file.*; 
import java.io.*;
import java.util.regex.Matcher; 
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * diese Klasse implementiert die Aufgabe 2a von Uebung 21
 * @author A. Venet u. H. Schall
 * @version 1.0
 */
public class Zusatzaufgabe {
    public List<String> readTextFile(String file, String prefix, int minLength, int limit) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(file), StandardCharsets.UTF_8);
        ArrayList<String> words = new ArrayList<>();
        Pattern p = Pattern.compile("[a-zA-Z]+");
        Matcher m;
        for (String line : lines) {
            m = p.matcher(line);
            while (m.find())
                words.add(m.group());
        }
        //System.out.println(words);

        long longLimit = limit;

        Predicate<String> pPrefix    = s -> s.startsWith(prefix) ;
        Predicate<String> pMinLength =  s -> s.length() >= minLength ;

        return words
                .stream()
                .filter(pPrefix)
                .filter(pMinLength)
                .distinct()
                .limit(longLimit)
                .sorted()
                .collect(Collectors.toList());
    }

    public static void main(String[] args) throws IOException {
        String file;
        String prefix;
        int minLength;
        int limit;
        try {
            file = args[0];
            prefix = args[1];
            minLength = Integer.parseInt(args[2]);
            limit = Integer.parseInt(args[3]);
            System.out.println(new Zusatzaufgabe().readTextFile(file, prefix, minLength, limit));
        } catch (NumberFormatException e){
            System.out.println("Falsche Eingabe! Bitte in folgendem Format: PfadZurTextdatei Praefix Mindestlaenge MaximaleAnzahl");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Falsche Eingabe! Bitte in folgendem Format: PfadZurTextdatei Praefix Mindestlaenge MaximaleAnzahl");
        } catch (IOException e) {
            System.out.println("Falsche Eingabe! Der angegebene Pfad fuehrt zu keiner lesbaren Textdatei.");
        }
    }
}