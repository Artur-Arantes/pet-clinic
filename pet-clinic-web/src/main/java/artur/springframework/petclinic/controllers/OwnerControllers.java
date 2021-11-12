package artur.springframework.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/owners")
@Controller
public class OwnerControllers {

  @RequestMapping({"","/","/index","owners/index.html"})
  public String ownersList(){
    return "owners/index";
  }
}
