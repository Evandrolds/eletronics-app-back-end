package com.br.eletronicapp.services;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {

    @Value("${file.upload.folder}")
    private String fileUploadFolder;

    public File saveOnDisk(MultipartFile webFile, Integer id) throws Exception {

        //Pegando diretório pelo arquivo.properties (fileUploadFolder)
        Path folderPath = Paths.get(fileUploadFolder);
        Path produto = Paths.get("", "produto-" + String.format("%04d", id) + webFile.getOriginalFilename().substring(webFile.getOriginalFilename().length() - 4, webFile.getOriginalFilename().length()));

        Path newFilePath = folderPath.resolve(produto.getFileName());

        Files.copy(webFile.getInputStream(), newFilePath, StandardCopyOption.REPLACE_EXISTING);

        return newFilePath.toFile();

    }

}
