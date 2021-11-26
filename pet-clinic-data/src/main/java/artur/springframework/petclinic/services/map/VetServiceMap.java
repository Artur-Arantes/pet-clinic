package artur.springframework.petclinic.services.map;

import artur.springframework.petclinic.domain.Speciality;
import artur.springframework.petclinic.domain.Vet;
import artur.springframework.petclinic.services.SpecialitiesService;
import artur.springframework.petclinic.services.VetServices;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Profile({"default", "map"})
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetServices {

  private final SpecialitiesService specialitiesService;

  @Override
  public List<Vet> findAll() {
    return super.findAll();
  }

  @Override
  public void deleteById(Long id) {
    super.deleteById(id);

  }

  @Override
  public void delete(Vet object) {
    super.delete(object);
  }

  @Override
  public Vet save(Vet object) {
    if (object.getSpecialities().size() > 0) {
      object.getSpecialities().forEach(speciality -> {
        if (speciality.getId() == null) {
          Speciality savedSpeciality = specialitiesService.save(speciality);
          speciality.setId(savedSpeciality.getId());
        }
      });
    }
    return super.save(object);
  }

  @Override
  public Vet findById(Long id) {
    return super.findById(id);
  }
}
