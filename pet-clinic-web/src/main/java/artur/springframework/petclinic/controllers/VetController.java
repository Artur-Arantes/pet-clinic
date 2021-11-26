package artur.springframework.petclinic.controllers;

import artur.springframework.petclinic.domain.Vet;
import artur.springframework.petclinic.services.VetServices;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class VetController {


  private final VetServices vetServices;

  @RequestMapping({"/vets", "/vets/index", "/vets/index.html", "vets.html"})
  public String listVets(Model model) {
    model.addAttribute("vets", vetServices.findAll());
    return "vets/index";
  }
  @GetMapping("/api/vets")
  public @ResponseBody List<Vet> getVetsJson(){
    return vetServices.findAll();
  }
}
