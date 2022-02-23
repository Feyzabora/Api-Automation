package petStore;

import models.pet.Pet;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface PetStoreServices {

    String BASE_URL = PetStoreApi.BASE_URL;

    @Headers({"accept: application/json","Content-Type: application/json"})
    @POST(BASE_URL + PetStoreApi.PET_SUFFIX)
    Call<Pet> postPet(@Body Pet pet);

    @Headers({"accept: application/json"})
    @GET(BASE_URL + PetStoreApi.PET_SUFFIX + PetStoreApi.FIND_BY_STATUS_SUFFIX)
    Call<List<Pet>> findPetByStatus(@Query("status") String status);
}
