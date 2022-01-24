import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class KUI{
    public static void main(String[] args) throws IOException {



        int[] inversTeilSortiert1000= readFiles("C:\\Users\\vapot\\OneDrive - Bildungszentrum Zürichsee\\Module\\M411\\UB09\\Testdaten\\InversTeilsortiert1000.dat");
        System.out.println(Arrays.toString(inversTeilSortiert1000));
        int[] inversTeilSortiert10000= readFiles("C:\\Users\\vapot\\OneDrive - Bildungszentrum Zürichsee\\Module\\M411\\UB09\\Testdaten\\InversTeilsortiert10000.dat");
        System.out.println(Arrays.toString(inversTeilSortiert10000));
        int[] inversTeilSortiert100000= readFiles("C:\\Users\\vapot\\OneDrive - Bildungszentrum Zürichsee\\Module\\M411\\UB09\\Testdaten\\InversTeilsortiert100000.dat");
        System.out.println(Arrays.toString(inversTeilSortiert100000));

        int[] random1000= readFiles("C:\\Users\\vapot\\OneDrive - Bildungszentrum Zürichsee\\Module\\M411\\UB09\\Testdaten\\Random1000.dat");
        System.out.println(Arrays.toString(random1000));
        int[] random10000= readFiles("C:\\Users\\vapot\\OneDrive - Bildungszentrum Zürichsee\\Module\\M411\\UB09\\Testdaten\\Random10000.dat");
        System.out.println(Arrays.toString(random10000));
        int[] random100000= readFiles("C:\\Users\\vapot\\OneDrive - Bildungszentrum Zürichsee\\Module\\M411\\UB09\\Testdaten\\Random100000.dat");
        System.out.println(Arrays.toString(random100000));

        int[] teilsortiert1000= readFiles("C:\\Users\\vapot\\OneDrive - Bildungszentrum Zürichsee\\Module\\M411\\UB09\\Testdaten\\Teilsortiert1000.dat");
        System.out.println(Arrays.toString(teilsortiert1000));
        int[] teilsortiert10000= readFiles("C:\\Users\\vapot\\OneDrive - Bildungszentrum Zürichsee\\Module\\M411\\UB09\\Testdaten\\Teilsortiert10000.dat");
        System.out.println(Arrays.toString(teilsortiert10000));
        int[] teilsortiert100000= readFiles("C:\\Users\\vapot\\OneDrive - Bildungszentrum Zürichsee\\Module\\M411\\UB09\\Testdaten\\Teilsortiert100000.dat");
        System.out.println(Arrays.toString(teilsortiert100000));

        XSSFWorkbook workbook=new XSSFWorkbook();
        XSSFSheet sheet=workbook.createSheet("Test_data");

        for(int ii=0;ii<inversTeilSortiert10000.length;ii++){
            sheet.createRow(ii).createCell(1).setCellValue(inversTeilSortiert10000[ii]);
        }

        for(int i=0;i<inversTeilSortiert1000.length;i++){
            sheet.getRow(i).createCell(0).setCellValue(inversTeilSortiert1000[i]);
        }

        //Sortieren
        Sortieralgorithmus quicksortFirstPivot = new QuicksortFirstPivot();
        quicksortFirstPivot.sort(inversTeilSortiert1000);

        quicksortFirstPivot.getVergleiche();

        FileOutputStream out = new FileOutputStream(new File("lb2.xlsx"));
        workbook.write(out);
        out.close();


    }



    private static int[] readFiles(String file) throws FileNotFoundException {

        File f=new File(file);
        Scanner s= new Scanner(f);
        int cntr=0;
        while(s.hasNextInt()){
            cntr++;
            s.nextInt();
        }

        Scanner ss=new Scanner(f);
        int[] arr=new int[cntr];
        for(int i=0; i<arr.length;i++){
            arr[i]=ss.nextInt();
        }

        return arr;

    }
}
