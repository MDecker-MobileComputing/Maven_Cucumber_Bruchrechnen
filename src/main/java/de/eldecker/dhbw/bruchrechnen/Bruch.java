package de.eldecker.dhbw.bruchrechnen;

/**
 * Klasse für Bruchrechnen, die mit Cucumber unter Test genommen werden soll.
 * Die einzelnen Bruchoperationen (z.B. {@link #addiere(Bruch)}) verändern den Wert des aufrufenden Objekts
 * (deshalb geben die Berechnungsmethoden alle {@code void} zurück).
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
     * @return Zähler des Bruchs
     */
    public int getZaehler() {

        return _zaehler;
    }


    /**
     * Gibt den Nenner des Bruchs zurück.
     *
     * @return Nenner des Bruchs (!= 0)
     */
    public int getNenner() {

        return _nenner;
    }


    /**
     * Addiert Argument {@code inputBruch} zum aufrufenden Bruch-Objekt.
     *
     * @param inputBruch Bruch, der zum aufrufenden Bruch addiert werden soll
     */
    public void addiere(Bruch inputBruch) {

        _zaehler = _zaehler * inputBruch.getNenner() + inputBruch.getZaehler() * _nenner;
        _nenner  = _nenner  * inputBruch.getNenner();

        kuerzen();
    }


    /**
     * Subtrahiert Argument {@code inputBruch} vom aufrufenden Bruch-Objekt.
     *
     * @param inputBruch Bruch, der vom aufrufenden Objekt abgezogen werden soll.
     */
    public void subtrahieren(Bruch inputBruch) {

        _zaehler = _zaehler * inputBruch.getNenner() - inputBruch.getZaehler() * _nenner;
        _nenner  = _nenner  * inputBruch.getNenner();

        kuerzen();
    }


    /**
     * Multipliziert das aufrufende Bruch-Objekt mit Argument {@code inputBruch}.
     *
     * @param inputBruch Bruch, mit dem der aufrufende Bruch multipliziert werden soll.
     */
    public void multiplizieren(Bruch inputBruch) {

        _zaehler = _zaehler * inputBruch.getZaehler();
        _nenner  = _nenner  * inputBruch.getNenner();

        kuerzen();
    }

    /**
     * Dividiert das aufrufende Bruch-Objekt durch Argument {@code inputBruch}.
     *
     * @param inputBruch Bruch, durch den der aufrufende Bruch dividiert werden soll.
     */
    public void dividieren(Bruch inputBruch) {

        _zaehler = _zaehler * inputBruch.getNenner();
        _nenner  = _nenner  * inputBruch.getZaehler();

        kuerzen();
    }


    /**
     * Bruch-Objekt kürzen. Beispiel: 2/4 wird zu 1/2 gekürzt.
     */
    public void kuerzen() {

        int teiler = ggT(_zaehler, _nenner);
        _zaehler = _zaehler / teiler;
        _nenner  = _nenner  / teiler;
    }


    /**
     * Berechnet den größten gemeinsamen Teiler von zwei Zahlen {@code a}
     * und {@code b} mit dem Algorithmus von Euklid.
     *
     * @param a Erste Zahl
     * @param b Zweite Zahl
     * @return den größten gemeinsamen Teiler von {@code a} und {@code b}
     */
    public static int ggT(int a, int b) {

        while (b != 0) {

            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }


    /**
     * Gibt den Bruch als {@code double} zurück.
     *
     * @return z.B. 0.5 für "1/2"
     */
    public double toDouble() {

        return (double) _zaehler / _nenner;
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
     * Vergleicht zwei Brüche.
     *
     * @param obj das Objekt, mit dem verglichen werden soll
     * @return {@code true}, wenn die Brüche gleich sind, sonst {@code false};
     *          zwei Bruch-Objekte sind gleich, wenn Zähler und Nenner denselben
     *          Wert haben.
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
     *
     * @return der Hashcode des Bruchs, z.B. 33 für "1/2"
     */
    @Override
    public int hashCode() {

        return _zaehler * 31 + _nenner;
        // 31, weil Primzahl, in Buch "Effective Java" von Joshua Block empfohlen
    }

}
