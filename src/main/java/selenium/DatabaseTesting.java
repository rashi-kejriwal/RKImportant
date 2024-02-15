package selenium;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseTesting {

    public static void main() throws ClassNotFoundException, SQLException {
        //Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"
        String dbUrl = "jdbc:mysql://localhost:3036/emp";

        //Database Username
        String username = "root";

        //Database Password
        String password = "guru99";

        //Query to Execute
        String query = "select *  from employee;";

        //Load mysql jdbc driver
        Class.forName("com.mysql.jdbc.Driver");

        //Create Connection to DB
        Connection con = DriverManager.getConnection(dbUrl,username,password);

        //Create Statement Object
        Statement stmt = con.createStatement();

        // Execute the SQL Query. Store results in ResultSet
        ResultSet rs= stmt.executeQuery(query);

        // While Loop to iterate through all data and print results
        while (rs.next()){
            String myName = rs.getString(1);
            String myAge = rs.getString(2);
            System. out.println(myName+"  "+myAge);
        }

        // closing DB Connection
        con.close();

    }


    /**
     * Convert the ResultSet to a List of Maps, where each Map represents a row with columnNames and columValues
     * @param rs
     * @return
     * @throws SQLException
     */
    private List<Map<String, Object>> resultSetToList(ResultSet rs) throws SQLException {
        ResultSetMetaData md = rs.getMetaData();
        int columns = md.getColumnCount();
        List<Map<String, Object>> rows = new ArrayList<Map<String, Object>>();
        while (rs.next()){
            Map<String, Object> row = new HashMap<String, Object>(columns);
            for(int i = 1; i <= columns; ++i){
                row.put(md.getColumnName(i), rs.getObject(i));
            }
            rows.add(row);
        }
        return rows;
    }
}
