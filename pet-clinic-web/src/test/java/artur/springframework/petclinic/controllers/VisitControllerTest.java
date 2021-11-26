package artur.springframework.petclinic.controllers;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import artur.springframework.petclinic.domain.Owner;
import artur.springframework.petclinic.domain.Pet;
import artur.springframework.petclinic.domain.PetType;
import artur.springframework.petclinic.services.PetServices;
import artur.springframework.petclinic.services.VisitServices;
import java.net.URI;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.util.UriTemplate;

@ExtendWith(MockitoExtension.class)
public class VisitControllerTest {
  private static final String PETS_CREATE_OR_UPDATE_VISIT_FORM = "pets/createOrUpdateVisitForm";
  private static final String REDIRECT_OWNERS_1 = "redirect:/owners/{ownerId}";
  private static final String YET_ANOTHER_VISIT_DESCRIPTION = "yet another visit";
  @Mock
  PetServices petServices;

  @Mock
  VisitServices visitServices;

  @InjectMocks
  VisitController visitController;

  private MockMvc mockMvc;

  private final UriTemplate visitsUriTemplate =
      new UriTemplate("/owners/{ownerId}/pets/{petId}/visits/new");

  private final Map<String, String> uriVariables = new HashMap<>();
  private URI visitUri;

  @BeforeEach
  void setUp() {
    Long petId = 1L;
    Long ownerId = 1L;
    when(petServices.findById(anyLong())).thenReturn(Pet.builder()
        .id(petId)
        .birthDate(LocalDate.of(2021, 10, 10))
        .name("toquio")
        .visits(new ArrayList<>())
        .petType(PetType.builder().name("dog").build())
        .owner(Owner.builder().id(ownerId).firstName("mi").lastName("campagnollo").build())
        .build());
    uriVariables.clear();
    uriVariables.put("ownerId", ownerId.toString());
    uriVariables.put("petId", petId.toString());
    visitUri = visitsUriTemplate.expand(uriVariables);

    mockMvc = MockMvcBuilders
        .standaloneSetup(visitController)
        .build();
  }

  @Test
  void initNewVisitForm() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get(visitUri))
        .andExpect(status().isOk())
        .andExpect(view().name(PETS_CREATE_OR_UPDATE_VISIT_FORM));
  }

  @Test
  void processNewVisitForm() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.post(visitUri)
            .contentType(MediaType.APPLICATION_FORM_URLENCODED)
            .param("date", "2021-10-10")
            .param("description", YET_ANOTHER_VISIT_DESCRIPTION))
        .andExpect(status().is3xxRedirection())
        .andExpect(view().name(REDIRECT_OWNERS_1))
        .andExpect(model().attributeExists("visit"));
  }
}
