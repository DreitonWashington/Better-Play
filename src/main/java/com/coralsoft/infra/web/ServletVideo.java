package com.coralsoft.infra.web;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
		String title = request.getParameter("title");
		String slug = request.getParameter("slug");
		String description = request.getParameter("descricao");
		String yearLaunched = request.getParameter("anoLancamento");
		String duration = request.getParameter("duracao");
		String censure = request.getParameter("censura");
		String category = request.getParameter("categoria");
		String genre = request.getParameter("valuesGenre");
		String[] genreIds = genre.split(",");
		
		//String applicationPath = request.getServletContext().getRealPath("/video/");
		String applicationPath = "C:\\Users\\dreit\\OneDrive\\Área de Trabalho\\workspace-eclipse-ee\\better-play\\src\\main\\webapp\\video\\";
		String pathNewMediaFolder = applicationPath+title;
		String pathNewMediaInFolder = applicationPath+title+"\\";
		
		System.out.println(createFolder(pathNewMediaFolder, pathNewMediaInFolder));

//		Part banner = request.getPart("banner");
//		System.out.println(saveMediaImage(banner, pathNewMediaInFolder + "\\banner"));
//		
//		Part thumb = request.getPart("thumb");
//		System.out.println(saveMediaImage(thumb, pathNewMediaInFolder + "\\thumbFolder"));
//		
//		Part halfThumb = request.getPart("halfThumb");
//		System.out.println(saveMediaImage(halfThumb, pathNewMediaInFolder + "\\halfThumbFolder"));
		
		System.out.println(saveMedia(request, pathNewMediaInFolder));
		

	}
	
	private String createFolder(String pathNewMediaFolder, String pathNewMediaInFolder) {
		Path path = Paths.get(pathNewMediaInFolder);
		if(Files.exists(path)) {
			return "Já existe esse filme...";
		}else {
			boolean pasta = new File(pathNewMediaFolder).mkdir();
			var bannerFolder = new File(pathNewMediaFolder+"\\banner").mkdirs();
			var thumbFolder = new File(pathNewMediaFolder+"\\thumbFolder").mkdirs();
			var thumbHalfFolder = new File(pathNewMediaFolder+"\\halfThumbFolder").mkdirs();
			return "Criado...";
		}			
	}
	
	private String saveMediaImage(Part part, String pathNewMediaInFolder) {
		String nomeArquivo = Paths.get(part.getSubmittedFileName()).getFileName().toString();
	    Path caminhoCompleto = Paths.get(pathNewMediaInFolder, nomeArquivo);
	    
	    try {
            Files.copy(part.getInputStream(), caminhoCompleto);
            return "Imagem salva com sucesso em: " + caminhoCompleto;
        } catch (IOException e) {
            return "Erro ao salvar a imagem: " + e.getMessage();
        }
	}
	
	private String saveMedia(HttpServletRequest request, String pathNewMediaInFolder) throws IOException, ServletException {
		Part filePart = request.getPart("media");
	    String fileName = filePart.getSubmittedFileName();
	    for (Part parts : request.getParts()) {
	      parts.write(pathNewMediaInFolder + fileName);
	    }
	    return "The file uploaded sucessfully." + Paths.get(pathNewMediaInFolder + fileName);
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

	