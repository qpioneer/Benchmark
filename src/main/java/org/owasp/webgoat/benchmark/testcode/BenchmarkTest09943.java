package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest09943")
public class BenchmarkTest09943 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = new Test().doSomething(param);
		
		response.getWriter().println(bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map25016 = new java.util.HashMap<String,Object>();
		map25016.put("keyA-25016", "a_Value"); // put some stuff in the collection
		map25016.put("keyB-25016", param.toString()); // put it in a collection
		map25016.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map25016.get("keyB-25016"); // get it back out
		bar = (String)map25016.get("keyA-25016"); // get safe value back out

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass