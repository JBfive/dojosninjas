package com.jym.dojosninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jym.dojosninjas.models.Dojo;
import com.jym.dojosninjas.models.Ninja;
import com.jym.dojosninjas.services.DojoService;
import com.jym.dojosninjas.services.NinjaService;

@Controller
public class HomeController {
	private final NinjaService ninjaServ;
	private final DojoService dojoServ;
	
	public HomeController(NinjaService ninjaServ, DojoService dojoServ) {
		this.ninjaServ = ninjaServ;
		this.dojoServ = dojoServ;
	}
	@RequestMapping("/dojos/new")
	public String dojoNew(@Valid @ModelAttribute("dojos") Dojo dojo) {
		return "dojo.jsp";
	}
	@RequestMapping(value="/create_dojo", method=RequestMethod.POST)
	public String createDojo(@Valid @ModelAttribute("dojos") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "dojo.jsp";
		}else {
			dojoServ.createDojo(dojo);
			return "redirect:/dojos/new";
		}
	}
	@RequestMapping("/ninjas/new")
	public String ninjaNew(@Valid @ModelAttribute("ninjas") Ninja ninja, Model model) {
		model.addAttribute("dojoList", dojoServ.allDojos());
		return "ninja.jsp";
	}
	@RequestMapping(value="/create_ninja", method=RequestMethod.POST)
	public String createNinja(@Valid @ModelAttribute("ninjas") Ninja ninja, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println("This is not making it Controller");
			return "ninja.jsp";
		} else {
			System.out.println("This is making it Controller");
			ninjaServ.createNinja(ninja);
			return "redirect:/ninjas/new";
		}
	}
	@RequestMapping("/dojos/{id}")
	public String display(@PathVariable("id") Long id, Dojo dojo, Ninja ninja, Model model) {
		List<Ninja> ninjas = ninjaServ.allNinjas();
		model.addAttribute("ninja", ninjas);
		model.addAttribute("dojo", dojoServ.findDojo(id));
		return "list.jsp";
	}
}
