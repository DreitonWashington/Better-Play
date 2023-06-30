package com.coralsoft.infra.filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.coralsoft.connection.SingleConnectionDB;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@WebFilter(urlPatterns =  "/adm*")
public class FilterAuthenticator extends HttpFilter implements Filter {
	private static final long serialVersionUID = 1L;

	private static Connection connection;
	
	public FilterAuthenticator() {

    }

	public void destroy() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		try {
			HttpServletRequest req = (HttpServletRequest) request;
			HttpSession session = req.getSession();
			
			String userLogin = (String) session.getAttribute("user");
			String urlAuthenticator = req.getServletPath();
			
			if(userLogin == null && !urlAuthenticator.equalsIgnoreCase("/ServletLogin")) {
				RequestDispatcher redirect = request.getRequestDispatcher("/index.jsp?url=" + urlAuthenticator);
				request.setAttribute("msg", "Por favor realize o login!");
				redirect.forward(request, response);
				
				return;
			}else{
				chain.doFilter(request, response);
			}			
			connection.commit();
		}catch(Exception e) {
			e.printStackTrace();
			RequestDispatcher redirecionar = request.getRequestDispatcher("index.jsp");
			request.setAttribute("msg", e.getMessage());
			redirecionar.forward(request, response);
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		connection = SingleConnectionDB.getConnection();
	}

}
