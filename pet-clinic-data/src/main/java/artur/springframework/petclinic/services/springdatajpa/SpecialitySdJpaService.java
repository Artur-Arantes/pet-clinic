package artur.springframework.petclinic.services.springdatajpa;

import artur.springframework.petclinic.domain.Speciality;
import artur.springframework.petclinic.repositories.SpecialityRepository;
import artur.springframework.petclinic.services.SpecialitiesService;
import java.util.HashSet;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("sprindatajpa")
@RequiredArgsConstructor
public class SpecialitySdJpaService implements SpecialitiesService {

  private final SpecialityRepository specialityRepository;

  @Override
  public Set<Speciality> findAll() {
    Set<Speciality> specialities = new HashSet<>();
    specialityRepository.findAll().forEach(specialities::add);
    return specialities;
  }

  @Override
  public Speciality findById(Long aLong) {
    return specialityRepository.findById(aLong).orElse(null);
  }

  @Override
  public Speciality save(Speciality object) {
    return specialityRepository.save(object);
  }

  @Override
  public void delete(Speciality object) {
    specialityRepository.delete(object);
  }

  @Override
  public void deleteById(Long aLong) {
    specialityRepository.deleteById(aLong);
  }
}
