public class QuicksortFirstPivot implements Sortieralgorithmus{
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

    int partition(int start, int end) {
        int pivot = liste[start];
        int p1 = start + 1;
        for(int i = start + 1; i <= end; i++) {
            if(liste[i] < pivot) {
                if(i != p1) {
                    int temp = liste[p1];
                    liste[p1] = liste[i];
                    liste[i] = temp;
                    schreibzugriffe += 2;
                }
                vergleiche++;
                p1++;
            }
            vergleiche += 2;
        }
        vergleiche++;
        liste[start] = liste[p1-1];
        liste[p1-1] = pivot;
        schreibzugriffe += 2;
        return p1 - 1;
    }


    void quicksort(int start, int end) {
        int p1;
        if(start < end) {
            p1 = partition(start, end);
            quicksort(start, p1-1);
            quicksort(p1+1, end);
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
