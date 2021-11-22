package artur.springframework.petclinic.services.springdatajpa;

import artur.springframework.petclinic.domain.Owner;
import artur.springframework.petclinic.repositories.OwnerRepository;
import artur.springframework.petclinic.repositories.PetRepository;
import artur.springframework.petclinic.repositories.PetTypeRepository;
import artur.springframework.petclinic.services.OwnerService;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Profile("springdatajpa")
public class OwnerSdJpaService implements OwnerService {

  private final OwnerRepository ownerRepository;
  private final PetRepository petRepository;
  private final PetTypeRepository petTypeRepository;

  @Override
  public List<Owner> findAll() {
    List<Owner> owners = new ArrayList<>();
    ownerRepository.findAll().forEach(ow -> owners.add(ow));
    return owners;
  }

  @Override
  public Owner findById(Long aLong) {
    java.util.Optional<Owner> optionalOwner = ownerRepository.findById(aLong);
    return optionalOwner.orElse(null);
  }

  @Override
  public Owner save(Owner object) {
    return ownerRepository.save(object);
  }

  @Override
  public void delete(Owner object) {
    ownerRepository.delete(object);
  }

  @Override
  public void deleteById(Long aLong) {
    ownerRepository.deleteById(aLong);
  }

  @Override
  public Owner findByLastName(String lastName) {
    return ownerRepository.findByLastName(lastName);
  }
}
