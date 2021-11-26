package artur.springframework.petclinic.controllers;

import artur.springframework.petclinic.domain.Pet;
import artur.springframework.petclinic.domain.Visit;
import artur.springframework.petclinic.services.PetServices;
import artur.springframework.petclinic.services.VisitServices;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class VisitController {

  private final VisitServices visitServices;

  private final PetServices petServices;

  public VisitController(VisitServices visitServices, PetServices petServices) {
    this.visitServices = visitServices;
    this.petServices = petServices;
  }

  @InitBinder
  public void setAllowedFields(WebDataBinder dataBinder) {
    dataBinder.setDisallowedFields("id");
  }


  @ModelAttribute("visit")
  public Visit loadPetWithVisit(@PathVariable("petId") Long petId, Map<String, Object> model) {
    Pet pet = this.petServices.findById(petId);
    model.put("pet", pet);
    Visit visit = new Visit();
    pet.getVisits().add(visit);
    return visit;
  }

  @GetMapping("/owners/*/pets/{petId}/visits/new")
  public String initNewVisitForm(@PathVariable("petId") Long petId, Map<String, Object> model) {
    return "pets/createOrUpdateVisitForm";
  }

  @PostMapping("/owners/{ownerId}/pets/{petId}/visits/new")
  public String processNewVisitForm(@Valid Visit visit, BindingResult result) {
    if (result.hasErrors()) {
      return "pets/createOrUpdateVisitForm";
    } else {
      this.visitServices.save(visit);
      return "redirect:/owners/{ownerId}";
    }
  }

}
