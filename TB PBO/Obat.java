public class Obat extends Posyandu implements iPosyandu  {

        boolean kondisi = true;

        public Obat(Integer umur){
            suntikDPT(umur);
            obatCacing();
        }

        public void suntikDPT(Integer umur){
            if(umur<=6){
                System.out.println("Obat Demam  : dapat ");
            }else if(umur == 18){
                System.out.println("Obat Demam  : booster pertama");
            }else if(60<=umur && umur<=84){
                System.out.println("Obat Demam  : booster kedua");
            }else if(120<=umur && umur <= 216){
                System.out.println("Obat Demam  : vaksin tetanus dan difteri");
            }else {
                System.out.println("Obat Demam  : tidak dapat");
            }
        }

        public void obatCacing(){
            System.out.println("Obat Cacing : dapat");
            super.stockObatCacing--;
        }
}

