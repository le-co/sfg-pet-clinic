package guru.springframework.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping({"", "/", "index", "index.html"})
    public String index() {
        return "index";
    }

    @RequestMapping({"/oups", "notimplemented.html"})
    public String oups() {
        return "index";
    }

    @RequestMapping({"/error/{status}"})
    public String error(@PathVariable Integer status) {
        switch (status) {
            case 400:
                return "/error/400";
            case 404:
                return "/error/404";
            case 500:
                return "/error/500";
        }

        return "index";
    }
}
