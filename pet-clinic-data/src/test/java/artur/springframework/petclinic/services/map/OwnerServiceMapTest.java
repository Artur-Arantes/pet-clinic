package artur.springframework.petclinic.services.map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import artur.springframework.petclinic.domain.Owner;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OwnerServiceMapTest {

  private OwnerServiceMap ownerServiceMap;
  private final Long ownerId = 1L;
  private final String lastName = "Smith";


  @BeforeEach
  public void setUp() {
    ownerServiceMap = new OwnerServiceMap(new PetTypeMapService(), new PetServiceMap());

    ownerServiceMap.save(Owner.builder().id(ownerId).lastName(lastName).build());
  }

  @Test
  void findAll() {
    Set<Owner> ownerSet = ownerServiceMap.findAll();
    assertEquals(1, ownerSet.size());
  }

  @Test
  void deleteById() {
    ownerServiceMap.deleteById(ownerId);

    assertEquals(0, ownerServiceMap.findAll().size());

  }

  @Test
  void delete() {
    ownerServiceMap.delete(ownerServiceMap.findById(ownerId));
    assertEquals(0, ownerServiceMap.findAll().size());
  }

  @Test
  void saveExistingId() {
    Long id = 2L;
    Owner owner2 = Owner.builder().id(id).build();
    Owner savedOwner = ownerServiceMap.save(owner2);
    assertEquals(id, savedOwner.getId());
  }

  @Test
  void saveNoId() {
    Owner savedOwner = ownerServiceMap.save(Owner.builder().build());

    assertNotNull(savedOwner);
    assertNotNull(savedOwner.getId());

  }


  @Test
  void findById() {
    Owner owner = ownerServiceMap.findById(ownerId);
    assertEquals(ownerId, owner.getId());
  }

  @Test
  void findByLastName() {
    Owner smith= ownerServiceMap.findByLastName(lastName);
    assertNotNull(smith);
    assertEquals(ownerId, smith.getId()
    );
  }

  @Test
  void findByLastNameNotFound() {
    Owner smith= ownerServiceMap.findByLastName("fool");
    assertNull(smith);
  }
}
