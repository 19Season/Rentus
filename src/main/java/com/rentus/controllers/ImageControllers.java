package com.rentus.controllers;

import spark.utils.IOUtils;

import javax.servlet.MultipartConfigElement;
import javax.servlet.http.Part;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import static spark.Spark.post;

public class  ImageControllers {
    public static void uploadImage(){
        post("/api/upload", (req, res) -> {
            String destinationFolderLocation = "E:\\Rent-\\Rentus\\src\\main\\resources\\public\\image";
            req.attribute("org.eclipse.jetty.multipartConfig", new MultipartConfigElement(destinationFolderLocation));
            Part filePart = req.raw().getPart("myfile");
            String fileName = System.currentTimeMillis() + "_" + filePart.getSubmittedFileName().replace(" ","_");
            String destinationFilePath = destinationFolderLocation +"/"+ fileName;
            try (InputStream inputStream = filePart.getInputStream()) {
                OutputStream outputStream = new FileOutputStream(destinationFilePath);
                IOUtils.copy(inputStream, outputStream);
                outputStream.close();
            }catch (Exception e){
                e.printStackTrace();
            }
            return "http://localhost:1234/image/"+fileName;
        });
    }
}

