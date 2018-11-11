package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/owners")
public class OwnerController {

    private OwnerService ownerService;

    @Autowired
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"", "/", "/owners/index", "/owners/index.html"})
    public String listAll(Model model) {
        model.addAttribute("items", this.ownerService.findAll());
        return "owners/index";
    }

    @RequestMapping({"/find"})
    public String notImplemented() {
        return "notimplemented";
    }
}
