package com.coralsoft.infra.web;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import java.util.stream.Collectors;

import com.coralsoft.domain.repository.GenreRepository;
import com.coralsoft.useCase.GenreUseCase;
import com.coralsoft.useCase.dtos.GenreRecord;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/adm/newVideo"})
public class ServletVideo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	GenreRepository genreRepository = new GenreUseCase();

    public ServletVideo() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("act");
		
		if(action.equalsIgnoreCase("searchGenre")) {
			try {
					List<GenreRecord> genres = genreRepository.findAll().stream()
							.map(genre -> new GenreRecord(genre.getId(), genre.getName())).collect(Collectors.toList());
					final StringWriter sw =new StringWriter();
					final ObjectMapper mapper = new ObjectMapper();
					mapper.findAndRegisterModules();
					mapper.writeValue(sw, genres);
				    sw.close();
				    response.getWriter().write(sw.toString());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
