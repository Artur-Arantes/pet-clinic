package artur.springframework.petclinic.services.map;

import artur.springframework.petclinic.domain.BaseEntity;
import artur.springframework.petclinic.domain.Owner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {
  protected Map<Long, T> map = new HashMap<>();

  List<T> findAll() {
    return new ArrayList<>();
  }

  T findById(ID id) {
    return map.get(id);
  }

  T save(T object) {
    if (object != null) {
      if (object.getId() == null) {
        object.setId(getNextId());
      }
      map.put(object.getId(), object);
    } else {
      throw new RuntimeException("Object cannot be null");
    }
    return object;
  }

  void deleteById(ID id) {
    map.remove(id);
  }

  void delete(T object) {
    map.entrySet().removeIf(entry -> entry.getValue().equals(object));
  }

  private Long getNextId() {
    Long nextId = null;
    try {
      nextId = Collections.max(map.keySet()) + 1;
    } catch (NoSuchElementException e) {
      nextId = 1L;
    }
    return nextId;
  }
}
