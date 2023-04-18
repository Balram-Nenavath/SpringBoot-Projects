package com.hibernatedemo.dao;

import java.util.List;

import javax.persistence.Cacheable;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hibernatedemo.config.HibernateConfig;
import com.hibernatedemo.entity.Demo;

import net.sf.ehcache.hibernate.EhCacheRegionFactory;
@Repository
public class DemoDaoImpl implements DemoDao {
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Demo> getAllDemo() {
		//try with resource
		try (Session session = this.sessionFactory.getCurrentSession()) {
			Query<Demo> query = session.createQuery("from Demo"); //HQL we can set params
			List<Demo> demoList = query.getResultList();
			return demoList;
		} 
	catch (Exception e) {
			// TODO: handle exception
			return null;
		}

}
	
 

	@Override
	public Demo getDemoById(Long id) {

		try (Session session = this.sessionFactory.getCurrentSession()) {
			Demo demo = session.get(Demo.class, id);
			return demo;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public Demo saveDemo(Demo demo) {
		try (Session session = this.sessionFactory.getCurrentSession()) {
			session.save(demo);
			return demo;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public void updateDemo(Long id, Demo demo) {
		try (Session session = this.sessionFactory.getCurrentSession()) {
			org.hibernate.Transaction tx = session.beginTransaction();
			Demo demoUsable = session.get(Demo.class, id);
			BeanUtils.copyProperties(demo, demoUsable);
			demoUsable.setId(id);
			session.update(demoUsable);
			tx.commit();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void deleteDemo(Long id) {
		// TODO Auto-generated method stub
		try (Session session = this.sessionFactory.getCurrentSession()) {
			Demo demoResp = session.load(Demo.class, id);
			if (demoResp != null) {
				session.delete(demoResp);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public List<Demo> demoForAllItemsWithCriteria() {
		try (Session session = this.sessionFactory.getCurrentSession()) {
			Criteria criteria = session.createCriteria(Demo.class);
			List<Demo> demo = criteria.list();
			return demo;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Demo> demoForEquals(String name) {

		try (Session session = this.sessionFactory.getCurrentSession()) {
			Criteria crit = session.createCriteria(Demo.class);
//			crit.setResultTransformer(DistinctRootEntityResultTransformer.INSTANCE);
			crit.add(Restrictions.eq("name", name));
			List<Demo> results = crit.list();
			return results;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Demo> demoForNotEquals(String name) {
		try (Session session = this.sessionFactory.getCurrentSession()) {
			Criteria crit = session.createCriteria(Demo.class);
			crit.add(Restrictions.ne("name", name));
			List<Demo> results = crit.list();
			return results;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Demo> demoForGreaterThan(Long score) {
		try (Session session = this.sessionFactory.getCurrentSession()) {
			Criteria crit = session.createCriteria(Demo.class);
			crit.add(Restrictions.gt("score", score));
			List<Demo> results = crit.list();
			return results;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Demo> demoForGreaterThanEquals(Long score) {
		try (Session session = this.sessionFactory.getCurrentSession()) {
			Criteria crit = session.createCriteria(Demo.class);
			crit.add(Restrictions.ge("score", score));
			List<Demo> results = crit.list();
			return results;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Demo> demoForLike(String name) {
		try (Session session = this.sessionFactory.getCurrentSession()) {
			Criteria crit = session.createCriteria(Demo.class);
			crit.add(Restrictions.like("name", name, MatchMode.ANYWHERE));// match mode has 4 diff types
																			// anywhere,exact,start,end
			List<Demo> results = crit.list();
			return results;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Demo> demoForILike(String name) {
		try (Session session = this.sessionFactory.getCurrentSession()) {
			Criteria crit = session.createCriteria(Demo.class);
			crit.add(Restrictions.ilike("name", name, MatchMode.ANYWHERE));// ilike is case senstive
			List<Demo> results = crit.list();
			return results;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Demo> demoForisNull() {
		try (Session session = this.sessionFactory.getCurrentSession()) {
			Criteria crit = session.createCriteria(Demo.class);
			crit.add(Restrictions.isNull("name"));
			List<Demo> results = crit.list();
			return results;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Demo> demoForisNotNull() {

		try (Session session = this.sessionFactory.getCurrentSession()) {
			Criteria crit = session.createCriteria(Demo.class);
			crit.add(Restrictions.isNotNull("name"));
			List<Demo> results = crit.list();
			return results;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Demo> demoForLessThan(Long score) {
		try (Session session = this.sessionFactory.getCurrentSession()) {
			Criteria crit = session.createCriteria(Demo.class);
			crit.add(Restrictions.lt("score", score));
			List<Demo> results = crit.list();
			return results;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Demo> demoForLessThanEquals(Long score) {
		try (Session session = this.sessionFactory.getCurrentSession()) {
			Criteria crit = session.createCriteria(Demo.class);
			crit.add(Restrictions.le("score", score));
			List<Demo> results = crit.list();
			return results;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Demo> demoForOr(Long score, String name) {
		try (Session session = this.sessionFactory.getCurrentSession()) {
			Criteria crit = session.createCriteria(Demo.class);
			Criterion scorelessThan = Restrictions.lt("score", score);
			Criterion sa = Restrictions.ilike("name", name, MatchMode.ANYWHERE);
			LogicalExpression orExp = Restrictions.or(scorelessThan, sa);
			crit.add(orExp);
			List<Demo> results = crit.list();
			return results;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Demo> demoForAnd(Long score, String name) {
		try (Session session = this.sessionFactory.getCurrentSession()) {
			Criteria crit = session.createCriteria(Demo.class);
			Criterion scorelessThan = Restrictions.gt("score", score);
			Criterion sa = Restrictions.ilike("name", name, MatchMode.ANYWHERE);
			LogicalExpression orExp = Restrictions.and(scorelessThan, sa);
			crit.add(orExp);
			List<Demo> results = crit.list();
			return results;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Demo> demoForDisjunction(Long score, String name) {
		try (Session session = this.sessionFactory.getCurrentSession()) {
			Criteria crit = session.createCriteria(Demo.class);
			Criterion scorelessThan = Restrictions.lt("score", score);
			Criterion scoreGreaterThan = Restrictions.gt("score", score);
			Criterion nameRes = Restrictions.ilike("name", name, MatchMode.ANYWHERE);//more than 2 conditions
			Disjunction disjunction = Restrictions.disjunction();
			disjunction.add(scorelessThan);
			disjunction.add(scoreGreaterThan);
			disjunction.add(nameRes);
			crit.add(disjunction);
			List<Demo> results = crit.list();
			return results;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Demo> demoForSqlRestriction() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Demo> demoPagination(Long pageNo, Long maxNo) {
		try (Session session = this.sessionFactory.getCurrentSession()) {
			Criteria crit = session.createCriteria(Demo.class);
			crit.setFirstResult(pageNo.intValue());
			crit.setMaxResults(maxNo.intValue());
			List<Demo> results = crit.list();
			return results;
		} catch (Exception e) {
			return null;
		}
	}

}
