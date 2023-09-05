package com.kunal.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DockController {
    @GetMapping("/name")
    public String name(){
        return "Kunal";
    }

    @GetMapping("/age")
    public int age(){
        return 23;
    }

    @GetMapping("/address")
    public String address(){
        return "Hinjawadi,Pune-411057";
    }
}
