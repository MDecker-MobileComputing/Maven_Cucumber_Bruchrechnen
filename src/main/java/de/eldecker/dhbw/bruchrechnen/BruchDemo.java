package de.eldecker.dhbw.bruchrechnen;

/**
 * Klasse mit main-Methode, um die Bruch-Klasse zu testen.
 */
public class BruchDemo {

    /**
     * Einstiegsmethode.
     *
     * @param args wird nicht verwendet
     */
    public static void main(String[] args) {

            System.out.println("");

            Bruch bruch1 = new Bruch(1, 2);

            // addiere 1/3 zu 1/2
            Bruch bruch2 = new Bruch(1, 3);
            bruch1.addiere(bruch2);
            System.out.println(bruch1.getZaehler() + "/" + bruch1.getNenner());

            // multipliziere mit 2/3
            Bruch bruch3 = new Bruch(2, 3);
            bruch1.multiplizieren(bruch3);
            System.out.println(bruch1.getZaehler() + "/" + bruch1.getNenner());

            System.out.println("");
    }
}
