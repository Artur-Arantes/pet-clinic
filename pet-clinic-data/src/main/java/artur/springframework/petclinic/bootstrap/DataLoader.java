package artur.springframework.petclinic.bootstrap;

import artur.springframework.petclinic.domain.Owner;
import artur.springframework.petclinic.domain.PetType;
import artur.springframework.petclinic.domain.Vet;
import artur.springframework.petclinic.services.OwnerService;
import artur.springframework.petclinic.services.PetTypeService;
import artur.springframework.petclinic.services.VetServices;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
  private final OwnerService ownerService;
  private final VetServices vetServices;
  private final PetTypeService petTypeService;

  @Override
  public void run(String... args) throws Exception {
    PetType dog =new PetType();
    dog.setName("toto");
    dog.setId(1L);
    PetType dogSaved= petTypeService.save(dog);

    PetType cat = new PetType();
    cat.setName("bolota");
    cat.setId(2L);
    PetType catSaved= petTypeService.save(cat);

    Owner owner1 = new Owner();
    owner1.setId(1L);
    owner1.setFirstName("mi");
    owner1.setLastName("campagnollo");

    ownerService.save(owner1);

    Owner owner2 = new Owner();
    owner2.setId(2L);
    owner2.setFirstName("toquio");
    owner2.setLastName("japan");

    ownerService.save(owner2);

    System.out.println("Loaded Owners...");

    Vet vet1 = new Vet();
    vet1.setFirstName("joaquim");
    vet1.setId(1L);
    vet1.setLastName("Pereira");

    vetServices.save(vet1);

    Vet vet2 = new Vet();
    vet2.setId(2L);
    vet2.setLastName("Bueno");
    vet2.setFirstName("Galvao");

    vetServices.save(vet2);

    System.out.println("Loaded vets");
  }
}
