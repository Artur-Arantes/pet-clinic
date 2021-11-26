package artur.springframework.petclinic.controllers;

import artur.springframework.petclinic.domain.Owner;
import artur.springframework.petclinic.domain.PetType;
import artur.springframework.petclinic.services.OwnerService;
import artur.springframework.petclinic.services.PetServices;
import artur.springframework.petclinic.services.PetTypeService;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(MockitoExtension.class)
public class PetControllerTest {
  @Mock
  PetServices petServices;
  @Mock
  OwnerService ownerService;
  @Mock
  PetTypeService petTypeService;
  @InjectMocks
  PetController petController;

  MockMvc mockMvc;
  Owner owner;
  List<PetType> petTypes = new ArrayList<>();

  @BeforeEach
  void setUp() {
    final var owner = Owner.builder().id(1L).build();
    petTypes.add(PetType.builder().id(1L).name("Dog").build());
    petTypes.add(PetType.builder().id(2L).build());
    mockMvc = MockMvcBuilders
        .standaloneSetup(petController)
        .build();

  }

//  @Test
//  void initCreationForm() throws Exception {
//    when(ownerService.findById(anyLong())).thenReturn(owner);
//    when(petTypeService.findAll()).thenReturn(petTypes);
//
//    mockMvc.perform(MockMvcRequestBuilders.get("/owners/1/pet/new"))
//        .andExpect(status().isOk())
//        .andExpect(model().attributeExists("owner"))
//        .andExpect(model().attributeExists("pet"))
//        .andExpect(view().name("pets/createOrUpdatePetForm"));
//  }

}
