package com.etoak.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.etoak.bean.Car;
import com.etoak.bean.CarVo;

public interface CarMapper {
	
	int addCar(Car car);
	
	List<CarVo> queryList(CarVo carVo);
	
	List<String> queryBrand();
	
	List<String> querySeriesByBrand(@Param("brand") String brand);
	
}
