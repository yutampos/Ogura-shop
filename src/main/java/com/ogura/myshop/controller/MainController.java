package com.ogura.myshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ogura.myshop.entity.form.FormData;
import com.ogura.myshop.entity.item.Item;
import com.ogura.myshop.entity.item.ItemCreate;
import com.ogura.myshop.entity.item.ItemUpdate;
import com.ogura.myshop.service.OguraService;

@Controller
@RequestMapping
public class MainController {
    @Autowired
    OguraService oguraService;

    @GetMapping("/")
    public String top(Model model, @ModelAttribute FormData formData) {
	List<Item> getTopData = oguraService.getItems();
	model.addAttribute("getLatestList", getTopData);

	return "top";
    }

    @PostMapping("/search")
    public String seachView(Model model, @ModelAttribute FormData formData, FormData form, Item item) {

	Integer id = form.getSearchId();
	List<Item> findItems;
	if (id > 0) {
	    findItems = oguraService.findByGroupId(form);
	    model.addAttribute("findData", findItems);
	} else if (id == 0) {
	    findItems = oguraService.findByAll(form);
	    model.addAttribute("findData", findItems);
	}

	if (formData.getSearchName() != "") {
	    String searchTitle = formData.getSearchName() + "の検索結果";
	    model.addAttribute("searchTitle", searchTitle);
	} else {
	    String searchTitle = "検索結果";
	    model.addAttribute("searchTitle", searchTitle);
	}

	return "findView";
    }

    @GetMapping("/{id}")
    public String ItemPage(Model model, @PathVariable("id") int id, @ModelAttribute FormData formData, FormData form,
	    Item item) {
	Item getOnlyItem = oguraService.findByOnly(id);
	model.addAttribute("getOnlyItem", getOnlyItem);

	return "itemPage";
    }

//    @PostMapping("/cart")
//    public String cart() {
//
//	return "cart";
//    }
//
//    @PostMapping("/loggin")
//    public String loggin() {
//
//	return "loggin";
//    }

    // 以降オーナー設定画面
    @GetMapping("/orner")
    public String orner() {
	return "redirect:/update";
    }

    @GetMapping("/create")
    public String order(@ModelAttribute("itemSet") ItemCreate itemSet, Model model) {
	int status = 0;
	model.addAttribute("statusEnable", status);

	return "create";
    }

    @PostMapping("/set")
    public String setting(Model model, @ModelAttribute("itemSet") ItemCreate itemSet, ItemCreate itemCreate) {
	model.addAttribute("created", "登録しました");
	oguraService.itemCreate(itemCreate);

	return "redirect:/update";
    }

    @GetMapping("/update")
    public String update(Model model, @ModelAttribute("itemUpdate") ItemUpdate itemUpdate, FormData form) {
	List<Item> findItems = oguraService.findByAll(form);
	model.addAttribute("findData", findItems);

	return "update";
    }

    @GetMapping("/set/{id}")
    public String itemSet(Model model, @PathVariable("id") int id, Item item,
	    @ModelAttribute("itemUpdate") ItemUpdate itemUpdate) {
	Item getOnlyItem = oguraService.findByOnly(id);
	model.addAttribute("getOnlyItem", getOnlyItem);

	return "updateView";
    }

    @PostMapping("/set/{id}")
    public String itemReplace(Model model, @PathVariable("id") int id, Item item,
	    @ModelAttribute("itemUpdate") ItemUpdate itemUpdate) {
	itemUpdate.setItem_id(id);
	oguraService.itemUpdate(itemUpdate);

	Item getOnlyItem = oguraService.findByOnly(id);
	model.addAttribute("getOnlyItem", getOnlyItem);

	return "redirect:/update";
    }

    @GetMapping("/delete/{id}")
    public String itemSet(Model model, @PathVariable("id") int id, Item item) {
	oguraService.itemDelete(id);

	return "redirect:/update";
    }
}
