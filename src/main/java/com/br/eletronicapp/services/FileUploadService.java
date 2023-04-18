package com.br.eletronicapp.services;

import org.springframework.stereotype.Service;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class FileUploadService {
    @Value("${file.upload.folder}")
    private String fileUploadFolder;

    public File saveOnDisk(MultipartFile webFile) throws Exception {
        Path folderPath = Paths.get(fileUploadFolder);
        Files.createDirectories(folderPath);
        Path newFilePath = folderPath.resolve(webFile.getOriginalFilename());
        Files.copy(webFile.getInputStream(), newFilePath, StandardCopyOption.REPLACE_EXISTING);
        return newFilePath.toFile();

    }

}
