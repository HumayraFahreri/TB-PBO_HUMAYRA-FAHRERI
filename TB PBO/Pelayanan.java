import java.util.Scanner;
import java.util.Date;
import java.util.InputMismatchException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

public class Pelayanan {
    public String nama;
    public Integer umur;
    public Integer tinggiBadan;
    public Integer beratBadan;
    public boolean statusgizi;
    // Integer check = 1;

    public Pelayanan(){
        Scanner ortu = new Scanner(System.in);
        System.out.print("Nama Ibu : ");
        String mama = ortu.next();
        mama = mama.toLowerCase(); 

        Scanner anak = new Scanner(System.in);
        System.out.print("Nama Anak : ");
        this.nama = anak.next();
        this.nama = this.nama.toLowerCase();

        Scanner umur = new Scanner(System.in);
        System.out.print("Umur Anak dalam bulan: ");
        this.umur = umur.nextInt();

        // do{
        //         try {
        //             System.out.print(" umur anak   : ");
        //             this.umur = umur.nextInt();
        //             check = 0;
        //         } catch (InputMismatchException e) {
        //             System.out.println("Inputkan umur anak sekarang dalam bentuk angka!");
        //             umur.next();}
        //         }while(check!=0);
        // check = 1;
    
        // Scanner tinggi = new Scanner(System.in);
        // System.out.print("Tinggi Badan Anak: ");
        // this.tinggiBadan = tinggi.nextInt();

        Scanner berat = new Scanner(System.in);
        System.out.print("Berat Badan Anak: ");
        this.beratBadan = berat.nextInt();

        //Tanggal
        Date hari = new Date();
        SimpleDateFormat formathari =new SimpleDateFormat("dd MMMM yyyy");
        String tanggal = formathari.format(hari);


        //Struk Hasil
        System.out.println();
        System.out.println();
        System.out.println("========= Posyandu Melati ============");
        System.out.println("Tanggal     : " + tanggal);
        System.out.println("Nama bidan  : Humayra Fahreri");
        System.out.println("=========== Data Balita ==============");
        System.out.println("Nama ibu    : "+ mama);
        System.out.println("Nama anak   : " + this.nama);
        System.out.println("Berat anak  : " + beratBadan);
        System.out.println("Umur anak   : " + this.umur);
        System.out.println("====== Data Pengeluaran Obat =========");
        gizibaik(this.beratBadan,this.umur ); // untuk mengecek gizi anak
        Obat obat = new Obat(this.umur); // untuk mengecek obat untuk anak anak berdasarkan umur
        Vitamin vitamin = new Vitamin(this.umur); // untuk mengecek vitamin berdasarkan umur si anak
        System.out.println("======================================");
        CRUD();
        History inputHistory = new History(this.nama);
    }
    
    public void gizibaik(Integer beratBadan, Integer umur){
        int Zscore = beratBadan/umur; 
        System.out.print("Keterangan  : ");
        
        if (Zscore > 2) {
            System.out.println("Obesitas");
            
        }else if(Zscore >= -2 && Zscore <= 2){
            System.out.println("Gizi Baik");
        } 
        else{
            if(Posyandu.stockPmt>0){
                Pmt pmt = new Pmt(nama, beratBadan, umur);
            }else{
                System.out.println("Stock habis!!");
            }
            if (Zscore >= -3 && Zscore < -2) {
                System.out.println("Gizi Kurang");
            } else if (Zscore < -3){
                System.out.println("Gizi Anak Buruk!!! Anak butuh Pemberian Makan Tambahan untuk mencukupi gizi! ");
            }
        } 
    }

    public void CRUD(){
        JDBC jdbc = new JDBC(); // membuat objek jdbc
        jdbc.runData(); // menghubungkan local host dengan kodingan java
        jdbc.createData( nama, umur, beratBadan); // menambah data pada database
        System.out.println("apakah anda ingin menghapus data posyandu?");
        Scanner input = new Scanner(System.in);
        String ans = input.next();
        if(ans.toLowerCase().equals("ya")){
            System.out.println("Inputkan nama anak : ");
            Scanner nama = new Scanner(System.in);
            String nama_anak = nama.next();
            jdbc.removeData(nama_anak);// menghapus data pada database berdasarkan nama anak
        }
        System.out.println("apakah anda ingin melihat semua data posyandu pada database? ");
        ans = input.next();
        if(ans.toLowerCase().equals("ya")){
            jdbc.readData(); // menampilkan semua data pada database
        }
        System.out.println("apakah anda ingin update data posyandu?");
        ans = input.next();
        if(ans.toLowerCase().equals("ya")){
            Scanner string = new Scanner(System.in);
            Scanner integer = new Scanner(System.in);

            System.out.println("inputkan data yang akan di update!");
            System.out.println("nama anak yang akan diubah    : ");
            String newNama = string.next();
            System.out.println("nama anak  : ");
            String namaAnak = string.next();
            System.out.println("umur anak : ");
            Integer umurAnak = string.nextInt();
            System.out.println("berat badan anak ");
            Integer bbAnak = integer.nextInt();
            
            jdbc.updateData(newNama, namaAnak, umurAnak, bbAnak); // mengubah data pada database berdasarkan nama
        }

        jdbc.stopData();// menghentikan hubungan antar localhost dengan program

    }

}
