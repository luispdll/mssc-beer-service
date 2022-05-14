package io.thinkingcode.msscbeerservice.web.controller;

import io.thinkingcode.msscbeerservice.services.BeerService;
import io.thinkingcode.msscbeerservice.web.model.BeerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {

    private final BeerService beerService;

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> handleGetBeerById(@PathVariable("beerId") UUID beerId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(beerService.getById(beerId));
    }

    @PostMapping
    public ResponseEntity<BeerDto> handleSaveNewBeer(@RequestBody @Validated BeerDto beerDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(beerService.saveNewBeer(beerDto));
    }

    @PutMapping("/{beerId}")
    public ResponseEntity<BeerDto> handleUpdateBeerById(@PathVariable("beerId") UUID beerId, @RequestBody @Validated BeerDto beerDto) {
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body(beerService.updateBeer(beerId, beerDto));
    }
}
