package io.thinkingcode.msscbeerservice.web.mappers;

import io.thinkingcode.msscbeerservice.domain.Beer;
import io.thinkingcode.msscbeerservice.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

    BeerDto beerToBeerDto(Beer beer);
    Beer beerDtoToBeer(BeerDto beerDto);

    BeerDto beerToBeerDtoWithInventory(Beer beer);
}
