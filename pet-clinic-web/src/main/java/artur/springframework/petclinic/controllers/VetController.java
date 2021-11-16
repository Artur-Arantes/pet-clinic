package artur.springframework.petclinic.controllers;

import artur.springframework.petclinic.services.VetServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class VetController {

  private final VetServices vetServices;

  @RequestMapping({"/vets", "/vets/index", "/vets/index.html"})
  public String listVets(Model model) {
    model.addAttribute("vets",vetServices.findAll());
    return "vets/index";
  }
}
