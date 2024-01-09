import java.util.*;
public class Login {
    
    public Login(){
        boolean id = true;
        boolean captcha = true;

        while(id && captcha){

            Scanner user = new Scanner (System.in);
            System.out.println("Username : ");
            String un = user.next();

            Scanner sandi = new Scanner (System.in);
            System.out.println("Password : ");
            String pw = sandi.next();

            Scanner uji = new Scanner (System.in);
            System.out.println("Kode Captcha : 0507");
            System.out.println("Masukkan Captcha : ");
            String kode = uji.next();

            if(un.equalsIgnoreCase("Yuma") && pw.equals("Fahreri.0507") && kode.equalsIgnoreCase("0507")){
                id = false;
                captcha = false;
                System.out.println( );
                System.out.println("Login Sukses!");
            }
            else{
                id = true;
                captcha = true;
                System.out.println("Username atau Password Anda salah!");
            }
        }
        Pelayanan pelayanan = new Pelayanan();
    }
}
