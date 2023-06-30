package com.coralsoft.infra.web;

import java.io.IOException;
import java.util.Base64;

import com.coralsoft.domain.entity.User;
import com.coralsoft.domain.repository.UserRepository;
import com.coralsoft.useCase.UserUseCase;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@WebServlet(urlPatterns = {"/ServletLogin","/ServletLogin/index.jsp"})
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UserRepository userRepository = new UserUseCase();

    public ServletLogin() {

    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("email");
		String password = request.getParameter("password");
		String url = request.getParameter("url");
		
		
		if(login != null && password != null) {
			User user = new User();
			user.setEmail(login);
			
			byte[] encodePassword = Base64.getEncoder().encodeToString(password.getBytes()).getBytes();
			String encodePasswordC = new String(encodePassword);
			user.setPassword(encodePasswordC);
			
			if(userRepository.authenticate(user) == true) {
			
				request.getSession().setAttribute("user", user.getEmail());
				
				if(url.isEmpty() || url == null || url=="null") {
					url = "/adm/dashboard.jsp";
				}
				
				RequestDispatcher redirect = request.getRequestDispatcher(url);
				redirect.forward(request, response);
			}else {
				request.setAttribute("msg", "Usuário ou Senha inválidos");
				RequestDispatcher redirect = request.getRequestDispatcher("index.jsp");
				redirect.forward(request, response);
			}
			
		}else {
			request.setAttribute("msg", "Negado");
			RequestDispatcher redirect = request.getRequestDispatcher("index.jsp");
			redirect.forward(request, response);
		}
	}

}
