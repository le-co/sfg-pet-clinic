package guru.springframework.sfgpetclinic.service.jpa;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.repositories.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerServiceJpaImpTest {

    @Mock
    OwnerRepository ownerRepository;

    @InjectMocks
    private OwnerServiceJpaImp ownerServiceJpaImp;

    @Test
    void findById() {
        Owner owner = new Owner();
        owner.setFirstName("Smith");
        owner.setLastName("Aristonild");

        when(ownerRepository.findById(anyInt())).thenReturn(java.util.Optional.ofNullable(owner));

        Owner smith = ownerServiceJpaImp.findById(1);

        assertNotNull(smith);
        assertEquals("Smith", smith.getFirstName());
    }

    @Test
    void removeById() {
        ownerServiceJpaImp.removeById(1);
        verify(ownerRepository, times(1)).deleteById(1);
    }

    @Test
    void findAll() {
        Owner owner = new Owner();
        owner.setFirstName("Smith");

        when(ownerRepository.findAll()).thenReturn(Arrays.asList(owner));

        List<Owner> owners = this.ownerServiceJpaImp.findAll();

        assertNotNull(owners);
        assertEquals(1, owners.size());
    }

    @Test
    void update() {
        Owner owner = new Owner();
        owner.setFirstName("Smith");

        when(ownerRepository.findById(anyInt())).thenReturn(java.util.Optional.ofNullable(owner));

        Owner john = new Owner();
        john.setFirstName("Phil");

        this.ownerServiceJpaImp.update(1, john);

        verify(ownerRepository, times(1)).save(any(Owner.class));
        verify(ownerRepository, times(1)).findById(anyInt());
    }

    @Test
    void save() {
        Owner john = new Owner();
        john.setFirstName("Phil");
        this.ownerServiceJpaImp.save(john);
        verify(ownerRepository, times(1)).save(any(Owner.class));
    }

}