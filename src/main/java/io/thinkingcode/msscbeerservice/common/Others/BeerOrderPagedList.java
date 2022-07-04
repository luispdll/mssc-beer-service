package io.thinkingcode.msscbeerservice.common.Others;

import io.thinkingcode.msscbeerservice.common.events.BeerOrderDTO;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class BeerOrderPagedList extends PageImpl<BeerOrderDTO> {
    public BeerOrderPagedList(List<BeerOrderDTO> content, Pageable pageable, long total) {
        super(content, pageable, total);
    }

    public BeerOrderPagedList(List<BeerOrderDTO> content) {
        super(content);
    }

    public static class CustomerPagedList extends PageImpl<CustomerDTO> {
        public CustomerPagedList(List<CustomerDTO> content, Pageable pageable, long total) {
            super(content, pageable, total);
        }

        public CustomerPagedList(List<CustomerDTO> content) {
            super(content);
        }
    }
}
