package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.*;
import guru.springframework.sfgpetclinic.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private OwnerCrudService ownerCrudService;
    private PetCrudService petCrudServicel;
    private VetCrudService vetCrudService;
    private PetTypeService petTypeService;
    private SpecialityService specialityService;
    private VisitService visitService;

    @Autowired
    public DataLoader(OwnerCrudService ownerCrudService,
                      PetCrudService petCrudServicel,
                      VetCrudService vetCrudService,
                      PetTypeService petTypeService,
                      SpecialityService specialityService,
                      VisitService visitService) {
        this.ownerCrudService = ownerCrudService;
        this.petCrudServicel = petCrudServicel;
        this.vetCrudService = vetCrudService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");

        PetType cat = new PetType();
        cat.setName("Cat");

        PetType bird = new PetType();
        bird.setName("Bird");

        PetType dogSaved = this.petTypeService.save(dog);
        PetType catSaved = this.petTypeService.save(cat);
        PetType birdSaved = this.petTypeService.save(bird);

        Owner owner = new Owner();
        owner.setFirstName("Leandro");
        owner.setLastName("Costa");
        Owner owner1 = this.ownerCrudService.save(owner);

        Pet pet = new Pet();
        pet.setName("Panda");
        pet.setPetType(dogSaved);
        pet.setBirthDate(LocalDate.now());
        pet.setOwner(owner1);
        Pet petSaved1 = this.petCrudServicel.save(pet);

        owner1.addPets(pet);
        this.ownerCrudService.update(owner1.getId(), owner1);

        owner = new Owner();
        owner.setFirstName("Juliana");
        owner.setLastName("Barbosa");
        Owner owner2 = this.ownerCrudService.save(owner);

        pet = new Pet();
        pet.setBirthDate(LocalDate.now());
        pet.setName("Jack Black");
        pet.setPetType(catSaved);
        pet.setOwner(owner2);
        Pet petSaved2 = this.petCrudServicel.save(pet);

        owner2.addPets(pet);
        this.ownerCrudService.update(owner2.getId(), owner2);

        owner = new Owner();
        owner.setFirstName("Gabriel");
        owner.setLastName("Ramalho");
        Owner owner3 = this.ownerCrudService.save(owner);

        pet = new Pet();
        pet.setName("Godoy");
        pet.setPetType(birdSaved);
        pet.setBirthDate(LocalDate.now());
        pet.setOwner(owner3);
        Pet petSaved3 = this.petCrudServicel.save(pet);

        owner3.addPets(pet);
        this.ownerCrudService.update(owner3.getId(), owner3);

        Speciality speciality = new Speciality();
        speciality.setDescription("Surgery");
        Speciality speciality1 = specialityService.save(speciality);

        speciality = new Speciality();
        speciality.setDescription("Diagnostic Specialist");
        Speciality speciality2 = specialityService.save(speciality);

        speciality = new Speciality();
        speciality.setDescription("Anesthetist");
        Speciality speciality3 = specialityService.save(speciality);

        Vet vet = new Vet();
        vet.setFirstName("Margarida");
        vet.setLastName("Pereira");
        vet.addSpeciality(speciality1);
        vet.addSpeciality(speciality2);
        this.vetCrudService.save(vet);

        vet = new Vet();
        vet.setFirstName("Jose");
        vet.setLastName("Costa");
        vet.addSpeciality(speciality3);
        this.vetCrudService.save(vet);

        vet = new Vet();
        vet.setFirstName("Rodrigo");
        vet.setLastName("Costa");
        vet.addSpeciality(speciality2);
        this.vetCrudService.save(vet);

        Visit visit = new Visit();
        visit.setDate(LocalDate.now());
        visit.setDescription("kajfkalsdf asdfljasd");
        visit.setPet(petSaved2);

        visitService.save(visit);

        visit = new Visit();
        visit.setDate(LocalDate.now());
        visit.setDescription("kajfkalsdf asdfljasd");
        visit.setPet(petSaved3);

        visitService.save(visit);

        visit = new Visit();
        visit.setDate(LocalDate.now());
        visit.setDescription("kajfkalsdf asdfljasd");
        visit.setPet(petSaved1);

        visitService.save(visit);

        System.out.println("========================================================");
        System.out.println("========================================================");
        System.out.println("========================================================");
        System.out.println("Loads values");
        System.out.println("========================================================");
        System.out.println("========================================================");
        System.out.println("========================================================");
    }
}
