public class QuicksortFirstPivot implements Sortieralgorithmus{
    private int vergleiche = 0;
    private long zeit;
    private int schreibzugriffe = 0;
    private int length;
    private int[] liste;


    @Override
    public void sort(int[] liste) {
    }


    @Override
    public int getVergleiche() {
        return vergleiche;
    }

    @Override
    public double getZeit() {
        return 0;
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
