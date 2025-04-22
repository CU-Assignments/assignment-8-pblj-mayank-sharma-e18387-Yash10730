import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/markAttendance")
public class AttendanceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        int rollNo = Integer.parseInt(request.getParameter("rollNo"));
        String date = request.getParameter("date");
        String status = request.getParameter("status");
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/student_db", "root", "your_password");

            PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO attendance (roll_no, date, status) VALUES (?, ?, ?)");
            ps.setInt(1, rollNo);
            ps.setDate(2, java.sql.Date.valueOf(date));
            ps.setString(3, status);

            int i = ps.executeUpdate();
            if (i > 0) {
                response.getWriter().println("<h2>Attendance Marked Successfully!</h2>");
            } else {
                response.getWriter().println("<h2>Failed to mark attendance!</h2>");
            }
            
            conn.close();
        } catch (Exception e) {
            e.printStackTrace(response.getWriter());
        }
    }
}
