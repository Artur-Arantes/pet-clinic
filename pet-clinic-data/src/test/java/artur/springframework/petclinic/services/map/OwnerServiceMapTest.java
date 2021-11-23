package artur.springframework.petclinic.services.map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import artur.springframework.petclinic.domain.Owner;
import artur.springframework.petclinic.domain.Pet;
import artur.springframework.petclinic.domain.PetType;
import artur.springframework.petclinic.services.PetServices;
import artur.springframework.petclinic.services.PetTypeService;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

class OwnerServiceMapTest {
  @Mock
  PetTypeService petTypeService;
  @Mock
  PetServices petServices;

  @InjectMocks
  OwnerServiceMap ownerServiceMap;

  private final Long ownerId = 1L;
  private final String lastName = "Smith";


  @BeforeEach
  public void setUp() {
    ownerServiceMap = new OwnerServiceMap(new PetTypeMapService(), new PetServiceMap());

    ownerServiceMap.save(Owner.builder().id(ownerId).lastName(lastName).build());
  }

//  @Test
//  void findAll() {
////    PetType petType= new PetType();
//////    Pet pet = new Pet();
//////    pet.setPetType(petType);
//////    List<Pet> petList = new ArrayList<>();
//////    petList.add(pet);
//////    Owner savedOwner = ownerServiceMap.save(Owner.builder().id(3L).pets(petList).build());
//////    ownerServiceMap.save(savedOwner);
//////    List<Owner> ownerSet = new ArrayList<>();
//////    ownerServiceMap.findAll().forEach(ownerSet::add);
//////
//////    assertEquals(1, ownerSet.size());
//////  }

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

//  @Test
//  void findByLastName() {
//    Owner smith = ownerServiceMap.findByLastName(lastName);
//    assertEquals(ownerId, smith.getId()
//    );
//  }

  @Test
  void findByLastNameNotFound() {
    Owner smith = ownerServiceMap.findByLastName("fool");
    assertNull(smith);
  }
}
