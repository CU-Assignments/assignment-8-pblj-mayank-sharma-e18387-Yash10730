import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Hardcoded credentials
        if ("admin".equals(username) && "password123".equals(password)) {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<h2>Welcome, " + username + "!</h2>");
        } else {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<h2>Invalid credentials. Try again!</h2>");
        }
    }
}
