package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.service.OwnerCrudService;
import guru.springframework.sfgpetclinic.service.PetCrudService;
import guru.springframework.sfgpetclinic.service.VetCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private OwnerCrudService ownerCrudService;
    private PetCrudService petCrudServicel;
    private VetCrudService vetCrudService;

    @Autowired
    public DataLoader(OwnerCrudService ownerCrudService, PetCrudService petCrudServicel, VetCrudService vetCrudService) {
        this.ownerCrudService = ownerCrudService;
        this.petCrudServicel = petCrudServicel;
        this.vetCrudService = vetCrudService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner = new Owner();
        owner.setId(1);
        owner.setFirstName("Test");
        owner.setLastName("1");
        this.ownerCrudService.save(owner);

        Pet pet = new Pet();
        pet.setId(1);
        pet.setBirthDate(LocalDate.now());
        pet.setOwner(owner);
        this.petCrudServicel.save(pet);

        owner = new Owner();
        owner.setId(2);
        owner.setFirstName("Test");
        owner.setLastName("2");
        this.ownerCrudService.save(owner);

        pet = new Pet();
        pet.setId(2);
        pet.setBirthDate(LocalDate.now());
        pet.setOwner(owner);
        this.petCrudServicel.save(pet);

        owner = new Owner();
        owner.setId(3);
        owner.setFirstName("Test");
        owner.setLastName("3");
        this.ownerCrudService.save(owner);

        pet = new Pet();
        pet.setId(3);
        pet.setBirthDate(LocalDate.now());
        pet.setOwner(owner);
        this.petCrudServicel.save(pet);

        Vet vet = new Vet();
        vet.setId(1);
        vet.setFirstName("Test");
        vet.setLastName("1");
        this.ownerCrudService.save(owner);

        vet = new Vet();
        vet.setId(2);
        vet.setFirstName("Test");
        vet.setLastName("1");
        this.ownerCrudService.save(owner);

        vet = new Vet();
        vet.setId(2);
        vet.setFirstName("Test");
        vet.setLastName("1");
        this.ownerCrudService.save(owner);

        System.out.println("========================================================");
        System.out.println("========================================================");
        System.out.println("========================================================");
        System.out.println("Loads values");
        System.out.println("========================================================");
        System.out.println("========================================================");
        System.out.println("========================================================");
    }
}
