package artur.springframework.petclinic.controllers;

import artur.springframework.petclinic.services.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/owners")
@Controller
@RequiredArgsConstructor
public class OwnerControllers {

  private final OwnerService ownerService;

  @RequestMapping({"","/","/index","owners/index.html"})
  public String ownersList(Model model){
    model.addAttribute("owners",ownerService.findAll());
    return "owners/index";
  }
}
