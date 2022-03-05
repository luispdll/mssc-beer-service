package io.thinkingcode.msscbeerservice.bootstrap;

import io.thinkingcode.msscbeerservice.domain.Beer;
import io.thinkingcode.msscbeerservice.repositories.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BeerLoader implements CommandLineRunner {

    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects() {
        if (beerRepository.count() == 0) {
            beerRepository.save(Beer.builder()
                    .beerName("Victoria")
                    .beerStyle("Oscura")
                    .quantityToBrew(200)
                    .minOnHand(12)
                    .upc(33701000000L)
                    .price(new BigDecimal("12.95"))
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("Indio")
                    .beerStyle("Oscura")
                    .quantityToBrew(200)
                    .minOnHand(12)
                    .upc(33701000000L)
                    .price(new BigDecimal("12.95"))
                    .build());
        }

        System.out.println("Loaded beers: " + beerRepository.count());
    }
}
