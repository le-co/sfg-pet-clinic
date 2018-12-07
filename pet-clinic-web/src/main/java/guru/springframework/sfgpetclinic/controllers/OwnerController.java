package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/owners")
public class OwnerController {

    private OwnerService ownerService;

    @Autowired
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"", "/"})
    public String listAll(Model model) {
        model.addAttribute("items", this.ownerService.findAll());
        return "owners/index";
    }

    @RequestMapping({"/find"})
    public String notImplemented() {
        return "notimplemented";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String findById(Model model, @PathVariable Integer id) {

        Owner owner = this.ownerService.findById(id);
        if (owner == null) {
            return "redirect:error/404";
        }

        model.addAttribute("owner", owner);
        return "owners/show";
    }

}
