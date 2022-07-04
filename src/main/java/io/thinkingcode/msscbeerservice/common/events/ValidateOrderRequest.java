package io.thinkingcode.msscbeerservice.common.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import io.thinkingcode.msscbeerservice.common.events.BeerOrderDTO;
import thinkingcode.sfg.brewery.model.BeerOrderDTO;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ValidateOrderRequest {

    private BeerOrderDTO beerOrder;
}
