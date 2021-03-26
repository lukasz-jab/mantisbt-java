package mantisbt.test;

import mantisbt.model.Project;
import org.testng.annotations.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbConnectionTest {

    @Test
    public void testDbConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/bugtracker?user=admin&password=password");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT name, id FROM mantis_project_table");
            List<Project> projects = new ArrayList<>();
            while (rs.next()) {
                projects.add(new Project(rs.getString("name"), rs.getInt("id")));
            }
            rs.close();
            st.close();
            conn.close();
            System.out.println(projects);


        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
}
