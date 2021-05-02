package com.plateit.project.servicess;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.plateit.project.models.Image;

@Service
public class ImageServiceImplemantation implements ImageService{
	
	@Value("${com.plateit.project.properties.fileUploadPath}")
	private String uploadFolderPath;
	private UUID fileName;  
	
	public Image uploadFileService(MultipartFile file) {
		Image image = new Image();
		try {
			fileName = UUID.randomUUID();
			String type = file.getContentType().substring(file.getContentType().indexOf('/')+1);
			byte [] data = file.getBytes();
			Path path = Paths.get(uploadFolderPath+ fileName.toString()+"."+type);
			Files.write(path, data);
			
			 image.setId(fileName.toString());
			 image.setName(file.getOriginalFilename());
			 
			 image.setMimeType(file.getContentType());
			 image.setSize(file.getSize());
			 image.setUri(path.toString());
			 
			
		}catch(IOException ex) {
			ex.printStackTrace();
			image = null;
		}

		return image;

		
	}

}
