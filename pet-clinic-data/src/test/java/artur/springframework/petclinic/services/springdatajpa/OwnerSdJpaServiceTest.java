package artur.springframework.petclinic.services.springdatajpa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import artur.springframework.petclinic.domain.Owner;
import artur.springframework.petclinic.repositories.OwnerRepository;
import artur.springframework.petclinic.repositories.PetRepository;
import artur.springframework.petclinic.repositories.PetTypeRepository;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class OwnerSdJpaServiceTest {
  private final String lastName="smith";
  @Mock
  OwnerRepository ownerRepository;
  @Mock
  PetRepository petRepository;
  @Mock
  PetTypeRepository petTypeRepository;

  @InjectMocks
  OwnerSdJpaService service;

  Owner returnOwner;

  @BeforeEach
  void setUp(){
    returnOwner= Owner.builder().id(1L).lastName(lastName).build();
  }


  @Test
  void findAll() {
    List<Owner> returnOwnerSet= new ArrayList<>();
    returnOwnerSet.add(Owner.builder().id(2L).build());
    returnOwnerSet.add(Owner.builder().id(1L).build());
    returnOwnerSet.add(Owner.builder().id(3l).build());

    when(ownerRepository.findAll()).thenReturn(returnOwnerSet);

    List<Owner> owners=service.findAll();

    assertNotNull(owners);
    assertEquals(3, owners.size());
  }

  @Test
  void findById() {
    when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));
    Owner owner= service.findById(1L);
    assertNotNull(owner);
  }

  @Test
  void save() {
    Owner ownerToSave= Owner.builder().id(1L).build();
    when(ownerRepository.save(any())).thenReturn(returnOwner);
    Owner savedOwner=service.save(ownerToSave);
    assertNotNull(savedOwner);
  }

  @Test
  void delete() {
    service.delete(returnOwner);
    verify(ownerRepository).delete(any());
  }

  @Test
  void deleteById() {
    service.deleteById(1L);
    verify(ownerRepository).deleteById(anyLong());
  }

  @Test
  void findByLastName() {
    Owner returnOwner = Owner.builder().id(1L).lastName(lastName).build();

    when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);

    Owner smith = service.findByLastName(lastName);

    verify(ownerRepository).findByLastName(any());

    assertEquals(lastName, smith.getLastName());
  }
}