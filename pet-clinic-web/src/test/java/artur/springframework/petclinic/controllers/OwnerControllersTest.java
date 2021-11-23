package artur.springframework.petclinic.controllers;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import artur.springframework.petclinic.domain.Owner;
import artur.springframework.petclinic.services.OwnerService;
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
class OwnerControllersTest {
  @Mock
  OwnerService ownerService;
  @InjectMocks
  OwnerControllers ownerControllers;

  List<Owner> owners;

  MockMvc mockMvc;

  @BeforeEach
  void setUp() {
    owners = new ArrayList<>();
    owners.add(Owner.builder().id(1L).build());
    owners.add(Owner.builder().id(2L).build());

    mockMvc = MockMvcBuilders
        .standaloneSetup(ownerControllers)
        .build();
  }

  @Test
  void ownersList() throws Exception {
    when(ownerService.findAll()).thenReturn(owners);
    mockMvc.perform(MockMvcRequestBuilders.get("/owners"))
        .andExpect(status().is(200))
        .andExpect(view().name("owners/index"))
        .andExpect(model().attribute("owners", hasSize(2)));
  }

  @Test
  void listOwnersByIndex() throws Exception {
    when(ownerService.findAll()).thenReturn(owners);
    mockMvc.perform(MockMvcRequestBuilders.get("/owners/index"))
        .andExpect(status().is(200))
        .andExpect(view().name("owners/index"))
        .andExpect(model().attribute("owners", hasSize(2)));
  }

  @Test
  void findOwners() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/owners/find"))
        .andExpect(status().isOk())
        .andExpect(view().name("notimplemented"));

  }
  @Test
  void displayOwner() throws  Exception{
    when(ownerService.findById(anyLong())).thenReturn(Owner.builder().id(1L).build());
    mockMvc.perform(MockMvcRequestBuilders.get("/owners/123"))
        .andExpect(status().isOk())
        .andExpect(view().name("owners/ownerDetails"))
        .andExpect(model().attribute("owner", hasProperty("id",is(1L))));
  }

}