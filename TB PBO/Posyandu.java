public class Posyandu implements iPosyandu{
    public String nama;
    public Integer tinggiBadan;
    public Integer beratBadan;
    public static Integer stockPmt;
    public static Integer stockObatCacing;
    
    public Posyandu(String nama, Integer tinggiBadan, Integer beratBadan, String stock){
        if (stock.equals("pmt")){
            stockPmt--;
        } else if(stock.equals("obat cacing")){
            stockObatCacing--;
        }
    }
    public Posyandu(Integer stockPmt,Integer stockObatCacing){
        this.stockPmt = stockPmt;
        this.stockObatCacing = stockObatCacing;
    }


    public Posyandu(){
    }
}
