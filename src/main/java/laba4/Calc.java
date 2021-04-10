package laba4;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="Calc", urlPatterns="/JavaCalc") //связывание сервлета с URL
public class Calc extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestCalc Calc = RequestCalc.fromRequestParameters(request);
		Calc.setAsRequestAttributesAndCalculate(request);
		 
		request.getRequestDispatcher("/Results.jsp").forward(request, response);
		
	}
	
	private static class RequestCalc {
		private final String first_calc;
		private final String second_calc;
		private double result;
						
		private RequestCalc (String first, String second) {
			this.first_calc = first;
			this.second_calc = second;
			}
		
		public static RequestCalc fromRequestParameters(HttpServletRequest request) {
			return new RequestCalc(
			request.getParameter("first"),
			request.getParameter("second"));
			}
				
		public void setAsRequestAttributesAndCalculate(HttpServletRequest request) {
			request.setAttribute("first_result", first_calc);
			request.setAttribute("second_result", second_calc);
			double r;
			double h;
			try { 	
			r=Double.parseDouble(first_calc);
			h=Double.parseDouble(second_calc);
			if (r <= 0 || h <= 0) {
				throw new NumberFormatException();
			}
			result = (Math.PI * (r * r) * h) / 3;
			result = result * 10;
			}
			catch (NumberFormatException e) {
				result = 0;
			}
			
			request.setAttribute("result", result);
		}
		
	}
	
	
}
