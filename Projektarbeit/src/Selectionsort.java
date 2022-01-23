public class Selectionsort implements Sortieralgorithmus{
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
        selectionSort();
    }


    public void selectionSort(){
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (liste[i] > liste[j]) {
                    int zahl = liste[j];
                    liste[j] = liste[i];
                    liste[i] = zahl;
                    schreibzugriffe += 2;
                }
            }
        }
        vergleiche = length * ((length-1) * 2) + length + 1;
        zeit = (System.nanoTime() - zeit)/ 1_000_000_000.0;
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
