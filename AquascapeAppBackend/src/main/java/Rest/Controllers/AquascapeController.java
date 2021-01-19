package Rest.Controllers;

import Rest.Entities.Aquascape;

import Rest.Responses.AquascapeCollectionResponse;
import Rest.Responses.AquascapeResponse;
import Rest.Services.AquascapeCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AquascapeController {

    @Autowired
    private AquascapeCollectionService aquascapeCollectionService;

    @GetMapping(value = "/hello")
    public ResponseEntity<String> sayHi(){
        try {
            return new ResponseEntity<>("Hi", HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
        }
    }

    @RequestMapping(value = "/aquascapes", method = RequestMethod.GET)
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

    @RequestMapping(value = "/aquascapes/{id}", method = RequestMethod.GET)
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
