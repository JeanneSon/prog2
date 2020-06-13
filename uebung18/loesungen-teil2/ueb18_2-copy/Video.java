import java.io.*;
    
/**
 *    Die Klasse:  Video.java
 *    Realisiert eine Video-Klasse
 *
 * @version	2.0 Beta 09.01.2020
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
  private static final float  STD_SPIELspieldauer = 0;
  private static final int    STD_ERSCHEINUNGSJAHR = 0;

  private static final String  TITEL_MELDUNG = 
          "Uebergebener Titel ist ungueltig, da ein LEER-String !";
  private static final String  SPIELspieldauer_MELDUNG = 
          "Uebergebene Spielspieldauer ist ungueltig, da kleiner 0 !";
  private static final String  ERSCHEINUNGSJAHR_MELDUNG = 
          "Uebergebenes Erscheinungsjahr liegt nicht zwischen " +
           MIN_ERSCHEINUNGSJAHR + " und " + MAX_ERSCHEINUNGSJAHR +
          " !!!";
  
//------------------Attribute----------------------------------
  
  private  String  titel;
  private  int     spieldauer;
  private  int     jahr;

//------------------Konstruktoren-------------------------------


  /**
   *    Der Konstruktor zur Voll-Initialisierung
   *
   *    @param artikelNr initial Video-Artikelnummer
   *    @param bestand initial Video-Bestand
   *    @param preis initial Video-Preis
   *    @param titel initial Video-Titel
   *    @param spieldauer initial Video-Spielspieldauer
   *    @param jahr initial Video-Erscheinungsjahr
   */
  public Video ( int artikelNr, int bestand, double preis, 
                 String titel, int spieldauer, int jahr
             )
  {
   super( artikelNr, BEZEICHNUNG, bestand, preis 
        );
   setVideoAttributes( titel, spieldauer, jahr );
  }  


  /**
   *    die Hilfs-Methode zu Konstruktion von Video-Objekten
   *
   *    @param titel initial Video-Titel
   *    @param spieldauer initial Video-Spielspieldauer
   *    @param jahr initial Video-Erscheinungsjahr
   */
  private void setVideoAttributes ( String titel, int spieldauer,
                                    int jahr 
                                )
  {
   setTitel( titel );
   setSpieldauer( spieldauer );
   setErscheinungsJahr( jahr );
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
   *    @return    Video-Spielspieldauer
   */
  public int getSpieldauer ( )
  {
    return spieldauer;
  }


  /**
   *    setzt Video-Attribut :  spieldauer
   *    
   *    @param spieldauer     neue Spielspieldauer
   */
  public void setSpieldauer ( int spieldauer )
  {
   checkArgument( ( spieldauer <= 0.0 ), 
                  SPIELspieldauer_MELDUNG  
                );
   this.spieldauer = spieldauer;
  }


//------------------jahr-------------------------------

  /**
   *    gibt Video-Attribut : jahr zurueck
   *    
   *    @return    das Erscheinungsjahr des Videos
   */
  public int getErscheinungsjahr ( )
  {
    return jahr;
  }


  /**
   *    setzt Video-Attribut :  jahr
   *    
   *    @param jahr     das neue Erscheinungsjahr
   */
  public void setErscheinungsJahr ( int jahr )
  {
   checkArgument( ( (jahr < MIN_ERSCHEINUNGSJAHR) ||
                    (jahr > MAX_ERSCHEINUNGSJAHR)
                  ), 
                  ERSCHEINUNGSJAHR_MELDUNG  
                );
   this.jahr = jahr;
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
   return String.format( "%s ---> %20s %10.2f %5d ",
                              super.toString(), titel, spieldauer, jahr
                            );

  }

}
