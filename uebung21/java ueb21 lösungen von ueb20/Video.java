import java.io.*;
    
/**
 *    Die Klasse:  Video.java
 *    Realisiert eine Video-Klasse
 *
 * @version	2.0 Beta 04.01.2019
 * @author	Wolfgang Pauly
 *
 */

public class Video
       extends Artikel      
{
//------------------Konstanten----------------------------------


    private static final String BEZEICHNUNG  = "Medien";

  public static final int MIN_ERSCHEINUNGSJAHR = 1950;
  public static final int MAX_ERSCHEINUNGSJAHR = 2014;

  private static final String STD_TITEL = "kein Titel";
  private static final float  STD_SPIELDAUER = 0;
  private static final int    STD_ERSCHEINUNGSJAHR = 0;

  private static final String  TITEL_MELDUNG = 
          "Uebergebener Titel ist ungueltig, da ein LEER-String !";
  private static final String  SPIELDAUER_MELDUNG = 
          "Uebergebene Spieldauer ist ungueltig, da kleiner 0 !";
  private static final String  ERSCHEINUNGSJAHR_MELDUNG = 
          "Uebergebenes Erscheinungsjahr liegt nicht zwischen " +
           MIN_ERSCHEINUNGSJAHR + " und " + MAX_ERSCHEINUNGSJAHR +
          " !!!";
  
//------------------Attribute----------------------------------
  
  private  String  titel;
  private  int     spieldauer;
  private  int     erscheinungsJahr;

//------------------Konstruktoren-------------------------------


  /**
   *    Der Konstruktor zur Voll-Initialisierung
   *
   *    @param artikelNr initial Video-Artikelnummer
   *    @param bezeichnung initial Video-Bezeichnung
   *    @param bestand initial Video-Bestand
   *    @param preis initial Video-Preis
   *    @param titel initial Video-Titel
   *    @param spieldauer initial Video-Spieldauer
   *    @param erscheinungsJahr initial Video-Erscheinungsjahr
   */
  public Video ( int artikelNr, 
               int bestand, double preis, String titel,
               int spieldauer, int erscheinungsJahr
             )
  {
   super( artikelNr, BEZEICHNUNG, bestand, preis 
        );
   setVideoAttributes( titel, spieldauer, erscheinungsJahr );
  }  


  /**
   *    die Hilfs-Methode zu Konstruktion von Video-Objekten
   *
   *    @param titel initial Video-Titel
   *    @param spieldauer initial Video-Spieldauer
   *    @param erscheinungsJahr initial Video-Erscheinungsjahr
   */
  private void setVideoAttributes ( String titel, int spieldauer,
                                  int erscheinungsJahr 
                                )
  {
   setTitel( titel );
   setSpieldauer( spieldauer );
   setErscheinungsJahr( erscheinungsJahr );
  }  
  

//------------------titel-------------------------------

  /**
   *    gibt Video-Attribut : titel zurueck
   *    
   *    @return    Video-Titel
   */
  public String getTitel ( )
  {
    return titel;
  }


  /**
   *    setzt Video-Attribut :  titel
   *    
   *    @param titel     neuer Titel
   */
  public void setTitel ( String titel )
  {
   checkArgument( ( (titel == null) || (titel.trim().length() <= 0) ), 
                  TITEL_MELDUNG  
                );
   this.titel = titel.trim();
  }


//------------------spieldauer-------------------------------

  /**
   *    gibt Video-Attribut : spieldauer zurueck
   *    
   *    @return    Video-Spieldauer
   */
  public float getSpieldauer ( )
  {
    return spieldauer;
  }


  /**
   *    setzt Video-Attribut :  spieldauer
   *    
   *    @param spieldauer     neue Spieldauer
   */
  public void setSpieldauer ( int spieldauer )
  {
   checkArgument( ( spieldauer <= 0 ), 
                  SPIELDAUER_MELDUNG  
                );
   this.spieldauer = spieldauer;
  }


//------------------erscheinungsJahr-------------------------------

  /**
   *    gibt Video-Attribut : erscheinungsJahr zurueck
   *    
   *    @return    das Erscheinungsjahr des Videos
   */
  public int getErscheinungsJahr ( )
  {
    return erscheinungsJahr;
  }


  /**
   *    setzt Video-Attribut :  erscheinungsJahr
   *    
   *    @param erscheinungsJahr     das neue Erscheinungsjahr
   */
  public void setErscheinungsJahr ( int erscheinungsJahr )
  {
   checkArgument( ( (erscheinungsJahr < MIN_ERSCHEINUNGSJAHR) ||
                    (erscheinungsJahr > MAX_ERSCHEINUNGSJAHR)
                  ), 
                  ERSCHEINUNGSJAHR_MELDUNG  
                );
   this.erscheinungsJahr = erscheinungsJahr;
  }
  
  
 

//------------------sonstiges-------------------------------

  /**
   *    erzeugt einen Beschreibungs-String, der eine Kurzbeschreibung
   *    der Video zurueckliefert
   *    
   *    @return eine Kurzbeschreibung von Video
   */
  @Override
  public String getBeschreibung ()
  {
   return String.format( " %20s", titel );
  }


  /**
   *    erzeugt einen String, der alle, fuer den Klassenbenutzer
   *    wichtigen, Video-Merkmale enthaelt
   *    
   *    @return die String-Repraesentation von Video
   */
  @Override
  public String toString ()
  {
   return String.format( "%s ---> %20s %10d %5d ",
                              super.toString(), titel, spieldauer, erscheinungsJahr
                            );

  }


  /**
  * Die equals-Methode
  * 
  * Compares this object to the specified object. 
  * The result is true if and only if the argument is not null and is an Person-object 
  * that contains the same values for vorname, nachname as this object
  */
  public boolean equals(Object vergleichsArtikel)
  {
      return  ( vergleichsArtikel != null ) &&
              ( vergleichsArtikel instanceof Video) &&
              ((Artikel)vergleichsArtikel).getArtikelNr() == getArtikelNr();
  }



}
