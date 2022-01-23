public interface Sortieralgorithmus {


    public default void sort(int[] liste){
    }

    public default int getVergleiche(){
        return 0;
    }

    public default double getZeit(){
        return 0;
    }

    public default long getSpeicherbedarf(){
        return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    }

    public default int getSchreibzugriffe(){
        return 0;
    }
}
