package com.cynapsys.controllers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cynapsys.Repositories.BulletinSoinRepository;
import com.cynapsys.entities.BulletinSoin;


@RestController
@RequestMapping("/bulletin")
@CrossOrigin("*")
public class BulletinSoinController {

	private final Logger logger = LoggerFactory.getLogger(BulletinSoinController.class) ;
	
	private final String UPLOADED_FOLDER = "C:\\Users\\ghazi\\Desktop\\stage cynapsys\\bulletins\\";
	
	
	
	@Autowired
	private BulletinSoinRepository bsr;
	
	
	
	
	
	@PostMapping("/add-bulletin")
	public String addBulletin(@RequestBody BulletinSoin bulletinSoin) {
		
		bsr.save(bulletinSoin);
		
		return "ok";
	}
	
	
	
	@PostMapping("/uploadBulletinFile")
	public String uploadBulletinFile(@RequestParam("file") MultipartFile file) {
		
		logger.debug("single file !");
		
		
		if(file.isEmpty()) {
			logger.debug("empty !");
		}
		
		
		
		try {
			saveUploadedFiles(Arrays.asList(file));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return file.getOriginalFilename();
	}
	
	
	
	
	@GetMapping("/uploadBulletinFile/{name}")
	public ResponseEntity<InputStreamResource> download(@PathVariable String name) throws IOException {


		File file = new File(UPLOADED_FOLDER+name);

	    InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

	    return ResponseEntity.ok()
	            .contentLength(file.length())
	            .contentType(MediaType.parseMediaType("application/octet-stream"))
	            .body(resource);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	//--------------------save file
    private void saveUploadedFiles(List<MultipartFile> files) throws IOException {

        for (MultipartFile file : files) {

            if (file.isEmpty()) {
                continue; //next pls
            }

            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);

        }
    }
    
    
    
    
}
