package com.start.ecom.web;

import com.start.ecom.EcomRepository.ProductRepository;
import com.start.ecom.Entity.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Paths;
@CrossOrigin("*")
@RestController
public class productController {
    @Autowired
    private ProductRepository prod;
    @GetMapping(path="/photoProduct/{id}",produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getPhoto(@PathVariable("id") Long id) throws Exception{
        Products product = prod.findById(id).get();
        return Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/ecom/products/"+product.getProductImage()));
    }
    @PostMapping(path="/uploadPhoto/{id}")
    public void uploadPhoto(MultipartFile file,@PathVariable Long id) throws Exception{
        Products p = prod.findById(id).get();
        p.setProductImage(id+".jpg");
        Files.write(Paths.get(System.getProperty("user.home")+"/ecom/products/"+p.getProductImage()),file.getBytes());
        prod.save(p);
    }


}
