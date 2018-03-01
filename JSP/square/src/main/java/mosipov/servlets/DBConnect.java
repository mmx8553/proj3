package mosipov.servlets;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
//java.util.logging.*;

public class DBConnect {


    //private final String url = "jdbc:mysql://127.0.0.1:3306/db1?serverTimezone=UTC";
    private  final String url = "jdbc:mysql://46.147.237.64:6003/db1?serverTimezone=UTC";

    //Имя пользователя БД
    private  final String name = "mmx";
    //Пароль
    private  final String password = "8552";


    /**
     *
     * @param userName
     * @param color
     */
    public  synchronized  void  writeDB(String userName, String color){
        String usr = userName;
        String clr = color;
        Connection connection = null;
        try {

            //Class.forName("org.postgresql.Driver");
        	//Class.forName("com.mysql.cj.jdbc.Driver");
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, name, password);
            
            PreparedStatement  preparedStatement = connection.prepareStatement(
                    "INSERT INTO aaa(user_name, color) values(?,?)");
            if (usr == null) {
                usr = "null value";
            }
            if (clr == null) {
                clr = "null value";
            }
            preparedStatement.setString(1, usr);
            preparedStatement.setString(2, clr);
            preparedStatement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    private   List<UserVisitBean> resultSetToList(ResultSet resultSet) {
        List<UserVisitBean> listToReturn = new ArrayList<UserVisitBean>();
        try {
            while (resultSet.next()) {
                String user = resultSet.getString("user_name");
                String color = resultSet.getString("color");
                String dateOfColorChange = resultSet.getString("insert_dt");
                listToReturn.add(new UserVisitBean(user,color, dateOfColorChange));
            }
        } catch(SQLException se) {
            se.printStackTrace();
            }
        finally{}

        return  listToReturn;

    }


    public synchronized List<UserVisitBean> getUserColorListFromDB() {
        List<UserVisitBean> listToReturn = null;
        ResultSet resultSetToTempStore = null;
        Connection connection = null;
        try {
            //Class.forName("org.postgresql.Driver");
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, name, password);
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT all id, user_name, color, insert_dt FROM aaa ");
            resultSetToTempStore =  preparedStatement.executeQuery();
            //System.err.println(resultSetToTempStore.toString());
            listToReturn = resultSetToList(resultSetToTempStore);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return   listToReturn;
    }
}
