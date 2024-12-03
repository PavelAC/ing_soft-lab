package com.parking.parkinglot.ejb;

import com.parking.parkinglot.common.CarDto;
import com.parking.parkinglot.entities.Car;
import com.parking.parkinglot.entities.User;
import jakarta.ejb.EJBException;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class CarsBean {
    private static final Logger LOG = Logger.getLogger(CarsBean.class.getName());

    @PersistenceContext
    EntityManager entityManager;

    public List<CarDto> findAllCars(){
        LOG.info("Find all cars");
        try {
            TypedQuery<Car> typedQuery = entityManager.createQuery("SELECT c FROM Car c", Car.class);
            List<Car> cars = typedQuery.getResultList();
            return copyCarsToDto(cars);
        }catch (Exception ex){
            throw new EJBException(ex);
        }
    }

    private List<CarDto> copyCarsToDto(List<Car> cars){
        List<CarDto> dtos = new ArrayList<>();
        for (Car car : cars){
            CarDto carEntity = new CarDto(car.getId(),car.getLicensePlate(),car.getParkingSpot(),car.getUser().getUsername());
            dtos.add(carEntity);
        }
        return dtos;
    }

    public void creatCar(String licensePlate, String parkingSpot, Long userId){
        LOG.info("Create car");

        Car car = new Car();
        car.setLicensePlate(licensePlate);
        car.setParkingSpot(parkingSpot);

        User user = entityManager.find(User.class, userId);
        user.getCars().add(car);
        car.setUser(user);

        entityManager.persist(car);
    }

    public CarDto findByid(Long id){
        LOG.info("Find car by id");
        Car car = entityManager.find(Car.class, id);
        return new CarDto(car.getId(), car.getLicensePlate(), car.getParkingSpot(), car.getUser().getUsername());
    }

    public void updateCar(Long carId, String licensePlate, String parkingSpot, Long userId){
        LOG.info("Update car");
        Car car = entityManager.find(Car.class, carId);
        car.setLicensePlate(licensePlate);
        car.setParkingSpot(parkingSpot);

        User oldUser = car.getOwner();
        oldUser.getCars().remove(car);

        User user = entityManager.find(User.class, userId);
        user.getCars().add(car);
        car.setOwner(user);
    }

    public void deleteCarsByIds(List<Long> carIds){
        LOG.info("Delete cars by ids");
        for (Long carId : carIds){
            Car car = entityManager.find(Car.class, carId);
            entityManager.remove(car);
        }
    }
}
