package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.service.OwnerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequestMapping("/owners")
public class OwnerController {

    private OwnerService ownerService;

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        log.debug("By pass in properties id in object binder");
        dataBinder.setDisallowedFields("id");
    }

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
