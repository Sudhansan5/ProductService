package com.sudhan.ProductService.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class Sample {

    @GetMapping("/{name}")
    public String greet(@PathVariable String name){
        return "Hello "+ name;
    }
}
