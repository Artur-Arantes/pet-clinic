package artur.springframework.petclinic.services.springdatajpa;

import artur.springframework.petclinic.domain.Visit;
import artur.springframework.petclinic.repositories.VisitRepository;
import artur.springframework.petclinic.services.VisitServices;
import java.util.HashSet;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("springdatajpa")
@RequiredArgsConstructor
public class VisitSdJpaService implements VisitServices {

  private final VisitRepository visitRepository;

  @Override
  public Set<Visit> findAll() {
    Set<Visit> visits = new HashSet<>();
    visitRepository.findAll().forEach(visits::add);
    return visits;
  }

  @Override
  public Visit findById(Long aLong) {
    return visitRepository.findById(aLong).orElse(null);
  }

  @Override
  public Visit save(Visit object) {
    return visitRepository.save(object);
  }

  @Override
  public void delete(Visit object) {
    visitRepository.delete(object);
  }

  @Override
  public void deleteById(Long aLong) {
    visitRepository.deleteById(aLong);
  }
}
