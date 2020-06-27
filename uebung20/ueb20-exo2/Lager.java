import java.io.*;
import java.util.*;
import java.util.function.Predicate;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.function.BiPredicate;
//import java.util.stream.Collectors;

import java.util.LinkedHashMap;

/**
 *    Die Klasse:  Lager.java
 *    Realisiert eine allgemeine Lager-Klasse fuer
 *    Artikel.
 *
 * @version 2.01 Beta 09.01.2020
 * @author  Wolfgang Pauly extended by A. Venet u. H. Schall
 *
 */

public class Lager
{
    //------------------Konstanten----------------------------------

    public  static final int     STANDARD_DIMENSION = 10;
    public  static final String  STANDARD_LAGER_ORT = 
        " (Ort noch nicht bestimmt) ";

    private static final String  DIMENSION_UNGUELTIG =
        "Ein zu konstruierendes Lager muss mindestens 1 Artikel aufnehmen koennen !";
    private static final String  LAGERORT_UNGUELTIG =
        "Der Lagerort-String muss initialisiert und nicht Leer sein !";

    private static final String  LAGER_KOMPLETT_BESETZT =
        "Im Lager sind schon alle Artikel-Lager-Plaetze besetzt !";
    private static final String  ARTIKEL_NICHT_IN_LAGER =
        "Verlangter Buchungs-Artikel nicht in Lager !!!!";
    private static final String  ARTIKEL_SCHON_IN_LAGER =
        "Anzulegender Artikel schon in Lager !!!!";

    private static final String  ARTIKEL_NR_UNGUELTIG =
        "Im Lager wird (noch) kein Artikel wird unter dieser Artikelnummer gefuehrt. !!!!";          

    //------------------Attribute----------------------------------

    //private  Artikel[] lager;
    private Map<Integer, Artikel> lager;
    private  int       letzterBesetzterIndex;
    private  String    lagerOrt;

    //------------------Konstruktoren-------------------------------

    /**
     *    Der Konstruktor zur Standard-Initialisierung 
     *    des Lagers
     *        
     */
    public Lager ()
    {
        this( STANDARD_DIMENSION, STANDARD_LAGER_ORT );
    }


    /**
     *    Der Konstruktor zur Initialisierung 
     *    eines Lagers mit einer maximalen Anzahl von Artikel-Lagerplaetzen
     *        
     *    @param dimension  == Anzahl der maximal im Lager fuehrbaren Artikel
     */
    public Lager (int dimension)
    {
        this( dimension, STANDARD_LAGER_ORT );
    }

    /**
     *    Der Konstruktor zur Initialisierung 
     *    eines Lagers mit einem Lagerort und Standard-Artikel--Lagerplaetzen
     *        
     *    @param lagerOrt == Ort an dem das Lager existiert
     */
    public Lager (String lagerOrt)
    {
        this( STANDARD_DIMENSION, lagerOrt );
    }

    /**
     *    Der Konstruktor zur Initialisierung 
     *    eines Lagers mit einer maximalen Anzahl von Artikel-Lagerplaetzen
     *        
     *    @param dimension  == Anzahl der maximal im Lager fuehrbaren Artikel
     *    @param lagerOrt == Ort an dem das Lager existiert
     */
    public Lager (int dimension, String lagerOrt)
    {
        checkArgument( (dimension <= 0), DIMENSION_UNGUELTIG );
        checkArgument( ( (lagerOrt == null) || (lagerOrt.trim().length() == 0)),
            LAGERORT_UNGUELTIG 
        );

        this.lagerOrt = new String(lagerOrt); 

        lager = new LinkedHashMap<Integer, Artikel>();
        letzterBesetzterIndex = -1;

        for ( int lauf = 0; lauf < dimension; lauf++)
        {
            lager[lauf] = null;
        }
    }

    //------------------ Erweiterungen durch Uebung 18 -----------------
    /**
     * getSorted sortiert das Lager
     *
     * @param p Sortierkriterium
     * @return das sortierte Lager
     */
    public Artikel[] getSorted(BiPredicate<Artikel, Artikel> p){
        List<Artikel> artList = Arrays.asList(this.lager);
        return insertionSort(this.lager,p);
    }
    
    
    /**
     * Sortiert ein Artikel-Array nach dem InsertionSort-Algorithmus
     *
     * @param tab zu sortierendes Artikel-Array
     * @param p Sortierkriterium
     * @return sortiertes Int-Array
     */
    public static Artikel[] insertionSort(Artikel tab[], BiPredicate<Artikel, Artikel> p)
    {
        int l = tab.length, j; 
        Artikel temp;
        for (int i = 1; i < l; i++) {
            temp = tab[i];
            j = i;
            while (j > 0 && p.test(tab[j-1], temp)) {
                tab[j] = tab[j-1];
                j--;
            }
            tab[j] = temp;
        }
        return tab;
    }
    
    /**
     * filter filtert das Lager
     *
     * @param p Filterkriterium
     * @return die herausgefilterten Werte
     */
    public Artikel[] filter(Predicate<Artikel> p) {
        List<Artikel> artList = new ArrayList<>();
        for (Artikel a : this.lager)
            if (p.test(a))
                artList.add(a);
        return artList.toArray(Artikel[]::new);
    }
    
    /**
     * applyToArticles wendet eine Methode auf alle Artikel des Lagers an
     *
     * @param c die Methode
     */
    public void applyToArticles(Consumer<Artikel> c) {
        for(int i = 0; i < this.lager.length ; i++)
            c.accept(lager[i]);
    }
    
    /**
     * applyToSomeArticles wendet eine Methode auf ausgewaehlte Artikel des Lagers an
     *
     * @param p Auswahlkriterium
     * @param c die Methode
     */
    public void applyToSomeArticles(Predicate<Artikel> p, Consumer<Artikel> c) {
        for(int i = 0; i < this.lager.length ; i++)
            if (p.test(lager[i]))
                c.accept(lager[i]);
    }
    
    /**
     * getArticles sortiert einen Teil des Lagers
     *
     * @param p Suchkriterium, nach dem das Lager gefiltert wird und den zu sortierenden Teil bestimmt
     * @param c Sortierkriterium
     * @return das sortierte Teillager
     */
    public Artikel[] getArticles(Predicate<Artikel> p, Comparator<? super Artikel> c) {
        List<Artikel> artList = new ArrayList<>();
        for (Artikel a : this.lager)
            if (p.test(a))
                artList.add(a);
        artList.sort(c);
        Artikel[] result = new Artikel[artList.size()];
        return artList.toArray(result);
    }
    
    /**
     * filterAll gibt ein Artikel-Array zurueck, dass alle Filterkriterien erfuellt
     *
     * @param criteria die Filterkriterien als variable Parameterliste
     * @return das Array (siehe oben)
     */
    public Artikel[] filterAll(Predicate<Artikel> ... criteria) {
        List<Artikel> artList = Arrays.asList(this.lager);
        Stream<Artikel> s = artList.stream();
        for (Predicate<Artikel> p : criteria)
            s.filter(p);
        return s.toArray(Artikel[]::new);
    }
    
    /*public void applyToSomeArticles1(Predicate<? super Artikel> p, Function<? super Artikel, ? extends Artikel> f) {
        List<Artikel> artList = Arrays.asList(this.lager);
        List<Artikel> newArtList = artList.stream()
                                        .filter(p)
                                        .map(f)
                                        .collect(Collectors.toList());
        this.lager = new Artikel[newArtList.size()];
        newArtList.toArray(this.lager); 
    }
    */
    
    //------------------ set-/get-lagerOrt---------------------------------
    /**
     *    gibt Lager-Attribut : lagerOrt zurueck
     *
     *    @return    lagerOrt
     */
    public String getLagerOrt ( )
    {
        return lagerOrt;
    }

    /**
     *    setzt Lager-Attribut :  lagerOrt
     *   
     *    @param lagerOrt     neuer Lager-Ort
     */
    public void setLagerOrt ( String lagerOrt )
    {
        checkArgument( ( (lagerOrt == null) || (lagerOrt.trim().length() == 0)), 
            LAGERORT_UNGUELTIG
        );

        this.lagerOrt = lagerOrt.trim();
    }

    //------------------Artikel anlegen  ---------------------------------

    /**
     *    anlegen eines neuen Artikels und ins Lager einordnen
     *    
     *    @param einArtikel  der anzulegende Artikel
     */
    public void legeAnArtikel ( Artikel einArtikel )
    {
        Object nummer = (Integer) einArtikel.getArtikelNr();
        checkArgument( lager.containsKey(nummer) , ARTIKEL_SCHON_IN_LAGER );
        lager.put( einArtikel.getArtikelNr() , einArtikel );
    }

    //------------------Artikel entfernen ----------------------------------
    /**
     *    entfernt den Artikel anhand seiner Artikel-Nummer aus dem Lager
     *    
     *    @param   loeschArtikelNr Nummer des zu loeschenden Artikels
     *             
     */
    public void entferneArtikel ( int loeschArtikelNr )
    {
        checkArtikelNummerExistiert(loeschArtikelNr);
        //loesche Artikel
        Object nummer = (Integer) loeschArtikelNr;
        lager.remove(nummer);
    }


    //------------------ zugang buchen  --------------------------------

    /**
     *    bucht einen Zugang von Artikeln zu dem durch die Artikel-Nummer 
     *    identifizierten Artikel.
     *    
     *    @param   artikelNummer Artikel-Nummer, des zu buchenden Artikels
     *    @param zugang hinzukommende Artikel-Anzahl
     */
    public void bucheZugang ( int artikelNummer, int zugang )
    {
        checkArtikelNummerExistiert(artikelNummer);
        lager.compute(artikelNummer, (artikelNr, artikel) -> {
                                                    artikel.bucheAbgang( zugang );
                                                    return artikel;
        });
    }

    //------------------- abgang buchen  --------------------------------
    /**
     *    bucht einen Abgang von Artikeln von dem durch die Artikel-Nummer 
     *    identifizierten Artikel.
     *    
     *    @param   artikelNummer Artikel-Nummer, des zu buchenden Artikels
     *    @param abgang weggehende Artikel-Anzahl
     */
    public void bucheAbgang ( int artikelNummer, int abgang )
    {
        checkArtikelNummerExistiert(artikelNummer);
        lager.computeIfPresent(artikelNummer, (artikelNr, artikel) -> {
                                                    artikel.bucheAbgang( abgang );
                                                    return artikel;
        });
    }


    /**
     *    aenderePreisAllerArtikel - erhoeht, vermindert die Preise
     *                               aller Lagerartikel
     *
     *    @param  prozent - positive Prozentzahl == Preiserhoehung, negative = Preisverminderung 
     */
    public void aenderePreisAllerArtikel ( double prozent )
    {
        lager.forEach((artikelNr, artikel) -> artikel.aenderePreis(prozent));
    }

    //------------------- hilfs-Methoden --------------------------------

    //damit nicht alle Aufrufe von sucheArtikel geaendert werden muessen, wird diese Methode nur ein wenig fuer Ueb20 angepasst
    /**
     *    sucheArtikel - sucht im Lager Array
     *               nach dem Vorkommen eines Artikels anhand 
     *               der Artikel-Nummer
     *
     *    @param suchArtikelNr - die zu suchende Artikelnummer
     *    @return Index des gefundenen Artikels oder -1, falls der Artikel nicht
     *            im Lager enthalten ist.
     */
    public int sucheArtikel ( int suchArtikelNr )
    {
        Object zuSuchen = (Integer) suchArtikelNr;
        Artikel gefunden = lager.get(zuSuchen);
        return gefunden == null ? -1 : suchArtikelNr;
    }

    private void checkArtikelNummerExistiert ( int artikelNr ) throws RuntimeException {
        Object nummer = (Integer) artikelNr;
        if ( ! lager.containsKey(nummer) )
            throw new RuntimeException( ARTIKEL_NICHT_IN_LAGER );
    }
    
    /**
     *    getLagerGroesse - liefert die Groesse des Lager Array
     *    Hilfsmethode fuer die Testklasse LagerTest
     *    @author  Iris Ebner
     *
     *    @return lager.length == Anzahl der maximal im Lager fuehrbaren Artikel
     */
    public int getLagerGroesse ()
    {
        return lager.size();    
    }

    /**
     *    getArtikelAnzahl - liefert die Anzahl der Artikel im Lager Array
     *    
     *
     *    @return etzterBesetzterIndex == Anzahl der Artikel im Lager
     */
    public int getArtikelAnzahl ()
    {
        return getLagerGroesse();    
    }

    /**
     *    getArtikel - liefert den Artikel aus dem Lager, der unter dieser
     *    Artikelnummer gefuert wird
     *    Hilfsmethode fuer die Testklasse LagerTest
     *    @author  Iris Ebner
     *
     *    @param artikelNr - die  Artikelnummer des zurueckzugebenden Artikels
     *    @return der Artikel, der unter dieser Artikelnummer im Lager gefuehrt wird 
     */  
    public Artikel getArtikel (int artikelNr)
    {
        Object key = (Integer) artikelNr;
        Artikel zurueckzugeben = lager.get(key);
        if (zurueckzugeben == null)
            throw new RuntimeException( ARTIKEL_NR_UNGUELTIG );

        return zurueckzugeben;
    }

    //------------------ ausgebenBestandsListe --------------------------
    /**
     *    erzeugt einen String, der eine Bestandsliste repraesentiert
     *
     *    @return die String-Repraesentation der Lager-Bestandsliste
     */
    public String ausgebenBestandsListe ()
    {

        double zeilenWert, gesamtWert = 0;

        StringBuilder bestandsListe = new StringBuilder();
        Formatter formatierer = new Formatter( bestandsListe, Locale.GERMAN );

        formatierer.format( "\n-----B e s t a n d s L i s t e --------" +
            "-----------------------------------------" +
            "-------------------" +
            "\n\nLagerort : %20s \n\n %6s   %-45s %10s %10s %10s" +
            "\n--------------------------------------" +
            "-----------------------------------------" +
            "-------------------",
            lagerOrt, "ArtNr", "Beschreibung", "Preis",
            "Bestand", "Gesamt"
        );

        for ( int lauf = 0; lauf <= letzterBesetzterIndex; lauf++ )
        {
            zeilenWert = lager[lauf].getPreis() * lager[lauf].getBestand();
            gesamtWert += zeilenWert;

            formatierer.format( "\n %6d   %45s %10.2f %10d %10.2f ",
                lager[lauf].getArtikelNr(),
                lager[lauf].getBeschreibung(),
                lager[lauf].getPreis(),
                lager[lauf].getBestand(),
                zeilenWert
            );
            // hier waere es evtl sinnvoll in den Klassen Artikel, Cd, Dvd und Buch 
            // eine Methode getBestandsZeile() zu programmieren, falls man auf
            // diese Klassen "quellcode-maessig" zugreifen kann.
        }

        formatierer.format( "\n--------------------------------------" +
            "-----------------------------------------" +
            "-------------------"
        );
        formatierer.format( "\n Gesamtwert:                     " +
            "                                   " +
            "%20.2f", gesamtWert
        );

        return bestandsListe.toString();
    }


    //------------------ toString  --------------------------------------
    /**
     *    erzeugt einen String, der alle, fuer den Klassenbenutzer
     *    wichtigen, Lager-Merkmale enthaelt
     *   
     *    @return die String-Repraesentation des Lagers
     */
    public String toString ()
    {

        StringBuffer lagerString = new StringBuffer(
                String.format( "\n\nIm Lager : %20s sind von %5d Lagerplaetzen %5d ",
                    lagerOrt, lager.length, (letzterBesetzterIndex + 1)
                )
            );

        lagerString.append( " belegt, mit folgenden Artikeln : \n");

        for ( int lauf = 0; lauf <= letzterBesetzterIndex; lauf++ )
        {
            lagerString.append( String.format( "\n\t %3d \t-> %s", lauf, lager[lauf]) );
        }

        return lagerString.toString();
    }

    /**
     *    wirft bei Fehlersituation eine IllegalArgumentException
     *    
     *    
     *    @param  fehler  -> true  == Fehlersituation
     *                    -> false == KEINE Fehlersituation
     *    @param  meldung -> Fehlermeldungstext zur Fehlersituation
     */
    private void   checkArgument( boolean fehler, String meldung )
    {
        if ( fehler )
        {
            throw new RuntimeException( meldung );
        }
    }

}

