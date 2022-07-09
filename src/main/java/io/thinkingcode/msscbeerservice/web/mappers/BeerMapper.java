package io.thinkingcode.msscbeerservice.web.mappers;

import io.thinkingcode.msscbeerservice.common.BeerDTO;
import io.thinkingcode.msscbeerservice.domain.Beer;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class}, componentModel = "spring")
@DecoratedWith(BeerMapperDecorator.class)
public interface BeerMapper {

    BeerDTO beerToBeerDto(Beer beer);
    Beer beerDtoToBeer(BeerDTO beerDto);

    BeerDTO beerToBeerDtoWithInventory(Beer beer);
}
