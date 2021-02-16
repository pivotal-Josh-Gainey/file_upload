package com.eof.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@Controller
public class MyController {

    @RequestMapping(method = RequestMethod.GET, value = "/test", produces = "application/json")
    public ResponseEntity<String> start(){
        System.out.println("Got request");
        try{
            Thread.sleep(5000);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("sending response");
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value="/upload", consumes = {"multipart/form-data"},produces = "application/json")
    public ResponseEntity<String> importQuestion(@Valid @RequestParam("file") MultipartFile MultipartFile) {
            System.out.println("success");
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }

}
