package io.thinkingcode.msscbeerservice.common.events;

import io.thinkingcode.msscbeerservice.common.BeerDTO;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BrewBeerEvent extends BeerEvent {

    public BrewBeerEvent(BeerDTO beerDto) {
        super(beerDto);
    }
}