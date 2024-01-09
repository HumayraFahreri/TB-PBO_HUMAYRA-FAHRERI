import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class JDBC{
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/tb_tbo_humayrafahreri";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    Connection connection;

    public void runData(){
        try {
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            // Establish a connection to the database
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void stopData(){
        try{
            connection.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void createData(String nama, Integer umur, Integer berat) {
        String query = "INSERT INTO posyandu (nama_anak, umur_anak, berat_badan_anak) Values(?,?,?)";

        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setString(1,nama);
            preparedStatement.setInt(2,umur);
            preparedStatement.setInt(3, berat);

            preparedStatement.executeUpdate();

            System.out.println("Berhasil membuat data !");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void removeData(String nama) {
        String query = "DELETE FROM posyandu WHERE nama_anak = ?";
    
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1,nama);
            int rowsAffected = preparedStatement.executeUpdate();
    
            if (rowsAffected > 0) {
                System.out.println("Data " + nama + " berhasil di hapus");
            } else {
                System.out.println("data tidak di temukan");
            }
    
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateData(String nama_awal,String nama,Integer umur, Integer berat) {
        String query = "UPDATE posyandu SET nama_anak = ?, umur_anak = ?, berat_badan_anak = ? WHERE nama_anak = ?";
    
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, nama);
            preparedStatement.setInt(2, umur);
            preparedStatement.setInt(3, berat);
            preparedStatement.setString(4, nama_awal);
    
            int rowsAffected = preparedStatement.executeUpdate();
    
            if (rowsAffected > 0) {
                System.out.println("berhasil mengupdate data " + nama);
            } else {
                System.out.println("data " + nama + " tidak dapat ditemukan" );
            }
    
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void readData() {
        String query = "SELECT * FROM posyandu";
    
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery()) {
    
            while (resultSet.next()) {
                String barang = resultSet.getString("nama_anak");
                int umur = resultSet.getInt("umur_anak");
                int berat = resultSet.getInt("berat_badan_anak");
    
                System.out.println(" Nama: " + barang
                        + ", Umur: " + umur + ", Berat Badan: " + berat);
            }
    
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
    
}