package com.example.demo.controller;

import com.example.demo.dto.PageDTO;
import com.example.demo.services.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/series/frases")
public class PageDTOController {

    @Autowired
    private PageService service;

    @GetMapping
    public PageDTO getData () {
        return service.randomData();
    }

}
