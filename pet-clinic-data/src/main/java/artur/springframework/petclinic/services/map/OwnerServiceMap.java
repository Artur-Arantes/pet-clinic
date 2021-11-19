package artur.springframework.petclinic.services.map;

import artur.springframework.petclinic.domain.Owner;
import artur.springframework.petclinic.domain.Pet;
import artur.springframework.petclinic.services.OwnerService;
import artur.springframework.petclinic.services.PetServices;
import artur.springframework.petclinic.services.PetTypeService;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Profile({"default", "map"})
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {
  private final PetTypeService petTypeService;
  private final PetServices petServices;

  @Override
  public Set<Owner> findAll() {
    return super.findAll();
  }

  @Override
  public void deleteById(Long id) {
    super.deleteById(id);
  }

  @Override
  public void delete(Owner object) {
    super.delete(object);
  }

  @Override
  public Owner save(Owner object) {
    if (object != null) {
      if (object.getPets() == null) {
        object.getPets().forEach(pet -> {
          if (pet.getPetType() != null) {
            if (pet.getPetType() == null) {
              pet.setPetType(petTypeService.save(pet.getPetType()));
            }
          } else {
            throw new RuntimeException("pet type is required");
          }
          if (pet.getId() == null) {
            Pet savedPet = petServices.save(pet);
            pet.setId(savedPet.getId());
          }
        });
      }
      return super.save(object);
    } else {
      return null;
    }
  }

  @Override
  public Owner findById(Long id) {
    return super.findById(id);
  }


  @Override
  public Owner findByLastName(String lastname) {
    return null;
  }
}