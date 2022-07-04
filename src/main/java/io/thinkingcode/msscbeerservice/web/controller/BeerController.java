package io.thinkingcode.msscbeerservice.web.controller;

import io.thinkingcode.msscbeerservice.common.BeerDTO;
import io.thinkingcode.msscbeerservice.common.BeerPagedList;
import io.thinkingcode.msscbeerservice.common.BeerStyleEnum;
import io.thinkingcode.msscbeerservice.services.BeerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
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

    private static final int DEFAULT_PAGE_NUMBER = 0;
    private static final int DEFAULT_PAGE_SIZE = 25;

    @GetMapping
    public ResponseEntity<BeerPagedList> listBeers(@RequestParam(required = false) Integer pageNumber,
                                                   @RequestParam(required = false) Integer pageSize,
                                                   @RequestParam(required = false) String beerName,
                                                   @RequestParam(required = false) BeerStyleEnum beerStyle) {
        if (pageNumber == null || pageNumber < 0 ){
            pageNumber = DEFAULT_PAGE_NUMBER;
        }

        if (pageSize == null || pageSize < 1){
            pageSize  = DEFAULT_PAGE_SIZE;
        }

        BeerPagedList beerList = beerService.listBeers(beerName, beerStyle, PageRequest.of(pageNumber,pageSize), Boolean.FALSE);

        return ResponseEntity.status(HttpStatus.OK).body(beerList);
    }

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDTO> handleGetBeerById(@PathVariable("beerId") UUID beerId,
                                                     @RequestParam(required = false) Boolean showInventoryOnHand) {
        if (showInventoryOnHand == null) {
            showInventoryOnHand = false;
        }

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(beerService.getById(beerId, showInventoryOnHand));
    }

    @PostMapping
    public ResponseEntity<BeerDTO> handleSaveNewBeer(@RequestBody @Validated BeerDTO beerDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(beerService.saveNewBeer(beerDto));
    }

    @PutMapping("/{beerId}")
    public ResponseEntity<BeerDTO> handleUpdateBeerById(@PathVariable("beerId") UUID beerId, @RequestBody @Validated BeerDTO beerDto) {
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body(beerService.updateBeer(beerId, beerDto));
    }

    @GetMapping("beerUpc/{upc}")
    public ResponseEntity<BeerDTO> getBeerByUpc(@PathVariable("upc") String upc){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(beerService.getByUpc(upc));
    }
}
