import java.sql.*;
import java.util.ArrayList;

public class DBUtility {
    private static String user = "student";
    private static String password = "student";

    public static int insertNewPatient(Patient newPatient) throws SQLException {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        int patientID = -1;

        //Here's the super cool part Cam wishes he was here for...
        try{
            //1. connect to the database
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/camsChoice",
                                    user, password);
            //2. Create SQL String
            String sql = "INSERT INTO patients (firstName, lastName, phone, city, province) " +
                    "VALUES (?,?,?,?,?)";

            //3. prepare the query with the SQL
            preparedStatement = conn.prepareStatement(sql, new String[] {"patientID"});

            //4. bind the values to the datatypes
            preparedStatement.setString(1, newPatient.getFirstName());
            preparedStatement.setString(2, newPatient.getLastName());
            preparedStatement.setString(3, newPatient.getPhone());
            preparedStatement.setString(4, newPatient.getCity());
            preparedStatement.setString(5, newPatient.getProvince());

            //5. execute the insert
            preparedStatement.executeUpdate();

            //6. get the patient ID
            ResultSet rs = preparedStatement.getGeneratedKeys();

            while (rs.next())
            {
                patientID = rs.getInt(1);
            }
        } catch(Exception e)
        {
            e.printStackTrace();
        }
        //The finally block will ALWAYS run whether an excpetion is triggered or not
        finally {
            if (preparedStatement != null)
                preparedStatement.close();
            if (conn != null)
                conn.close();
            return patientID;
        }
    }

    public static ArrayList<Patient> getAllPatients() throws SQLException {
        ArrayList<Patient> patients = new ArrayList<>();
        Connection conn = null;
        Statement sqlStatement = null;
        ResultSet resultSet = null;

        try{
            //1. connect to the DB
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/camsChoice",
                    user, password);

            //2. create a statement object
            sqlStatement = conn.createStatement();

            //3. create the SQL query
            resultSet = sqlStatement.executeQuery("SELECT * FROM patients");

            //4. loop over the result set and create Patient objects
            while (resultSet.next())
            {
                Patient newPatient = new Patient(resultSet.getInt("patientID"),
                                            resultSet.getString("firstName"),
                                            resultSet.getString("lastName"),
                                            resultSet.getString("phone"),
                                            resultSet.getString("city"),
                                            resultSet.getString("province"));
                patients.add(newPatient);
            }

        }catch ( Exception e)
        {
            e.printStackTrace();
        }
        finally {
            if (conn !=null) conn.close();
            if (resultSet != null) resultSet.close();
            if (sqlStatement != null) resultSet.close();
            return patients;
        }
    }
}
