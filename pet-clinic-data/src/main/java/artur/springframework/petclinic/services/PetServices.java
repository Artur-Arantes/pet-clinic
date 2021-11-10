package artur.springframework.petclinic.services;

import artur.springframework.petclinic.domain.Pet;
import java.util.Set;

public interface PetServices {
  Pet findById(Long id);

  Pet save(Pet Owner);

  Set<Pet> findAll();
}
