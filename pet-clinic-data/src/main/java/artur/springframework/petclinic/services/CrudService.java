package artur.springframework.petclinic.services;

import artur.springframework.petclinic.domain.Owner;
import java.util.List;

public interface CrudService<T, ID> {
  List<T> findAll();

  T findById(ID id);

  T save(T object);

  void delete(T object);

  void deleteById(ID id);


}
