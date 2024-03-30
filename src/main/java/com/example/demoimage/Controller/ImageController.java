package com.example.demoimage.Controller;

import com.example.demoimage.Entity.ImageData;
import com.example.demoimage.Repository.StorageRepository;
import com.example.demoimage.Service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;


@RequestMapping("/image")
@RestController
public class ImageController {

    @Autowired
    private StorageService service;

    @PostMapping
    public ResponseEntity<?> uploadImage(@RequestParam("image")MultipartFile file) throws IOException {
        String uploadImage = service.uploadImage(file);
        return ResponseEntity.status(HttpStatus.OK)
                .body(uploadImage);
    }

    /* How to test tes post mapping:
    After debuging just open postman with the link to post

    Upload Test Images: Use Postman or any other API testing tool to send POST requests to your /upload endpoint, providing the test images as multipart form data. Here's how you can do it with Postman:

Open Postman.
Create a new POST request to your /upload endpoint.
In the request body, select "form-data".
Add a key-value pair where the key is "file" and the value is the test image file.
Send the request.
Verify Upload: After uploading the images, verify that they are saved correctly in your database. You can check this directly by querying your database or by using a tool like MySQL Workbench.

Retrieve Test Images: Send GET requests to your /images/{id} endpoint, providing the ID of each uploaded image to retrieve them. You can again use Postman for this:

Create a new GET request to your /images/{id} endpoint, replacing {id} with the ID of the uploaded image.
Send the request.
Verify that the response contains the image data and that the content type is correct based on the image format.
Verify Image Content: Optionally, you can visually inspect the retrieved images to ensure they are displayed correctly and have the expected content.
     */

    @GetMapping("/{fileName}")
    public ResponseEntity<?> downloadImage(@PathVariable String fileName){
        byte[] imageData=service.downloadImage(fileName);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .contentType(MediaType.valueOf("image/jpeg"))
                .contentType(MediaType.valueOf("image/jpg"))
                .body(imageData);

    }

}
