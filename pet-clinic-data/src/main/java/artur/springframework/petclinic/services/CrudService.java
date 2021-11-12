package artur.springframework.petclinic.services;

import artur.springframework.petclinic.domain.Owner;
import java.util.Set;

public interface CrudService<T, ID> {
  Set<T> findAll();

  T findById(ID id);

  T save(T object);

  void delete(T object);

  void deleteById(ID id);

  T findByLastName(String lastname);
}
