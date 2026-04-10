import java.sql.*;
import java.util.ArrayList;

public class TestDB {

    public static void createTable() {
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:bank.db");
             Statement stmt = conn.createStatement()) {
            stmt.execute("CREATE TABLE IF NOT EXISTS accounts (" +
                         "id INTEGER PRIMARY KEY AUTOINCREMENT, " + 
                         "balance REAL NOT NULL)");
            System.out.println("Database ready!");
        } catch (Exception e) {
            System.out.println("Database setup failed!");
            e.printStackTrace();     
        }
    }

    public static ArrayList<BankAccount> loadAccounts(){
        ArrayList<BankAccount> accounts = new ArrayList<>();
        
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:bank.db");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM accounts")) {

            while (rs.next()) {
                int id = rs.getInt("id");
                double balance = rs.getDouble("balance");
                accounts.add(new BankAccount(id, balance));
            }
            
        } catch (Exception e) {
            System.out.println("Failed to load accounts: " + e.getMessage());
        }

        return accounts;
    }

    public static BankAccount createNewAccount(double balance) {
        String sql = "INSERT INTO accounts(balance) VALUES(?)";
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:bank.db");
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setDouble(1, balance);
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    return new BankAccount(rs.getInt(1), balance);
                }
            }
        } catch (SQLException e) {
            System.out.println("Failed to create new account: " + e.getMessage());
        }
        return null;
    }

    public static void saveAccounts(ArrayList<BankAccount> accounts) {
        String sql = "UPDATE accounts SET balance = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:bank.db");
             PreparedStatement ps = conn.prepareStatement(sql)) {

            for (BankAccount acc : accounts) {
                ps.setDouble(1, acc.getBalance());
                ps.setInt(2, acc.getId());
                ps.executeUpdate();
            }

            System.out.println("All accounts saved to DB.");
        } catch (SQLException e) {
            System.out.println("Failed to save accounts: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        //calling create table method 
        createTable();
        //calling load accounts method 
        ArrayList<BankAccount> accounts = loadAccounts();
        //calling save accounts method 
        saveAccounts(accounts);             
    }
}