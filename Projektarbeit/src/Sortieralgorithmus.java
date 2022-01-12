public interface Sortieralgorithmus {


    public default void sort(double[] liste){

    }

    public default double getVergleiche(){
        return 0;
    }

    public default double getZeit(){
        return 0;
    }

    public default double getSpeicherbedarf(){
        return 0;
    }

    public default double getSchreibzugriffe(){
        return 0;
    }

}
