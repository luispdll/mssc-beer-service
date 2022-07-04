package io.thinkingcode.msscbeerservice.common.events;

import io.thinkingcode.msscbeerservice.common.BeerDTO;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NewInventoryEvent extends BeerEvent {
    public NewInventoryEvent(BeerDTO beerDto) {
        super(beerDto);
    }
}