import java.sql.*;

public class Main {
    public static void main(String[] args) {
//        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\arnas\\Downloads\\Udemy\\Java_Masterclass_Udemy\\Section19\\From320\\testjava.db");
//             Statement statement = conn.createStatement()) {
//
////            statement.execute("DROP TABLE contacts");
//            statement.execute("CREATE TABLE contacts (name TEXT, phone INTEGER, email TEXT)");
//        } catch (SQLException e) {
//            System.err.println("Something went wrong: " + e.getMessage());
//        }

        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\arnas\\Downloads\\Udemy\\Java_Masterclass_Udemy\\Section19\\From320\\testjava.db");
//            conn.setAutoCommit(false);
            Statement statement = conn.createStatement();

//            statement.execute("DROP TABLE contacts");
            statement.execute("CREATE TABLE IF NOT EXISTS " +
                    "contacts(name TEXT, phone INTEGER, email TEXT)");
//            statement.execute("INSERT INTO contacts(name, phone, email) " +
//                    "VALUES('Joe', 45632, 'joe@anywhere.com')");
//            statement.execute("INSERT INTO contacts(name, phone, email) " +
//                    "VALUES('Jane', 789654, 'jane@somewhere.com')");
//            statement.execute("INSERT INTO contacts(name, phone, email) " +
//                    "VALUES('Fido', 6543, 'dog@email.com')");
//            statement.execute("UPDATE contacts SET phone=5564832 WHERE name='Jane'");
//            statement.execute("DELETE FROM contacts WHERE name='Joe'");
            statement.execute("SELECT * FROM contacts");
            ResultSet results = statement.getResultSet();
            while(results.next()) {
                System.out.println(results.getString("name") + " " +
                        results.getInt("phone") + " " +
                        results.getString("email"));
            }
            results.close();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            System.err.println("Something went wrong: " + e.getMessage());
        }
    }
}
