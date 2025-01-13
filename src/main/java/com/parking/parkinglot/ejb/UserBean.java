package com.parking.parkinglot.ejb;

import com.parking.parkinglot.common.UserDto;
import com.parking.parkinglot.entities.User;
import com.parking.parkinglot.entities.UserGroup;
import jakarta.ejb.EJBException;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class UserBean {
    private static final Logger LOG = Logger.getLogger(UserBean.class.getName());

    @Inject
    PasswordBean passwordBean;

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


    public void createUser(String username, String email, String password,
                           Collection<String> groups) {
        LOG.info("createUser");
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setEmail(email);
        newUser.setPassword(passwordBean.convertToSha256(password));
        em.persist(newUser);
        assignGroupsToUser(username, groups);
    }
    private void assignGroupsToUser(String username, Collection<String>
            groups) {
        LOG.info("assignGroupsToUser");
        for (String group : groups) {
            UserGroup userGroup = new UserGroup();
            userGroup.setUsername(username);
            userGroup.setUserGroup(group);
            em.persist(userGroup);
        }
    }

    public Collection<String> findUsernamesByUserIds(Collection<Long> userIds) {
        LOG.info("findUserByUsername");
        List<String> usernames =
                em.createQuery("SELECT u.username FROM User u WHERE u.id IN :userIds",String.class)
                        .setParameter("userIds",userIds)
                        .getResultList();
        return usernames;
    }
}
