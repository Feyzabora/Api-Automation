package steps;

import io.cucumber.java.en.*;
import petStore.PetStore;

public class PetStoreSteps {

    PetStore petStore = new PetStore();

    @Given("Post pet named {}, with status {}")
    public void search(String name,String status){petStore.addPet(name,status);}

    @Given("Find pet and verify by status {}")
    public void findPetByStatus(String status){petStore.findPetByStatus(status.toLowerCase());}

    @Given("Find pet by this id {}")
    public void getPetID(Long ID){petStore.getPetByID(ID);}
}
