package com.online.bidding.service;

import com.online.bidding.dto.UserDTO;
import com.online.bidding.domain.User;

public interface UserService {

    User register(UserDTO userDTO);

    User getUserById(String id);

}
