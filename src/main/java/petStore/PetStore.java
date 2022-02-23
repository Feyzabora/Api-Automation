package petStore;

import models.pet.Pet;
import org.junit.Assert;
import retrofit2.Call;
import utils.Caller;
import utils.Printer;
import utils.ServiceGenerator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PetStore extends Caller {
    public static PetStoreServices services = ServiceGenerator.generateService(PetStoreServices.class);
    Printer log = new Printer(PetStore.class);

    public void addPet(String name, String status) {
        Pet pet = new Pet();
        pet.setName(name);
        pet.setStatus(status);
        Pet.Category category = pet.new Category();
        category.setId(0L);
        category.setName("Dogs");
        pet.setCategory(category);
        pet.setId(0L);
        List<Pet.Category> tags = Collections.singletonList(category);
        pet.setTags(tags);
        List<String> photoUrls = Arrays.asList("x", "y");
        pet.setPhotoUrls(photoUrls);

        Call<Pet> postPet = services.postPet(pet);
        Pet responseModel = perform(postPet, true, "postPet -> PetStoreServices");
        log.new Important(responseModel.getName());
        log.new Important(responseModel.getStatus());
        log.new Success(responseModel.getId());
    }

    public void findPetByStatus(String status) {
        Call<List<Pet>> findPetByStatus = services.findPetByStatus(status);
        for (Pet pet: perform(findPetByStatus,true,"findPetByStatus -> PetStoreServices")) {
            log.new Info(pet.getName() + ", status: " + pet.getStatus());
            Assert.assertEquals(status,pet.getStatus());
        }
    }
}