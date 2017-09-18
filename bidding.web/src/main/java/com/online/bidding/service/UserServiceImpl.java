package com.online.bidding.service;

import com.online.bidding.domain.Address;
import com.online.bidding.domain.Phone;
import lombok.extern.slf4j.Slf4j;
import org.dozer.DozerBeanMapper;
import com.online.bidding.domain.User;
import com.online.bidding.dto.UserDTO;
import com.online.bidding.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.inject.Inject;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService{

    @Inject
    private DozerBeanMapper dozerBeanMapper;

    @Inject
    private UserRepository userRepository;


    @Override
    public User getUserById(String id) {

        User user = userRepository.findById(Long.valueOf(id));

        log.debug("For id {} user found {}", id, user);

        return user;
    }

    @Override
    @Transactional
    public User register(UserDTO userDTO) {

        User user = dozerBeanMapper.map(userDTO, User.class);
        Address address = dozerBeanMapper.map(userDTO.getAddress(), Address.class);
        Phone phone = dozerBeanMapper.map(userDTO.getPhone(), Phone.class);
        phone.setUser(user);

        user.setAddress(address);
        user.getPhoneSet().add(phone);

        userRepository.save(user);

        log.debug("user registered {}", user);

        return user;
    }

}
