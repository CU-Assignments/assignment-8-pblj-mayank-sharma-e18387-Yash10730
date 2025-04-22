import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/employees")
public class EmployeeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String id = request.getParameter("id"); // If passed, we'll search by ID
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/employee_db", "root", "your_password");
            
            Statement stmt = conn.createStatement();
            ResultSet rs;
            
            if (id != null) {
                rs = stmt.executeQuery("SELECT * FROM employees WHERE id=" + id);
            } else {
                rs = stmt.executeQuery("SELECT * FROM employees");
            }
            
            out.println("<h2>Employee List</h2>");
            out.println("<table border='1'><tr><th>ID</th><th>Name</th><th>Department</th></tr>");
            while (rs.next()) {
                out.println("<tr><td>" + rs.getInt("id") + "</td><td>" +
                            rs.getString("name") + "</td><td>" +
                            rs.getString("department") + "</td></tr>");
            }
            out.println("</table>");
            
            conn.close();
        } catch (Exception e) {
            e.printStackTrace(out);
        }
    }
}
