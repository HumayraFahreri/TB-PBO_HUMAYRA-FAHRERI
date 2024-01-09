import java.time.LocalDate;
import java.time.Month;;

public class Vitamin extends Posyandu implements iPosyandu {
    
    public Integer umur;
    public Integer dosis;
    public Vitamin(Integer umur){
        LocalDate waktu = LocalDate.now();
        int bulan = waktu.getMonthValue();
        if(umur>=12){ // anak anak di atas 12 bulan
            if(bulan == 2 || bulan == 8){
                System.out.println("Vitamin a   : kapsul merah");
            }
        }else if (umur>=6){
                System.out.println("Vitamin a   : kapsul biru");
        }else{
            System.out.println("Vitamin a   : bukan jadwal pembagian");
        }
    }
}
