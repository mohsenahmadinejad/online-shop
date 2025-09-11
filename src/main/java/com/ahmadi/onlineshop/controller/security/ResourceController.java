package com.ahmadi.onlineshop.controller.security;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "1_USer", description = "Operations related to authentication")
@RestController
@RequestMapping("/resource")
public class ResourceController {

    @GetMapping("/secure")
    public ResponseEntity<String> secureResource(){
        return ResponseEntity.ok("Yes, Your JWT Works...");
    }
}
