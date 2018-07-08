package com.cynapsys.controllers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cynapsys.Repositories.ArticleMedicalRepositories;
import com.cynapsys.Repositories.BulletinSoinRepository;
import com.cynapsys.entities.ArticleMedical;
import com.cynapsys.entities.BulletinSoin;
import com.mysql.fabric.xmlrpc.base.Array;


@RestController
@RequestMapping("/bulletin")
@CrossOrigin("*")
public class BulletinSoinController {

	private final Logger logger = LoggerFactory.getLogger(BulletinSoinController.class) ;
	
	private final String UPLOADED_FOLDER_BULLETIN = "C:\\Users\\ghazi\\Desktop\\stage cynapsys\\bulletins\\";
	private final String UPLOADED_FOLDER_ARTICLES = UPLOADED_FOLDER_BULLETIN+"\\articles\\";

	
	
	@Autowired
	private BulletinSoinRepository bsr;
	@Autowired
	private ArticleMedicalRepositories amr;
	
	
	
	
	@DeleteMapping("/delete/article/{id}")
	public String deleteArticle(@PathVariable Long id) {
		
		ArticleMedical am = amr.getOne(id);
		
		am.setActive(false);
		
		amr.save(am);
		
		return "ok";
	}
	
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		
		BulletinSoin bs = bsr.findById(id).get();
		
		bs.setActive(false);
		
		bs.setArticleMedicals(bs.getArticleMedicals().stream().map(am -> new ArticleMedical(am.getId(),am.getUrlFichier(), am.getLibelle(), am.getDescription(), am.getPrix(), am.getQuantite(), am.getBulletinSoin(), false)).collect(Collectors.toList()));
		
		bsr.save(bs);
		
		return "ok";
		
	}
	
	
	@GetMapping("/all")
	public List<BulletinSoin> getAll(){
		
		return bsr.findAll().stream().filter( bs -> bs.isActive() == true).collect(Collectors.toList());
		
	}
	
	
	@GetMapping("/{id}")
	public BulletinSoin getById(@PathVariable Long id) {
		
		BulletinSoin bs = bsr.findById(id).orElse(null);
		
		bs.setArticleMedicals(bs.getArticleMedicals().stream().filter(a -> a.isActive() == true).collect(Collectors.toList()));
		
		return bs;
	}
	
	
	
	
	@PostMapping("/add-bulletin")
	public String addBulletin(@RequestBody BulletinSoin bulletin) {
		
		Date date = new Date();
		
		bulletin.setDateAffiliation(date);
		
		bsr.save(bulletin);
		
		return "ok";
	}
	
	
	
	@PostMapping("/uploadArticlesFile")
	public String uploadArticlesFile(@RequestParam("files") MultipartFile[] files) {
	
		try {
			saveUploadedFiles(Arrays.asList(files), UPLOADED_FOLDER_ARTICLES);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "ok";
	}
	
	
	@PostMapping("/uploadBulletinFile")
	public String uploadBulletinFile(@RequestParam("file") MultipartFile file) {
		
		logger.debug("single file !");
		
		
		if(file.isEmpty()) {
			logger.debug("empty !");
		}
		
		
		
		try {
			saveUploadedFiles(Arrays.asList(file), UPLOADED_FOLDER_BULLETIN);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return file.getOriginalFilename();
	}
	
	
	
	@GetMapping("/downloadArticleFile/{name}")
	public ResponseEntity<InputStreamResource> downloadArticle(@PathVariable String name) throws IOException {


		File file = new File(UPLOADED_FOLDER_ARTICLES+name);

	    InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

	    return ResponseEntity.ok()
	            .contentLength(file.length())
	            .contentType(MediaType.parseMediaType("application/octet-stream"))
	            .body(resource);
	}
	
	@GetMapping("/downloadBulletinFile/{name}")
	public ResponseEntity<InputStreamResource> downloadBulletin(@PathVariable String name) throws IOException {


		File file = new File(UPLOADED_FOLDER_BULLETIN+name);

	    InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

	    return ResponseEntity.ok()
	            .contentLength(file.length())
	            .contentType(MediaType.parseMediaType("application/octet-stream"))
	            .body(resource);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	//--------------------save file
    private void saveUploadedFiles(List<MultipartFile> files, String directory) throws IOException {

        for (MultipartFile file : files) {

            if (file.isEmpty()) {
                continue; //next pls
            }

            byte[] bytes = file.getBytes();
            Path path = Paths.get(directory + file.getOriginalFilename());
            Files.write(path, bytes);

        }
    }
    
    
    
   
    
    
    
}
