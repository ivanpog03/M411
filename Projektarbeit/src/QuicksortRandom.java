import java.util.Random;

public class QuicksortRandom implements Sortieralgorithmus{
    private int vergleiche = 0;
    private double zeit;
    private int schreibzugriffe = 0;
    private int length;
    private int[] liste;

    @Override
    public void sort(int[] liste) {
        zeit = System.nanoTime();
        length = liste.length;
        this.liste = liste;
        quicksort(0, length-1);
        zeit = (System.nanoTime() - zeit)/ 1_000_000_000.0;
    }

    public void random(int arr[],int low,int high){
        Random rand = new Random();
        int pivot = rand.nextInt(high-low)+low;
        int temp1 = liste[pivot];
        liste[pivot] = liste[high];
        schreibzugriffe++;
        liste[high] = temp1;
        schreibzugriffe++;
    }

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


    public void quicksort(int low, int high) {
        if (low < high) {
            vergleiche++;
            int pi = partition(low, high);
            quicksort(low, pi-1);
            quicksort(pi+1, high);
        }
        vergleiche++;
    }

    @Override
    public int getVergleiche() {
        return vergleiche;
    }

    @Override
    public double getZeit() {
        return zeit;
    }

    @Override
    public long getSpeicherbedarf() {
        return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    }

    @Override
    public int getSchreibzugriffe() {
        return schreibzugriffe;
    }

}
