/*import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

public class HelloServlet extends HttpServlet
{
    public void doGet(HttpServletRequest req,
                      HttpServletResponse res)
                      throws IOException
    {
        res.setContentType("text/html");

        PrintWriter out = res.getWriter();

        out.println("<h1>Hello Sathyamoorthy!</h1>");
        out.println("<p>My first Java Servlet</p>");
    }
}*/
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
 
public class HelloServlet extends HttpServlet {
 
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
 
        response.setContentType("text/html;charset=UTF-8");
 
        String username = request.getParameter("username");
        String password = request.getParameter("password");
 
        PrintWriter out = response.getWriter();
 
        out.println("<html><body>");
 
        if ("SATHISH".equals(username) &&
            "12345".equals(password)) {
 
            out.println("<h2>Login Successful!</h2>");
            out.println("<p>Welcome, " + username + "</p>");
 
        } else {
            out.println("<h2>Invalid Username or Password!</h2>");
            out.println("<a href='https://www.amazon.in/?&tag=googhydrabk1-21&ref=pd_sl_5szpgfto9i_e&adgrpid=155259813593&hvpone=&hvptwo=&hvadid=825671333270&hvpos=&hvnetw=g&hvrand=12079001455498181808&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=9061910&hvtargid=kwd-64107830&hydadcr=14452_2479340&mcid=e9c68a2d0f333bcaacd29ec00843c329&hvocijid=12079001455498181808--&hvexpln=nav&gad_source=1'>Try Again</a>");
        }
 
        out.println("</body></html>");
    }
}