package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.*;
import guru.springframework.sfgpetclinic.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private OwnerService ownerService;
    private PetService petServicel;
    private VetService vetService;
    private PetTypeService petTypeService;
    private SpecialityService specialityService;
    private VisitService visitService;

    @Autowired
    public DataLoader(OwnerService ownerService,
                      PetService petServicel,
                      VetService vetService,
                      PetTypeService petTypeService,
                      SpecialityService specialityService,
                      VisitService visitService) {
        this.ownerService = ownerService;
        this.petServicel = petServicel;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        int size = petTypeService.findAll().size();

        if (size == 0) {
            loadData();
        }
    }

    private void loadData() {
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
        Owner owner1 = this.ownerService.save(owner);

        Pet pet = new Pet();
        pet.setName("Panda");
        pet.setPetType(dogSaved);
        pet.setBirthDate(LocalDate.now());
        pet.setOwner(owner1);
        Pet petSaved1 = this.petServicel.save(pet);

        owner1.addPets(pet);
        this.ownerService.update(owner1.getId(), owner1);

        owner = new Owner();
        owner.setFirstName("Juliana");
        owner.setLastName("Barbosa");
        Owner owner2 = this.ownerService.save(owner);

        pet = new Pet();
        pet.setBirthDate(LocalDate.now());
        pet.setName("Jack Black");
        pet.setPetType(catSaved);
        pet.setOwner(owner2);
        Pet petSaved2 = this.petServicel.save(pet);

        owner2.addPets(pet);
        this.ownerService.update(owner2.getId(), owner2);

        owner = new Owner();
        owner.setFirstName("Gabriel");
        owner.setLastName("Ramalho");
        Owner owner3 = this.ownerService.save(owner);

        pet = new Pet();
        pet.setName("Godoy");
        pet.setPetType(birdSaved);
        pet.setBirthDate(LocalDate.now());
        pet.setOwner(owner3);
        Pet petSaved3 = this.petServicel.save(pet);

        owner3.addPets(pet);
        this.ownerService.update(owner3.getId(), owner3);

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
        this.vetService.save(vet);

        vet = new Vet();
        vet.setFirstName("Jose");
        vet.setLastName("Costa");
        vet.addSpeciality(speciality3);
        this.vetService.save(vet);

        vet = new Vet();
        vet.setFirstName("Rodrigo");
        vet.setLastName("Costa");
        vet.addSpeciality(speciality2);
        this.vetService.save(vet);

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
