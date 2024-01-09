import java.util.Scanner;
import javax.xml.validation.Schema;;

public class app {
    public static void main(String[] args) {
        boolean ulang = false;
        StockPosyandu stockPosyandu = new StockPosyandu(3, 6); //mengisi stock
        do{

            Pelayanan pelayanan = new Pelayanan();

            Scanner input = new Scanner(System.in);
            System.out.println("Apakah ada pasien lain?");
            String check = input.next();
            if(check.equals("ya"))
                ulang = true;
            else    
                ulang = false;
        }while(ulang == true);

        History checkHistory = new History(); // panggil objek history
        checkHistory.print(); // cetak history untuk hari iini 
    }

}
