package com.coralsoft.infra.web;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import java.util.stream.Collectors;

import com.coralsoft.domain.repository.CategoryRepository;
import com.coralsoft.domain.repository.GenreRepository;
import com.coralsoft.useCase.CategoryUseCase;
import com.coralsoft.useCase.GenreUseCase;
import com.coralsoft.useCase.dtos.CategoryRecord;
import com.coralsoft.useCase.dtos.GenreRecord;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;



@MultipartConfig(fileSizeThreshold = 1024 * 1024,
maxFileSize = 1024 * 1024 * 1000, 
maxRequestSize = 1024 * 1024 * 1000 * 1000)
@WebServlet(urlPatterns = {"/adm/newVideo"})
public class ServletVideo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	GenreRepository genreRepository = new GenreUseCase();
	CategoryRepository categoryRepository = new CategoryUseCase();

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
		}else if(action.equalsIgnoreCase("searchCategory")) {
			try {
				List<CategoryRecord> categories = categoryRepository.findAll().stream()
						.map(category -> new CategoryRecord(category.getId(), category.getName())).collect(Collectors.toList());
					final StringWriter sw =new StringWriter();
					final ObjectMapper mapper = new ObjectMapper();
					mapper.findAndRegisterModules();
					mapper.writeValue(sw, categories);
				    sw.close();
				    response.getWriter().write(sw.toString());
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String applicationPath = request.getServletContext().getRealPath("/video");
	    String uploadFilePath = applicationPath + File.separator;
	    String fileName = null;
	    for(Part part : request.getParts()) {
	    	fileName = getFileName(part);
	    }
	    System.out.println(fileName);
//	    System.out.println(uploadFilePath);
//	    	for (Part part : request.getParts()) {
//	            fileName = getFileName(part);
//	            part.write(uploadFilePath + File.separator + fileName);
//	        }
	    }
	
	private String getFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
	    System.out.println("content-disposition header= "+contentDisp);
	    String[] tokens = contentDisp.split(";");
	    for (String token : tokens) {
	    	if (token.trim().startsWith("filename")) {
	    		return token.substring(token.indexOf("=") + 2, token.length()-1);
	        }
	    }
	    return "";
	}
	
	
}

	