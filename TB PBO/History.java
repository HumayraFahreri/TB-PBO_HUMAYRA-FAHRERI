import java.util.ArrayList;

public class History {
    public static ArrayList<String> balita = new ArrayList<>();
    
    public History(){
    }

    public History(String nama){
        balita.add(nama);
    }
    public void print(){
        System.out.println("Pasien Hari ini : ");
        int i=0;
        for(String anak : balita){
            i++;
            String nama = (String) anak;
            System.out.println(i +". " + nama );
        }
    }
}
