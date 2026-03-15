package com.inventcontrol.backend.services.fileStorage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileStorageService {

    @Value("${upload.path}")
    private String uploadPath;

    public String storeFile(MultipartFile file) {
        try {
            // 1. Crear la carpeta si no existe
            Path root = Paths.get(uploadPath);
            if (!Files.exists(root)) {
                Files.createDirectories(root);
            }
            String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();

            Files.copy(file.getInputStream(), root.resolve(fileName));

            return fileName;
        } catch (IOException e) {
            throw new RuntimeException("No se pudo guardar la imagen: " + e.getMessage());
        }
    }
    public void deleteFile(String fileName) {
        try {
            Path file = Paths.get(uploadPath).resolve(fileName);
            Files.deleteIfExists(file);
        } catch (IOException e) {
            throw new RuntimeException("No se pudo eliminar el archivo físico: " + e.getMessage());
        }
    }
}