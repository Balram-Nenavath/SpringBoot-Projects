package com.hibernatedemo.dao;

import java.util.List;

import com.hibernatedemo.entity.Demo;

public interface DemoDao {

	public List<Demo> getAllDemo();

	public Demo getDemoById(Long id);

	public Demo saveDemo(Demo demo);

	public void updateDemo(Long id, Demo demo);

	public void deleteDemo(Long id);

	List<Demo> demoForAllItemsWithCriteria();

	public List<Demo> demoForEquals(String name);

	public List<Demo> demoForNotEquals(String name);

	public List<Demo> demoForGreaterThan(Long score);

	public List<Demo> demoForGreaterThanEquals(Long score);

	public List<Demo> demoForLike(String name);

	public List<Demo> demoForILike(String name);

	public List<Demo> demoForisNull();

	public List<Demo> demoForisNotNull();

	public List<Demo> demoForLessThan(Long score);

	public List<Demo> demoForLessThanEquals(Long score);

	public List<Demo> demoForOr(Long score, String name);

	public List<Demo> demoForAnd(Long score, String name);

	public List<Demo> demoForSqlRestriction();

	List<Demo> demoForDisjunction(Long score, String name);

	List<Demo> demoPagination(Long pageNo, Long maxNo);

}
