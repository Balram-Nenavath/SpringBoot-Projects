package com.hibernatedemo.service;

import java.util.List;

import com.hibernatedemo.entity.Demo;

public interface IDemoService {

	List<Demo> getAllDemos();

	Demo getDemoById(Long id);

	Demo saveDemo(Demo demo);

	String demoDetailsUpdate(Long id, Demo demo);

	String demoDetailsDelete(Long id);

	List<Demo> criteriaGetAllExample();

	List<Demo> criteriaEq(String name);

	List<Demo> criteriaNe(String name);

	List<Demo> criteriaLike(String name);

	List<Demo> criteriaIlike(String name);

	List<Demo> criteriaisNUll();

	List<Demo> criteriaisNotNull();

	List<Demo> criteriaGt(Long score);

	List<Demo> criteriaGe(Long score);

	List<Demo> criteriaLt(Long score);

	List<Demo> criteriaLe(Long score);

	List<Demo> criteriaMultipleRestrictions(Long score, String name);

	List<Demo> criteriaDisjunction(Long score, String name);

	List<Demo> criteriaAnd(Long score, String name);

	List<Demo> criteriaPagination(Long pageNo, Long maxNo);
}
