import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class q1
 */
@WebServlet("/q1")
public class q1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public q1() {
    	
        super();
        System.out.println("##########");
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String xyStr=request.getParameter("key");
		if (xyStr==null||xyStr.length()<1){
			PrintWriter out = response.getWriter();
	        out.println("enter something");
	        out.close();

		}
	    BigInteger xyInt=new BigInteger(xyStr);
		String xStr="6876766832351765396496377534476050002970857483815262918450355869850085167053394672634315391224052153";
		BigInteger xInt=new BigInteger(xStr);
		
		BigInteger yNum=xyInt.divide(xInt);
		String yStr=yNum.toString();
		
		Calendar calendar = Calendar.getInstance();
		 
		java.util.Date now = calendar.getTime();
		 
		java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date fechaNueva = null;
		try {
			fechaNueva = format.parse(currentTimestamp.toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PrintWriter out = response.getWriter();
        out.println(yStr+"\n"+"Unbreakables,7202-9686-0386,9051-9122-9897, 3073-7200-6314"+"\n"+format.format(fechaNueva).toString()+"\n");
        out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
