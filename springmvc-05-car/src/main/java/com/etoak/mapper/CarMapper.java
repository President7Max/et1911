package com.etoak.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.etoak.bean.Car;
import com.etoak.bean.CarVo;

public interface CarMapper {
	
	//添加
	int addCar(Car car);
	
	//查询
	List<CarVo> queryList(CarVo carVo);
	
	//获取所有品牌
	List<String> getAllBrand();
	
	
	
	//根据品牌查询车系
	List<String> getSeriesByBrand(@Param("brand") String brand);
	
	
	
}
