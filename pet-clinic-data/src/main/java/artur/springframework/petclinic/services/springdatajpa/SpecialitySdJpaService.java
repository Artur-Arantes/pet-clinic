package artur.springframework.petclinic.services.springdatajpa;

import artur.springframework.petclinic.domain.Owner;
import artur.springframework.petclinic.domain.Speciality;
import artur.springframework.petclinic.repositories.SpecialityRepository;
import artur.springframework.petclinic.services.SpecialitiesService;
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
public class SpecialitySdJpaService implements SpecialitiesService {

  private final SpecialityRepository specialityRepository;

  @Override
  public List<Speciality> findAll() {
    List<Speciality> specialities = new ArrayList<>();
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
