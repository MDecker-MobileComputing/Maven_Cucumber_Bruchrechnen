package de.eldecker.dhbw.bruchrechnen;

import java.util.Objects;

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

        kuerze();
    }


    /**
     * Subtrahiert Argument {@code inputBruch} vom aufrufenden Bruch-Objekt.
     *
     * @param inputBruch Bruch, der vom aufrufenden Objekt abgezogen werden soll.
     */
    public void subtrahiere(Bruch inputBruch) {

        _zaehler = _zaehler * inputBruch.getNenner() - inputBruch.getZaehler() * _nenner;
        _nenner  = _nenner  * inputBruch.getNenner();

        kuerze();
    }


    /**
     * Multipliziert das aufrufende Bruch-Objekt mit Argument {@code inputBruch}.
     *
     * @param inputBruch Bruch, mit dem der aufrufende Bruch multipliziert werden soll.
     */
    public void multipliziere(Bruch inputBruch) {

        _zaehler = _zaehler * inputBruch.getZaehler();
        _nenner  = _nenner  * inputBruch.getNenner();

        kuerze();
    }

    /**
     * Dividiert das aufrufende Bruch-Objekt durch Argument {@code inputBruch}.
     *
     * @param inputBruch Bruch, durch den der aufrufende Bruch dividiert werden soll.
     */
    public void dividiere(Bruch inputBruch) {

        _zaehler = _zaehler * inputBruch.getNenner();
        _nenner  = _nenner  * inputBruch.getZaehler();

        kuerze();
    }


    /**
     * Bruch-Objekt kürzen. Beispiel: 2/4 wird zu 1/2 gekürzt.
     */
    public void kuerze() {

        int teiler = ggT(_zaehler, _nenner);
        _zaehler = _zaehler / teiler;
        _nenner  = _nenner  / teiler;
    }


    /**
     * Berechnet den größten gemeinsamen Teiler von zwei Zahlen {@code a}
     * und {@code b} mit dem Algorithmus von Euklid.
     *
     * @param a Erste Zahl
     * 
     * @param b Zweite Zahl
     * 
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

        if ( obj instanceof Bruch anderer) {

            return _zaehler == anderer.getZaehler() && 
                   _nenner == anderer.getNenner();            
        } else {

            return false;
        }
    }


    /**
     * Gibt den Hashcode ("Fingerabdruck") des Bruchs zurück.
     *
     * @return Hashcode des Bruchs
     */
    @Override
    public int hashCode() {

        return Objects.hash( _zaehler , _nenner );
    }

}
