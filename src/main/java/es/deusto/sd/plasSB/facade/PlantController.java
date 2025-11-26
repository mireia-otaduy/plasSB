package es.deusto.sd.plasSB.facade;

import org.springframework.web.bind.annotation.*;
import es.deusto.sd.plasSB.service.PlantService;
import es.deusto.sd.plasSB.entity.Plant;

import java.util.List;

/**
 * REST controller exposing endpoints for Plant operations.
 */
@RestController
@RequestMapping("/plants")
public class PlantController {
    private final PlantService plantService;

    public PlantController(PlantService plantService) {
        this.plantService = plantService;
    }

    /**
     * Get capacity for a specific plant by ID.
     * Example: GET /plants/1/capacity
     */
    @GetMapping("/{id}/capacity")
    public int getCapacity(@PathVariable long id) {
        return plantService.getPlantCapacity(id);
    }

    /**
     * Get full plant details by ID.
     * Example: GET /plants/1
     */
    @GetMapping("/{id}")
    public Plant getPlant(@PathVariable long id) {
        return plantService.getPlant(id);
    }

    /**
     * Get a list of all plants.
     * Example: GET /plants
     */
    @GetMapping
    public List<Plant> getAllPlants() {
        return plantService.getAllPlants();
    }

    /**
     * Update a plant's capacity after processing containers.
     * Example: PUT /plants/1/capacity?processed=10
     */
    @PutMapping("/{id}/capacity")
    public boolean updateCapacity(@PathVariable long id, @RequestParam int processed) {
        return plantService.updatePlantCapacity(id, processed);
    }

    /**
     * Add a new plant.
     * Example: POST /plants (with JSON body)
     */
    @PostMapping
    public Plant addPlant(@RequestBody Plant plant) {
        return plantService.addPlant(plant);
    }
}
