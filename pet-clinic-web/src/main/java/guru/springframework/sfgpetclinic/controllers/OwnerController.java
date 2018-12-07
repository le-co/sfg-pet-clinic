package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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

    @GetMapping(value = "/{id}")
    public ModelAndView findById(@PathVariable Integer id) {

        ModelAndView mav = new ModelAndView("owners/show");

        Owner owner = this.ownerService.findById(id);

        mav.addObject("owner", owner);

        return mav;
    }

}
