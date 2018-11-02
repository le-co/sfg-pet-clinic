package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.service.OwnerCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OwnerController {

    private OwnerCrudService ownerCrudService;

    @Autowired
    public OwnerController(OwnerCrudService ownerCrudService) {
        this.ownerCrudService = ownerCrudService;
    }

    @RequestMapping({"/owners", "/owners/index", "/owners/index.html"})
    public String listAll(Model model) {
        model.addAttribute("items", this.ownerCrudService.findAll());
        return "owners/index";
    }
}
