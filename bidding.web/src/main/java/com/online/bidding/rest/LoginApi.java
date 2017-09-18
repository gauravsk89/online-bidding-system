package com.online.bidding.rest;

import lombok.extern.slf4j.Slf4j;
import com.online.bidding.domain.Item;
import com.online.bidding.service.ItemService;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Component
@Path("/items")
@Slf4j
public class LoginApi {

    @Inject
    private ItemService itemService;

    @POST
    @Path("/")
    public Response addItem(Item item) {

        itemService.addItem();

        return Response
                .created(null)
                .build();
    }

}
