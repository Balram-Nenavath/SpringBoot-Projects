package com.hibernatedemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hibernatedemo.dao.DemoDao;
import com.hibernatedemo.entity.Demo;

@Service
public class DemoService implements IDemoService {

	@Autowired
	DemoDao demoDao;

	@Override
	public List<Demo> getAllDemos() {
		// TODO Auto-generated method stub

		return demoDao.getAllDemo();
	}

	@Override
	public Demo getDemoById(Long id) {
		// TODO Auto-generated method stub
		return demoDao.getDemoById(id);
	}

	@Override
	public Demo saveDemo(Demo demo) {
		// TODO Auto-generated method stub
		return demoDao.saveDemo(demo);
	}

	@Override
	public String demoDetailsUpdate(Long id, Demo demo) {
		// TODO Auto-generated method stub
		try {
			demoDao.updateDemo(id, demo);
			return "details updated successfully";
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public String demoDetailsDelete(Long id) {
		// TODO Auto-generated method stub
		try {
			demoDao.deleteDemo(id);
			return "demo deleted successfully";
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public List<Demo> criteriaGetAllExample() {
		return demoDao.demoForAllItemsWithCriteria();
	}

	@Override
	public List<Demo> criteriaEq(String name) {
		return demoDao.demoForEquals(name);
	}

	@Override
	public List<Demo> criteriaNe(String name) {
		return demoDao.demoForNotEquals(name);
	}

	@Override
	public List<Demo> criteriaLike(String name) {
		return demoDao.demoForLike(name);
	}

	@Override
	public List<Demo> criteriaIlike(String name) {
		return demoDao.demoForILike(name);
	}

	@Override
	public List<Demo> criteriaisNUll() {
		return demoDao.demoForisNull();
	}

	@Override
	public List<Demo> criteriaisNotNull() {
		return demoDao.demoForisNotNull();
	}

	@Override
	public List<Demo> criteriaGt(Long score) {
		return demoDao.demoForGreaterThan(score);
	}

	@Override
	public List<Demo> criteriaGe(Long score) {
		return demoDao.demoForGreaterThanEquals(score);
	}

	@Override
	public List<Demo> criteriaLt(Long score) {
		return demoDao.demoForLessThan(score);
	}

	@Override
	public List<Demo> criteriaLe(Long score) {
		return demoDao.demoForLessThanEquals(score);
	}

	@Override
	public List<Demo> criteriaMultipleRestrictions(Long score, String name) {
		return demoDao.demoForOr(score, name);
	}

	@Override
	public List<Demo> criteriaDisjunction(Long score, String name) {
		return demoDao.demoForDisjunction(score, name);
	}

	@Override
	public List<Demo> criteriaAnd(Long score, String name) {
		return demoDao.demoForAnd(score, name);
	}

	@Override
	public List<Demo> criteriaPagination(Long pageNo, Long maxNo) {
		// TODO Auto-generated method stub
		return demoDao.demoPagination(pageNo, maxNo);
	}
}
