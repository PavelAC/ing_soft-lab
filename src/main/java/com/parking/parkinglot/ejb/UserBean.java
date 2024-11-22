package com.parking.parkinglot.ejb;

import com.parking.parkinglot.common.CarDto;
import com.parking.parkinglot.common.UserDto;
import com.parking.parkinglot.entities.Car;
import com.parking.parkinglot.entities.User;
import jakarta.ejb.EJBException;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class UserBean {
    private static final Logger LOG = Logger.getLogger(UserBean.class.getName());

    @PersistenceContext
    EntityManager em;

    public List<UserDto> findAllUsers() {
        LOG.info("finalAllUsers");
        try {
            TypedQuery<User> query = em.createQuery(" SELECT u FROM User u ", User.class);
            List<User> users = query.getResultList();
            return copyUserToDto(users);
        }catch (Exception e){
            throw new EJBException(e);
        }
    }

    private List<UserDto> copyUserToDto(List<User> users){
        List<UserDto> userDtoList = new ArrayList<>();
        for (User user : users){
            UserDto userEntity = new UserDto(user.getId(),user.getEmail(),user.getPassword(),user.getUsername());
            userDtoList.add(userEntity);
        }
        return userDtoList;
    }
}
