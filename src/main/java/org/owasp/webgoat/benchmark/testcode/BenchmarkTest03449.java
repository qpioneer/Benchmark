package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03449")
public class BenchmarkTest03449 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a77808 = param; //assign
		StringBuilder b77808 = new StringBuilder(a77808);  // stick in stringbuilder
		b77808.append(" SafeStuff"); // append some safe content
		b77808.replace(b77808.length()-"Chars".length(),b77808.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map77808 = new java.util.HashMap<String,Object>();
		map77808.put("key77808", b77808.toString()); // put in a collection
		String c77808 = (String)map77808.get("key77808"); // get it back out
		String d77808 = c77808.substring(0,c77808.length()-1); // extract most of it
		String e77808 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d77808.getBytes() ) )); // B64 encode and decode it
		String f77808 = e77808.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f77808); // reflection
		
		
		String sql = "SELECT * from USERS where USERNAME='foo' and PASSWORD='"+ bar +"'";
				
		try {
			java.sql.Statement statement =  org.owasp.webgoat.benchmark.helpers.DatabaseHelper.getSqlStatement();
			statement.execute( sql, new int[] { 1, 2 } );
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}
}