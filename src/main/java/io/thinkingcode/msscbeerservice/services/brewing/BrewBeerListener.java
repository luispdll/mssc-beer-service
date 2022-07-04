package io.thinkingcode.msscbeerservice.services.brewing;

import io.thinkingcode.msscbeerservice.common.BeerDTO;
import io.thinkingcode.msscbeerservice.config.JmsConfig;
import io.thinkingcode.msscbeerservice.domain.Beer;
import io.thinkingcode.msscbeerservice.repositories.BeerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import io.thinkingcode.msscbeerservice.common.events.BrewBeerEvent;
import io.thinkingcode.msscbeerservice.common.events.NewInventoryEvent;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class BrewBeerListener {

    private final BeerRepository beerRepository;
    private final JmsTemplate jmsTemplate;

    @Transactional
    @JmsListener(destination = JmsConfig.BREWING_REQUEST_QUEUE)
    public void listen(BrewBeerEvent event){
        BeerDTO beerDto = event.getBeerDto();

        Beer beer = beerRepository.findById(beerDto.getId()).orElse(null);

        assert beer != null;
        beerDto.setQuantityOnHand(beer.getQuantityToBrew());

        NewInventoryEvent newInventoryEvent = new NewInventoryEvent(beerDto);

        log.debug("Brewed beer " + beer.getMinOnHand() + " : QOH: " + beerDto.getQuantityOnHand());

        jmsTemplate.convertAndSend(JmsConfig.NEW_INVENTORY_QUEUE, newInventoryEvent);
    }
}
