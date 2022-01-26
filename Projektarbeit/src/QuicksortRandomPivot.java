/**
 * Der Quicksort ist ein schneller und instabiler Sortieralgorithmus, welcher alle Werte mit dem Pivot
 * (in diesem Fall ein zufälliges Element des Arrays) vergleicht. Durchschnittlich werden O(n * log(n)) Vergleiche
 * benötigt. Im schlechtesten Fall sind es O(n^2) und im besten Fall O(n * log(n)).
 * @author Hermann Witte
 */

import java.util.Random;

public class QuicksortRandomPivot implements Sortieralgorithmus{
    private long vergleiche = 0;
    private double zeit;
    private int schreibzugriffe = 0;
    private int length;
    private int[] liste;

    /**
     *
     * @param liste
     * @return
     */
    @Override
    public int[] sort(int[] liste) {
        zeit = System.nanoTime();
        length = liste.length;
        this.liste = liste;
        quicksort(0, length-1);
        zeit = (System.nanoTime() - zeit)/ 1_000_000_000.0;
        return this.liste;
    }

    /**
     *
     * @param arr
     * @param low
     * @param high
     */
    public void random(int arr[],int low,int high){
        Random rand = new Random();
        int pivot = rand.nextInt(high-low)+low;
        int temp1 = liste[pivot];
        liste[pivot] = liste[high];
        schreibzugriffe++;
        liste[high] = temp1;
        schreibzugriffe++;
    }

    /**
     *
     * @param low
     * @param high
     * @return
     */
    public int partition(int low, int high) {
        random(liste,low,high);
        int pivot = liste[high];
        int i = (low-1);
        for (int j = low; j < high; j++) {
            vergleiche++;
            if (liste[j] < pivot) {
                i++;
                int temp = liste[i];
                liste[i] = liste[j];
                schreibzugriffe++;
                liste[j] = temp;
                schreibzugriffe++;
            }
            vergleiche++;
        }
        vergleiche++;
        int temp = liste[i+1];
        liste[i+1] = liste[high];
        schreibzugriffe++;
        liste[high] = temp;
        schreibzugriffe++;
        return i+1;
    }

    /**
     *
     * @param low
     * @param high
     */
    public void quicksort(int low, int high) {
        if (low < high) {
            vergleiche++;
            int pi = partition(low, high);
            quicksort(low, pi-1);
            quicksort(pi+1, high);
        }
        vergleiche++;
    }

    /**
     * @return Gibt die Anzahl der vergleiche, welcher der Algorithmus benötigt zurück.
     */
    @Override
    public long getVergleiche() {
        return vergleiche;
    }

    /**
     * @return Gibt die Zeit, welche der Algorithmus benötigt hat um das Array zu sortieren zurück.
     */
    @Override
    public double getZeit() {
        return zeit;
    }

    /**
     * @return Gibt den Speicherbedarf des Algorithmus, inklusive des zu sortierende Array zurück.
     */
    @Override
    public long getSpeicherbedarf() {
        return length * 32 + 6 * 32;
    }

    /**
     * @return Gibt die Anzahl der Speicherzugriffe auf das zu sortierende Array zurück.
     */
    @Override
    public int getSchreibzugriffe() {
        return schreibzugriffe;
    }

}
