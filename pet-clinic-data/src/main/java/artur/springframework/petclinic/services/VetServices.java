package artur.springframework.petclinic.services;

import artur.springframework.petclinic.domain.Vet;
import java.util.Set;

public interface VetServices {
  Vet findById(Long id);

  Vet save(Vet vet);

  Set<Vet> findAll();
}
