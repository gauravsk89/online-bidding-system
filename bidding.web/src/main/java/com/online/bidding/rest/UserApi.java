package com.online.bidding.rest;

import com.online.bidding.domain.User;
import com.online.bidding.util.ApiLinkBuilder;
import lombok.extern.slf4j.Slf4j;
import com.online.bidding.dto.UserDTO;
import com.online.bidding.service.UserService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;

@Path("/users")
@Slf4j
public class UserApi {

    @Inject
    private UserService userService;

    @Inject
    private ApiLinkBuilder apiLinkBuilder;

    @Path("/")
    @POST
    public Response register(
            @Context UriInfo uriInfo,
            UserDTO userDTO){

        log.debug("registration request received {}", userDTO);

        User user = userService.register(userDTO);

        URI uri = apiLinkBuilder.createObjectLink(uriInfo, user.getId().toString());

        return Response
                .created(uri)
                .build();
    }

    @GET
    @Path("/{id}")
    public Response getUser(@PathParam("id")String id){

        User user = userService.getUserById(id);

        return Response
                .ok()
                .entity(user)
                .build();
    }

}
