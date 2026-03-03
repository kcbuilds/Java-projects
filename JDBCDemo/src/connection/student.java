package connection;

import java.sql.*;

public class student {
    String url = "jdbc:mysql://localhost:3306/";
    String db = "DB";
    String username = "root";
    String password = "root123";

    public void createDatabase()  {
        // Driver Load --> Already In-Builds

        // Connection establish
        try {

            // Connection
            Connection conn = DriverManager.getConnection(url, username, password);

            // statement create
            Statement statement = conn.createStatement();
            String createdb = "create database DB";
            boolean execute = statement.execute(createdb);
            System.out.println("Connection Successful: " + execute);
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createTable() {
        // Connection establish
        try {

//          Connection -->
//          Connection conn = DriverManager.getConnection(url + db, username, password);
            Connection conn = DriverManager.getConnection(url, username, password);

            // statement create
            Statement statement = conn.createStatement();
            String createtable = "create table student (sId int(3) primary key, studentName varchar(100), studentEmail varchar(100) unique)";
            statement.execute(createtable);
            System.out.println("Table created Successfully");
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertData() {
        // Connection establish
        try {

//        Connection -->
          Connection conn = DriverManager.getConnection(url + db, username, password);

            // statement create
//            Statement statement = conn.createStatement();
//            String createtable = "insert into student values (01, 'Karan Chaurasiya', 'karan@example.com')";
//            statement.execute(createtable); --> One Way

            String addData = "insert into student (Sid, studentName, studentEmail) values (?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(addData);
            preparedStatement.setInt(1,4);
            preparedStatement.setString(2,"Amar Roy");
            preparedStatement.setString(3,"amar@example.com");

//            preparedStatement.execute();
//            OR
            preparedStatement.executeUpdate(); // Both work same

            System.out.println("Data inserted Successfully");
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void readData() {
        // Connection establish
        try {

//          Connection -->
            Connection conn = DriverManager.getConnection(url + db, username, password);

            // statement create

            String readData = "select * from student";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(readData);

            while (resultSet.next()){
                System.out.print("studentId = " +resultSet.getInt(1) +", ");
                System.out.print("studentName = " +resultSet.getString(2) +", ");
                System.out.print("studentEmail = " +resultSet.getString(3));
                System.out.println();
            }
            System.out.println("Read Successfully");
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateData() {
        // Connection establish
        try {
//          Connection -->
            Connection conn = DriverManager.getConnection(url + db, username, password);

            // statement create

            String updateData = "update student set sId = ? where studentName = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(updateData);
            preparedStatement.setInt(1,5);
            preparedStatement.setString(2,"Prem Mokashi");
            preparedStatement.execute();

            System.out.println("Update Successfully");
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteData() {
        try {
            // Connection establish
            Connection conn = DriverManager.getConnection(url + db, username, password);

            // Statement Created
            String deleteQuery = "delete from student where sId = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(deleteQuery);
            preparedStatement.setInt(1,1);

            // Execute Query
            preparedStatement.execute();

            // Conn Close
            conn.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
