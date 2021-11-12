package artur.springframework.petclinic.bootstrap;

import artur.springframework.petclinic.domain.Owner;
import artur.springframework.petclinic.domain.Vet;
import artur.springframework.petclinic.services.OwnerService;
import artur.springframework.petclinic.services.VetServices;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;

@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
  private final OwnerService ownerService;
  private final VetServices vetServices;

  @Override
  public void run(String... args) throws Exception {
      Owner owner1=new Owner();
      owner1.setId(1L);
      owner1.setFirstName("mi");
      owner1.setLastName("campagnollo");

      ownerService.save(owner1);

      Owner owner2= new Owner();
      owner2.setId(2L);
      owner2.setFirstName("toquio");
      owner2.setLastName("japan");

      ownerService.save(owner2);

    System.out.println("Loaded Owners...");

    Vet vet1= new Vet();
    vet1.setFirstName("joaquim");
    vet1.setId(1L);
    vet1.setLastName("Pereira");

    vetServices.save(vet1);

    Vet vet2= new Vet();
    vet2.setId(2L);
    vet2.setLastName("Bueno");
    vet2.setFirstName("Galvao");

    vetServices.save(vet2);

    System.out.println("Loaded vets");
  }
}
