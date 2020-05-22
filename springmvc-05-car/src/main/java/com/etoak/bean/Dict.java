package com.etoak.bean;

import java.io.Serializable;

import lombok.Data;

@Data
public class Dict implements Serializable{
	
	/**
	 * 字典实体类
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String groupId;
	private String name;
	private String value;
	private Integer sort;

}
