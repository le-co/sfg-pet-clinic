package guru.springframework.sfgpetclinic.service.map;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class OwnerServiceMapImpTest {

    private OwnerServiceMapImp ownerServiceMapImp;

    @BeforeEach
    public void init() {
        this.ownerServiceMapImp = new OwnerServiceMapImp(new PetServiceMapImp());
    }

    @Test
    void save() {
        Owner owner = new Owner();
        Owner saved = this.ownerServiceMapImp.save(owner);

        Owner ownerFound = this.ownerServiceMapImp.findById(owner.getId());

        Assert.assertNotNull(ownerFound);
        Assert.assertEquals(saved.getId(), ownerFound.getId());
    }

    @Test
    void removeById() {
        Owner owner = new Owner();
        Owner saved = this.ownerServiceMapImp.save(owner);

        Assert.assertNotNull(saved);

        this.ownerServiceMapImp.removeById(saved.getId());

        List<Owner> owners = this.ownerServiceMapImp.findAll();

        Assert.assertEquals(0, owners.size());
    }

    @Test
    void findAll() {
        this.ownerServiceMapImp.save(new Owner());

        List<Owner> owners = this.ownerServiceMapImp.findAll();

        Assert.assertEquals(1, owners.size());
    }

    @Test
    void update() {
        Owner owner = new Owner();
        owner.setFirstName("test");
        Owner saved = this.ownerServiceMapImp.save(owner);

        saved.setFirstName("leco");

        this.ownerServiceMapImp.update(saved.getId(), saved);
        Owner ownerFound = this.ownerServiceMapImp.findById(saved.getId());
        Assert.assertEquals("leco", ownerFound.getFirstName());
    }
}