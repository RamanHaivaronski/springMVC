package com.babich.dao;

import com.babich.models.Car;
import com.babich.models.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CarDAO {
    @Select("SELECT * FROM cars")
    List<Car> getAllCars();

    @Insert("insert into cars(brand,path) values (#{brand},#{path})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "car_id", before = false, resultType=Integer.class)
    void addCar(Car car);

    @Delete("delete from cars where car_id=#{id}")
    void deleteCar(int id);

    @Delete("del")
    void deleteUserCar();
}
