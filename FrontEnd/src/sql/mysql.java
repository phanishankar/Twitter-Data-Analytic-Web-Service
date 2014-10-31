package sql;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Q2
 */
@WebServlet("/q2")

public class mysql extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection = null;
	
    /**
     * @throws SQLException 
     * @throws ClassNotFoundException 
     * @see HttpServlet#HttpServlet()
     */
    public mysql() throws SQLException, ClassNotFoundException {
        super();
        
		Class.forName("com.mysql.jdbc.Driver");
			
		connection = DriverManager
			          .getConnection("jdbc:mysql://localhost/twitterSubset?"
			              + "user=root&password=pp123");
		
		return;
		}
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		
		ArrayList<String> tweets = new ArrayList<String>(); // to store all of the tweets

		// Get the parameters from URL
		String userid = "";
		String tweet_time = "";
		userid = request.getParameter("userid");
		tweet_time = request.getParameter("tweet_time");
		
		
		if (tweet_time==null||userid==null){
			PrintWriter out = response.getWriter();
	        out.println("enter something");
	        out.close();
		}
		
		// Query
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement
					.executeQuery("select * from twitterSet where timestamp = \""
							+ tweet_time + "\" and userid = " + userid);
			while (rs.next()) {
				String id= new String(rs.getBytes("id"),"UTF-8");
				String sentiment = new String(rs.getBytes("sentiment"),"UTF-8");
				String censor = new String(rs.getBytes("censoredtext"),"UTF-8");
				tweets.add(id+":"+sentiment+":"+censor);
			}
			rs.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// Sort
		Collections.sort(tweets);
		
		// Output Group information
		response.getWriter().println("Unbreakables,7202-9686-0386,9051-9122-9897,3073-7200-6314");
				

		// Output
		for (String s : tweets) {
			response.getWriter().println(s);
		}
	}

}

