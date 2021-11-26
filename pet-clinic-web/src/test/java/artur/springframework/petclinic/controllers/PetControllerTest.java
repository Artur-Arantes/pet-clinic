package artur.springframework.petclinic.controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import artur.springframework.petclinic.domain.Owner;
import artur.springframework.petclinic.domain.Pet;
import artur.springframework.petclinic.domain.PetType;
import artur.springframework.petclinic.services.OwnerService;
import artur.springframework.petclinic.services.PetServices;
import artur.springframework.petclinic.services.PetTypeService;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
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
    owner = Owner.builder().id(1L).build();
    petTypes.add(PetType.builder().id(1L).name("Dog").build());
    petTypes.add(PetType.builder().id(2L).build());
    mockMvc = MockMvcBuilders
        .standaloneSetup(petController)
        .build();

  }

  @Test
  void initCreationForm() throws Exception {
    when(ownerService.findById(anyLong())).thenReturn(owner);
    when(petTypeService.findAll()).thenReturn(petTypes);

    mockMvc.perform(MockMvcRequestBuilders.get("/owners/1/pets/new"))
        .andExpect(status().isOk())
        .andExpect(model().attributeExists("owner"))
        .andExpect(model().attributeExists("pet"))
        .andExpect(view().name("pets/createOrUpdatePetForm"));
  }

  @Test
  void processCreationForm() throws Exception {
    when(ownerService.findById(anyLong())).thenReturn(owner);
    when(petTypeService.findAll()).thenReturn(petTypes);

    mockMvc.perform(MockMvcRequestBuilders.post("/owners/1/pets/new"))
        .andExpect(status().is3xxRedirection())
        .andExpect(view().name("redirect:/owners/1"));
    verify(petServices).save(any());
  }

  @Test
  void initUpdateForm() throws Exception {
    when(ownerService.findById(anyLong())).thenReturn(owner);
    when(petTypeService.findAll()).thenReturn(petTypes);
    when(petServices.findById(anyLong())).thenReturn(Pet.builder().id(2L).build());

    mockMvc.perform(MockMvcRequestBuilders.get("/owners/1/pets/2/edit"))
        .andExpect(status().isOk())
        .andExpect(model().attributeExists("owner"))
        .andExpect(model().attributeExists("pet"))
        .andExpect(view().name("pets/createOrUpdatePetForm"));
  }

  @Test
  void processUpdateForm() throws Exception {
    when(ownerService.findById(anyLong())).thenReturn(owner);
    when(petTypeService.findAll()).thenReturn(petTypes);

    mockMvc.perform(MockMvcRequestBuilders.post("/owners/1/pets/2/edit"))
        .andExpect(status().is3xxRedirection())
        .andExpect(view().name("redirect:/owners/1"));
    verify(petServices).save(any());
  }


}
