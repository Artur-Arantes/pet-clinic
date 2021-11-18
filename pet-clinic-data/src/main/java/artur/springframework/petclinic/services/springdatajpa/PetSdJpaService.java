package artur.springframework.petclinic.services.springdatajpa;

import artur.springframework.petclinic.domain.Pet;
import artur.springframework.petclinic.repositories.PetRepository;
import artur.springframework.petclinic.services.PetServices;
import java.util.HashSet;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Profile("sprindatajpa")
public class PetSdJpaService implements PetServices {

  private final PetRepository petRepository;

  @Override
  public Set<Pet> findAll() {
    Set<Pet> pets = new HashSet<>();
    petRepository.findAll().forEach(pets::add);
    return pets;
  }

  @Override
  public Pet findById(Long aLong) {
    return petRepository.findById(aLong).orElse(null);
  }

  @Override
  public Pet save(Pet object) {
    return petRepository.save(object);
  }

  @Override
  public void delete(Pet object) {
    petRepository.delete(object);
  }

  @Override
  public void deleteById(Long aLong) {
    petRepository.deleteById(aLong);
  }
}
