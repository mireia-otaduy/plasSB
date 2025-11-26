package es.deusto.sd.plasSB;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import es.deusto.sd.plasSB.entity.Plant;
import es.deusto.sd.plasSB.repository.PlantRepository;

/**
 * Seeds the database with example recycling plants at startup.
 */
@Component
public class DataInitializer implements CommandLineRunner {
    private final PlantRepository repo;

    public DataInitializer(PlantRepository repo) {
        this.repo = repo;
    }

    @Override
    public void run(String... args) {

        // Create sample plants using data from the Ecoembes initializer
        Plant p1 = new Plant(1L, 28001, "Bilbao", "Calle Gran Vía 45", 300);
        Plant p2 = new Plant(2L, 8001, "Pamplona", "Avenida Carlos III 120", 400);

        // Save plants to H2 database
        repo.save(p1);
        repo.save(p2);

        // If you want more plants, just add more .save() calls here

        // Logging (optional)
        System.out.println("Sample plants saved to database!");
    }
}
