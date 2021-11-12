package artur.springframework.petclinic.services.map;

import artur.springframework.petclinic.domain.Vet;
import artur.springframework.petclinic.services.VetServices;
import java.util.Set;
import org.springframework.stereotype.Service;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetServices {
  @Override
  public Set<Vet> findAll() {
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
    return super.save(object.getId(), object);
  }

  @Override
  public Vet findByLastName(String lastname) {
    return null;
  }

  @Override
  public Vet findById(Long id) {
    return super.findById(id);
  }
}
