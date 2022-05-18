package com.ogura.myshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ogura.myshop.entity.item.Item;
import com.ogura.myshop.service.OguraService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class ApiController {
    @Autowired
    OguraService oguraService;

    @GetMapping("/item")
    public List<Item> getItems() {
	List<Item> getTopData = oguraService.getItems();
	return getTopData;
    }
}
