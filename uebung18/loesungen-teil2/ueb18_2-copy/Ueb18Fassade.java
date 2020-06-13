import java.util.Comparator;

/**
 * <p>Diese Klasse ist eine Fassade, hinter der Sie Ihre Loesung verstecken. Der Test ruft nur die hier definierten
 * Schnittstellenmethoden auf. Loeschen Sie bitte keine Methoden. Wenn Sie eine Methode nicht implementieren
 * moechten, lassen Sie bitte die leere Implementierung stehen. Innerhalb der Methoden und in allen anderen Klassen,
 * die Sie noch benoetigen, haben Sie alle Freiheiten.</p>
 * 
 * <p>Wenn Sie Ihre Loesung mit JUnit testen moechten, testen Sie diese Schnittstellenmethoden.</p>
 * @author christopher
 *
 */
public class Ueb18Fassade {
    /**
     * Loest die Aufgabe (d) i.
     * <br />
     * Sortierung nach den folgenden Kriterien:
     * <ol>
     *  <li>Unterkategorie (alphabetisch)</li>
     *  <li>Bestand</li>
     *  <li>Preis</li>
     * </ol>
     * @param lager Das Lager mit der unsortierten Artikelliste.
     * @return Die sortierte Artikelliste.
     */
    public Artikel[] aufgabe_d_i(Lager lager) {
        return null;
    }

    /**
     * Loest die Aufgabe (d) ii.
     * <br />
     * Der Preis aller Artikel wird um 10% reduziert.
     * @param lager Das Lager mit den Artikeln, deren Preise geaendert werden sollen.
     */
    public void aufgabe_d_ii(Lager lager) {
    }

    /**
     * Loest die Aufgabe (d) iii.
     * <br />
     * An alle Artikelbezeichnungen wird das Suffix (Sonderangebot) angehaengt.
     * @param lager Das Lager mit den Artikeln, deren Bezeichnungen geaendert werden sollen.
     */ 
    public void aufgabe_d_iii(Lager lager) {
        lager.applyToArticles(a -> a.aenderePreis(10));
    }

    /**
     * Loest die Aufgabe (d) iv.
     * <br />
     * Die beiden Operatoren aus den Aufgabenteilen ii und iii werden konkateniert, d.h. alle Preise werden
     * um 10 % reduziert und alle Bezeichnungen werden um das Suffix (Sonderangebot) erweitert.
     * @param lager Das Lager mit den Artikeln, deren Preise und Bezeichnungen geaendert werden sollen.
     */
    public void aufgabe_d_iv(Lager lager) {
    }

    /**
     * Loest die Aufgabe (h) i.
     * <br />
     * Der Preis aller CDs wird um 10 % erhoeht.
     * @param lager Das Lager mit den Artikeln. Die Aenderungen werden direkt in diesem Objekt vorgenommen.
     */
    public void aufgabe_h_i(Lager lager) {
        lager.applyToSomeArticles(a -> a instanceof CD, a -> a.aenderePreis(10));
    }

    /**
     * Loest die Aufgabe (h) ii.
     * <br />
     * Der Preis aller Artikel, von denen der Bestand hoechstes zwei ist, wird um 5 % reduziert.
     * @param lager Das Lager mit den Artikeln. Die Aenderungen werden direkt in diesem Objekt vorgenommen.
     */
    public void aufgabe_h_ii(Lager lager) {
    }

    /**
     * Loest die Aufgabe (h) iii.
     * <br />
     * Der Preis der Buecher eines bestimmten Autors wird um 5 % reduziert.
     * @param lager Das Lager mit den Artikeln. Die Aenderungen werden direkt in diesem Objekt vorgenommen.
     * @param gesuchterAutor Der Autor, dessen Buecher guenstiger werden sollen.
     */
    public void aufgabe_h_iii(Lager lager, String gesuchterAutor) {
    }

    /**
     * Loest die Aufgabe (h) iv.
     * <br />
     * Der Preis aller CDs wird um 10 % erhoeht und der Preis aller Artikel, von denen der Bestand hoechstes zwei ist, wird um 5 % reduziert.
     * @param lager Das Lager mit den Artikeln. Die Aenderungen werden direkt in diesem Objekt vorgenommen.
     */
    public void aufgabe_h_iv(Lager lager) {
    }

    /**
     * Loest die Aufgabe (h) v.
     * <br />
     * @param lager Das Lager mit den Artikeln. 
     * @return Eine Liste mit allen Buechern, sortiert nach den Namen der Autoren. 
     */
    public Artikel[] aufgabe_h_v(Lager lager) {
        Comparator<Artikel> c = Comparator.<Artikel, String>comparing((Artikel b) -> b.getAutor(), String.CASE_INSENSITIVE_ORDER);
        return lager.getArticles(a -> a instanceof Buch, c);
    }

    /**
     * Loest die Aufgabe (h) vi.
     * <br />
     * @param lager Das Lager, dessen Artikel gefiltert werden sollen.
     * @param gesuchterAutor Der Autor, nach dem gefiltert werden soll.
     * @param minPreis Der kleinste Preis, den die zu filternden Buecher haben sollen.
     * @param maxPreis Der hoechste Preis, den die zu filternden Buecher haben sollen.
     * @return Alle Buecher vom Autor autor und mit einem Preis, der zwischen minPreis und maxPreis liegt.
     */
    public Artikel[] aufgabe_h_vi(Lager lager, String gesuchterAutor, double minPreis, double maxPreis) {
        return null;
    }
}
