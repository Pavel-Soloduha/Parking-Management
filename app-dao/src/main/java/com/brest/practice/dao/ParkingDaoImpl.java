package com.brest.practice.dao;

import com.brest.practice.core.Parking;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by Shadowofclown on 02.02.2016.
 */

public class ParkingDaoImpl implements ParkingDao {

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public ParkingDaoImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public void addParking(Parking parking) {

    }

    @Override
    public List<Parking> getAllParkings() {
        return null;
    }

    @Override
    public Parking getParkingById(Integer parkingId) {
        return null;
    }

    @Override
    public void updateParking(String address) {

    }

    @Override
    public void deleteParking(Integer parkingId) {

    }
}
