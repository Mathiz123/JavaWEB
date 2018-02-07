package dk.tec.rkr;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Calendar cal = Calendar.getInstance();
		String greeting;
		int hourOfDay = cal.get(Calendar.HOUR_OF_DAY);
		if (hourOfDay < 12) {
			greeting = "Good Morning biatch!";
		} else if (hourOfDay >= 12 && hourOfDay < 18) {
			greeting = "Good Afternoon!";
		} else if (hourOfDay >= 18 && hourOfDay < 23) {
			greeting = "Good Evening!";
		} else {
			greeting = "Good Night!";
		}
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Hello World</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Hello World!</h1>");
		out.println("<h1>Today it is " + cal.getTime().toString() + "</h1>");
		out.println("<h1>" + greeting + "</h1>");
		out.println("</body>");
		out.println("</html>");
	}
}