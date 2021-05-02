package com.plateit.project.servicess;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.plateit.project.models.Image;

@Service 
public interface ImageService {
public Image uploadFileService(MultipartFile file);
}
