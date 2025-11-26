package es.deusto.sd.plasSB.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import es.deusto.sd.plasSB.entity.Plant;
import es.deusto.sd.plasSB.repository.PlantRepository;

/**
 * Service layer containing business logic for Plant operations.
 */
@Service
public class PlantService {
    private final PlantRepository repo;

    public PlantService(PlantRepository repo) {
        this.repo = repo;
    }

    /**
     * Returns the capacity of a plant by its ID.
     */
    public int getPlantCapacity(long plantId) {
        Optional<Plant> plantOpt = repo.findById(plantId);
        return plantOpt.map(Plant::getCapacity).orElse(0); // Return 0 if not found
    }

    /**
     * Returns the full details of a plant.
     */
    public Plant getPlant(long plantId) {
        return repo.findById(plantId).orElse(null);
    }

    /**
     * Returns all plants. Useful for dashboards or selecting plants.
     */
    public List<Plant> getAllPlants() {
        return repo.findAll();
    }

    /**
     * Updates a plant's capacity (e.g., when new containers are assigned).
     */
    public boolean updatePlantCapacity(long plantId, int containersProcessed) {
        Optional<Plant> plantOpt = repo.findById(plantId);
        if (plantOpt.isPresent()) {
            Plant plant = plantOpt.get();
            int newCapacity = plant.getCapacity() - containersProcessed;
            plant.setCapacity(Math.max(0, newCapacity));
            repo.save(plant);
            return true;
        }
        return false;
    }

    /**
     * Adds a new plant to the system.
     */
    public Plant addPlant(Plant plant) {
        return repo.save(plant);
    }
}
