package com.online.bidding.service;

import com.online.bidding.domain.Bid;
import com.online.bidding.repository.ItemsRepository;
import lombok.extern.slf4j.Slf4j;
import com.online.bidding.domain.Item;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Service
@Slf4j
public class ItemServiceImpl implements ItemService{

    @Inject
    private ItemsRepository itemsRepository;

    @Override
    @Transactional
    public Item addItem() {

        Item watch = Item
                .builder()
                .name("watch")
                .initialAmount(new BigDecimal(1000))
                .build();
        Bid bid1 = Bid
                .builder()
                .bidAmount(new BigDecimal(1200))
                .item(watch)
                .build();

        Set<Bid> bids = new HashSet<>();
        bids.add(bid1);

        watch.setBids(bids);

        itemsRepository.save(watch);

        log.debug("item saved {}", watch);


        return watch;
    }
}
