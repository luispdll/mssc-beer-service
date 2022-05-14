package io.thinkingcode.msscbeerservice.web.controller;

import io.thinkingcode.msscbeerservice.web.model.BeerDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> handleGetBeerById(@PathVariable("beerId") UUID beerId) {
        // todo
        return new ResponseEntity<>(BeerDto.builder().build(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> handleSaveNewBeer(@RequestBody @Validated BeerDto beerDto) {
        // todo
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity<HttpStatus> handleUpdateBeerById(@PathVariable("beerId") UUID beerId, @RequestBody @Validated BeerDto beerDto) {
        // todo
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
