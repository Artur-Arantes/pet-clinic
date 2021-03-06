package artur.springframework.petclinic.services.springdatajpa;

import artur.springframework.petclinic.domain.PetType;
import artur.springframework.petclinic.repositories.PetTypeRepository;
import artur.springframework.petclinic.services.PetTypeService;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("springdatajpa")
@RequiredArgsConstructor
public class PetTypeSdJpaService implements PetTypeService {

  private final PetTypeRepository petTypeRepository;

  @Override
  public List<PetType> findAll() {
    List<PetType> petTypes = new ArrayList<>();
    petTypeRepository.findAll().forEach(petTypes::add);
    return petTypes;
  }

  @Override
  public PetType findById(Long aLong) {
    return petTypeRepository.findById(aLong).orElse(null);
  }

  @Override
  public PetType save(PetType object) {
    return petTypeRepository.save(object);
  }

  @Override
  public void delete(PetType object) {
    petTypeRepository.delete(object);
  }

  @Override
  public void deleteById(Long aLong) {
    petTypeRepository.deleteById(aLong);
  }

}
