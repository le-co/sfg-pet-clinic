package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.service.VetCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetController {

    private VetCrudService vetCrudService;

    @Autowired
    public VetController(VetCrudService vetCrudService) {
        this.vetCrudService = vetCrudService;
    }

    @RequestMapping({"/vets", "/vets/index", "/vets/index.html"})
    public String listAll(Model model){
        model.addAttribute("items", this.vetCrudService.findAll());
        return "vets/index";
    }
}
