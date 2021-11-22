package artur.springframework.petclinic.services.springdatajpa;

import artur.springframework.petclinic.domain.Owner;
import artur.springframework.petclinic.domain.Vet;
import artur.springframework.petclinic.repositories.VetRepository;
import artur.springframework.petclinic.services.VetServices;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("springdatajpa")
@RequiredArgsConstructor
public class VetSdJpaService implements VetServices {

  private final VetRepository vetRepository;

  @Override
  public List<Vet> findAll() {
    List<Vet> vets = new ArrayList<>();
    vetRepository.findAll().forEach(vets::add);
    return vets;
  }

  @Override
  public Vet findById(Long aLong) {
    return vetRepository.findById(aLong).orElse(null);
  }

  @Override
  public Vet save(Vet object) {
    return vetRepository.save(object);
  }

  @Override
  public void delete(Vet object) {
    vetRepository.delete(object);
  }

  @Override
  public void deleteById(Long aLong) {
    vetRepository.deleteById(aLong);
  }

}
