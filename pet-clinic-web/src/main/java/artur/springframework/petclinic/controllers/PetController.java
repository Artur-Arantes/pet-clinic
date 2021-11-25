package artur.springframework.petclinic.controllers;

import artur.springframework.petclinic.domain.Owner;
import artur.springframework.petclinic.domain.PetType;
import artur.springframework.petclinic.services.OwnerService;
import artur.springframework.petclinic.services.PetServices;
import artur.springframework.petclinic.services.PetTypeService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/owners/{ownerId}")
@RequiredArgsConstructor
public class PetController {

  private static final String VIEWS_PETS_CREATE_OR_UPDATE_FORM = "pets/createOrUpdatePetForm";
  private final PetServices petServices;
  private final OwnerService ownerService;
  private final PetTypeService petTypeService;

  @ModelAttribute("types")
  public List<PetType> populatePetTypes() {
    return petTypeService.findAll();
  }

  @ModelAttribute("owner")
  public Owner findOwner(@PathVariable("ownerId") Long ownerId) {
    return this.ownerService.findById(ownerId);
  }

  @InitBinder("owner")
  public void initOwnerBinder(WebDataBinder webDataBinder) {
    webDataBinder.setDisallowedFields("id");
  }
}
