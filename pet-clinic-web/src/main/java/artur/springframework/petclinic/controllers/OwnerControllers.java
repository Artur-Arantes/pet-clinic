package artur.springframework.petclinic.controllers;

import artur.springframework.petclinic.services.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
  @RequestMapping("/find")
  public String findOwners(){
    return "notimplemented";
  }
  @GetMapping("/{ownerId}")
  public ModelAndView showOwner(@PathVariable("ownerId") Long ownerId){
    ModelAndView mav= new ModelAndView("owners/ownerDetails");
    mav.addObject(this.ownerService.findById(ownerId));
    return mav;
  }
}
