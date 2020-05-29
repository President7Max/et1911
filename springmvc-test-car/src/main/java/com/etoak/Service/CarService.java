package com.etoak.Service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.etoak.bean.Car;
import com.etoak.bean.CarVo;
import com.etoak.bean.PageVo;

public interface CarService {
	
	int addCar(Car car);
	
	PageVo<CarVo> queryList(int pageNum,int pageSize,CarVo carVo,String[] priceList);
	
	List<String> queryBrand();
	
	List<String> querySeriesByBrand(@Param("brand") String brand);
	
	
	
}
