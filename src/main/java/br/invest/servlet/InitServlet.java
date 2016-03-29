package br.invest.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InitServlet
 */
@WebServlet(loadOnStartup=1, value="/InitServlet")
public class InitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public InitServlet() {
        super();
    }
    @Override
    public void init() throws ServletException {
    	super.init();
    	System.out.println("Contexto: "+this.getServletConfig().getServletContext().getContextPath());
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().write("Hello Servlet 3.0");
		response.flushBuffer();
	}

}
