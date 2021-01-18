package Rest.Controllers;

import Rest.Entities.Aquascape;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import Rest.Entities.AquascapeAssembler;
import Rest.Entities.Fish;
import Rest.Responses.AquascapeCollectionResponse;
import Rest.Responses.AquascapeResponse;
import Rest.Services.AquascapeCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AquascapeController {

    @Autowired
    private AquascapeCollectionService aquascapeCollectionService;

    private AquascapeAssembler aquascapeAssembler = new AquascapeAssembler();

    @RequestMapping(value = "/hello")
    public ResponseEntity<String> sayHi(){
        try {
            return new ResponseEntity<String>("Hi", HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
        }
    }

    /*@GET
    @Path("/aquascapes")
    @Produces(MediaType.APPLICATION_JSON)*/
    @RequestMapping(value = "/aquascapes")
    public ResponseEntity<AquascapeCollectionResponse> getAllAquascapes() {
        try {
            AquascapeCollectionResponse response = new AquascapeCollectionResponse();
            response.setAquascapes(aquascapeCollectionService.getAllAquascapes());
            return ResponseEntity.ok(response);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /*
    @RequestMapping(value = "/aquascapes/{id}")
    public ResponseEntity<List<Aquascape>> getAllAquascapesByUser(int userId) {
        try {
            return new ResponseEntity<>(aquascapeCollectionService.getAllAquascapesByUser(userId), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }*/

    @RequestMapping(value = "/aquascapes/{id}")
    public ResponseEntity<AquascapeResponse> getAquascapeById(@PathVariable String id) {
        try {
            AquascapeResponse aquascapeResponse = new AquascapeResponse();
            aquascapeResponse.setAquascape(aquascapeCollectionService.getAquascapeById(Integer.parseInt(id)));
            return ResponseEntity.ok(aquascapeResponse);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/aquascapes")
    public ResponseEntity<AquascapeCollectionResponse> addPlant(@RequestBody Aquascape aquascape) {
        try {
            AquascapeCollectionResponse aquascapeCollectionResponse = new AquascapeCollectionResponse();
            aquascapeCollectionResponse.setSuccess(true);
            aquascapeCollectionService.addAquascape(aquascape);
            return ResponseEntity.ok(aquascapeCollectionResponse);
        }
        catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

    }
}
