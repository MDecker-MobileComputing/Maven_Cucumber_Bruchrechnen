package de.eldecker.dhbw.bruchrechnen;

/**
 * Klasse für Bruchrechnen, die mit Cucumber unter Test genommen werden soll.
 * Die einzelnen Bruchoperationen (z.B. addieren) verändern den Wert des aufrunfenden Objekts
 * (deshalb geben die Methoden alle {@code void} zurück).
 */
public class Bruch {
    
    /** Zähler des Bruchs */
    private int _zaehler;

    /** Nenner des Bruchs; darf nicht 0 sein. */
    private int _nenner;


    /**
     * Erstellt ein neues Bruch-Objekt mit dem gegebenen Zähler und Nenner.
     *
     * @param inputZaehler der Zähler des Bruchs
     * @param inputNenner der Nenner des Bruchs; darf nicht 0 sein.
     */
    public Bruch(int inputZaehler, int inputNenner) {

        _zaehler = inputZaehler;
        _nenner  = inputNenner;
    }


    /**
     * Gibt den Zähler des Bruchs zurück.
     *
     * @return der Zähler des Bruchs
     */ 
    public int getZaehler() {

        return _zaehler;
    }


    /**
     * Gibt den Nenner des Bruchs zurück.
     *
     * @return der Nenner des Bruchs (!= 0)
     */     
    public int getNenner() {

        return _nenner; 
    }    


    /**
     * Addiert den gegebenen Bruch zu diesem Bruch.
     *
     * @param inputBruch der Bruch, der zu diesem Bruch addiert werden soll
     */
    public void addiere(Bruch inputBruch) {

        _zaehler = _zaehler * inputBruch.getNenner() + inputBruch.getZaehler() * _nenner;
        _nenner  = _nenner  * inputBruch.getNenner();    

        kuerzen();
    }


    /**
     * Subtrahiert {@code inputBruch} von diesem Bruch.
     * 
     * @param inputBruch Bruch, der vom aufrunfenden Objekt abgezogen werden soll.
     */
    public void subtrahieren(Bruch inputBruch) {

        _zaehler = _zaehler * inputBruch.getNenner() - inputBruch.getZaehler() * _nenner;
        _nenner  = _nenner  * inputBruch.getNenner();    

        kuerzen();
    }


    /**
     * Multipliziert diesen Bruch mit dem gegebenen Bruch.
     * 
     * @param inputBruch Bruch, mit dem der aufrufende Bruch multipliziert werden soll.
     */
    public void multiplizieren(Bruch inputBruch) {

        _zaehler = _zaehler * inputBruch.getZaehler();
        _nenner  = _nenner  * inputBruch.getNenner();    

        kuerzen();
    }

    /**
     * Dividiert diesen Bruch durch den gegebenen Bruch.
     * 
     * @param inputBruch Bruch, durch den der aufrufende Bruch dividiert werden soll.
     */
    public void dividieren(Bruch inputBruch) {

        _zaehler = _zaehler * inputBruch.getNenner();
        _nenner  = _nenner  * inputBruch.getZaehler();    

        kuerzen();
    }


    /**
     * Bruch kürzen.
     */
    public void kuerzen() {

        int teiler = ggT(_zaehler, _nenner);
        _zaehler = _zaehler / teiler;
        _nenner  = _nenner  / teiler;
    }


    /**
     * Berechnet den größten gemeinsamen Teiler von zwei Zahlen a und b mit dem Algorithmus von Euklid.
     * @param a Zahl 1
     * @param b Zahl 2
     * @return den größten gemeinsamen Teiler von a und b
     */
    private int ggT(int a, int b) {

        while (b != 0) {

            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
    

    /**
     * Gibt den Bruch als String zurück.
     * 
     * @return der Bruch als String; Beispiel: "1/2"
     */
    @Override
    public String toString() {

        return _zaehler + "/" + _nenner;
    }


    /**
     * Vergleicht zwei Brüche auf Gleichheit.
     * 
     * @param obj das Objekt, mit dem verglichen werden soll
     * @return {@code true}, wenn die Brüche gleich sind, sonst {@code false}
     */
    @Override
    public boolean equals(Object obj) {

        if (obj == this) {

            return true;
        }   
        if (obj == null) {

            return false;
        }

        if (! (obj instanceof Bruch)) {

            return false;
        }

        Bruch other = (Bruch) obj;

        return _zaehler == other.getZaehler() && _nenner == other.getNenner();
    }   


    /**
     * Gibt den Hashcode des Bruchs zurück.
     */
    @Override
    public int hashCode() {

        return _zaehler * 31 + _nenner; // 31, weil Primzahl, in Buch "Effective Java" von Joshua Block empfohlen
    }   

}
