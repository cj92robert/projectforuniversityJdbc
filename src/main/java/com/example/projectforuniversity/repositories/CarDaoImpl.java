package com.example.projectforuniversity.repositories;


import com.example.projectforuniversity.models.Car;
import com.example.projectforuniversity.models.CarPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class CarDaoImpl implements CarDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CarDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public CarPage findAllByColourStartWith(String colour, int currentPage) {

        RowMapper<Car> carRowMapper = (rs, rowNum) ->
                new Car(
                        rs.getLong(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5)
                );


        var carList1 =jdbcTemplate
                .query("SELECT * FROM cars WHERE colour LIKE ? LIMIT ?,?",
                        carRowMapper,
                        colour+"%",
                        (5 * (currentPage - 1)),
                        5
                        );
        var totalElement= jdbcTemplate
                .queryForObject("SELECT COUNT(*) FROM cars WHERE colour LIKE ?",
                        Integer.class,colour+"%");

        return new CarPage(totalElement,currentPage,carList1);
    }

    @Override
    public Car getById(long id) {
        RowMapper<Car> carRowMapper = (rs, rowNum) ->
                new Car(
                        rs.getLong(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5)
                );

        return jdbcTemplate
                .queryForObject("SELECT * FROM cars WHERE id = ?",
                        carRowMapper,
                        id);
    }

    @Override
    public int save(Car car) {
         return jdbcTemplate
                .update("INSERT INTO cars (model, car_make, colour, year) value (?,?,?,?)",
                        car.getModel(),
                        car.getCarMake(),
                        car.getColour(),
                        car.getYear());
    }

    @Override
    public int update(long id, Car car) {
        return jdbcTemplate
                .update("UPDATE cars SET model=?, car_make=?, colour=?, year=? WHERE id=?",
                        car.getModel(),car.getCarMake(),car.getColour(),car.getYear(),id);
    }

    @Override
    public int deleteById(long id) {
        return jdbcTemplate
                .update("DELETE FROM cars WHERE id=?",id);
    }
}
