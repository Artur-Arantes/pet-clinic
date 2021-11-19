package artur.springframework.petclinic.bootstrap;

import artur.springframework.petclinic.domain.Owner;
import artur.springframework.petclinic.domain.Pet;
import artur.springframework.petclinic.domain.PetType;
import artur.springframework.petclinic.domain.Speciality;
import artur.springframework.petclinic.domain.Vet;
import artur.springframework.petclinic.domain.Visit;
import artur.springframework.petclinic.services.OwnerService;
import artur.springframework.petclinic.services.PetTypeService;
import artur.springframework.petclinic.services.SpecialitiesService;
import artur.springframework.petclinic.services.VetServices;
import artur.springframework.petclinic.services.VisitServices;
import java.time.LocalDate;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
  private final OwnerService ownerService;
  private final VetServices vetServices;
  private final PetTypeService petTypeService;
  private final SpecialitiesService specialitiesService;
  private final VisitServices visitServices;

  @Override
  public void run(String... args) throws Exception {
    int count= petTypeService.findAll().size();
   if(count==0){
     loadData();
   }
  }

  private void loadData() {
    PetType dog = new PetType();
    dog.setName("toto");
    PetType dogSaved = petTypeService.save(dog);

    PetType cat = new PetType();
    cat.setName("bolota");
    PetType catSaved = petTypeService.save(cat);

    Speciality radiology = new Speciality();
    radiology.setDescription("Radiology");
    Speciality savedRadiology=specialitiesService.save(radiology);

    Speciality surgery = new Speciality();
    surgery.setDescription("Surgery");
    Speciality savedSurgery=specialitiesService.save(surgery);

    Speciality dentistry = new Speciality();
    dentistry.setDescription("Dentistry");
    Speciality savedDentistry=specialitiesService.save(dentistry);

    Owner owner1 = new Owner();
    owner1.setId(1L);
    owner1.setFirstName("mi");
    owner1.setAddress("tibirica");
    owner1.setCity("ribeirao");
    owner1.setTelephone("15151");
    owner1.setLastName("campagnollo");

    Pet misPet = new Pet();
    misPet.setPetType(dogSaved);
    misPet.setOwner(owner1);
    misPet.setBirthDate(LocalDate.now());
    misPet.setName("toquio");
    owner1.getPets().add(misPet);
    ownerService.save(owner1);

    Owner owner2 = new Owner();
    owner2.setId(2L);
    owner2.setAddress("rua amador");
    owner2.setCity("barueri");
    owner2.setTelephone("5543");
    owner2.setFirstName("toquio");
    owner2.setLastName("japan");

    Pet toquiosPet = new Pet();
    toquiosPet.setId(1L);
    toquiosPet.setPetType(catSaved);
    toquiosPet.setOwner(owner2);
    toquiosPet.setBirthDate(LocalDate.now());
    toquiosPet.setName("toquios son");
    owner2.getPets().add(toquiosPet);

    ownerService.save(owner2);

    Visit catVisit= new Visit();
    catVisit.setId(1L);
    catVisit.setPet(toquiosPet);
    catVisit.setDate(LocalDate.now());
    catVisit.setDescription("sneezy kitty");

    visitServices.save(catVisit);

    System.out.println("Loaded Owners...");

    Vet vet1 = new Vet();
    vet1.setFirstName("joaquim");
    vet1.setId(1L);
    vet1.setLastName("Pereira");
    vet1.getSpeciality().add(savedRadiology);

    vetServices.save(vet1);

    Vet vet2 = new Vet();
    vet2.setId(2L);
    vet2.setLastName("Bueno");
    vet2.setFirstName("Galvao");
    vet2.getSpeciality().add(surgery);

    vetServices.save(vet2);

    System.out.println("Loaded vets");
  }
}
