package com.mantabs.collection.master.area_assignment.controller;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public abstract class BaseDaoImpl {

	@PersistenceContext
	private EntityManager em;

	protected Map<String, Object> getPaging(String sql, Pageable pageable,
			Object... params) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("totalRecords", getSizePaging(sql, params));
		map.put("contentData", getListDataPaging(sql, pageable, params));
		return map;
	}

	protected int getSizePaging(String sql, Object... params) {
		String q = "SELECT COUNT(*) AS COUNT FROM (" + sql + " ) AB";
		if (params != null) {
			Query query = em.createNativeQuery(q);
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i + 1, params[i]);
			}
			return toLong(query.getSingleResult());
		} else {
			return toLong(em.createNativeQuery(q).getSingleResult());
		}

	}

	protected int toLong(Object obj) {
		int result = 0;
		if (obj instanceof Integer) {
			result = (int) obj;
		} else if (obj instanceof BigDecimal) {
			result = ((BigDecimal) obj).intValue();
		} else if (obj instanceof Double) {
			result = ((Double) obj).intValue();
		} else {
			result = Integer.parseInt(obj.toString());
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	protected List<Object[]> getListDataPaging(String sql, Pageable pageable, Object... params) {
		String orderBy = "";
		String direction = "ASC";
		for (Iterator<Sort.Order> itr = pageable.getSort().iterator(); itr
				.hasNext();) {
			Sort.Order order = itr.next();
			if (orderBy == null || orderBy.isEmpty()) {
				orderBy = order.getProperty();
			} else {
				orderBy = orderBy + ", " + order.getProperty();
			}
			direction = order.getDirection().name();
			// break;
		}
//		String q = "SELECT * FROM (SELECT AA.* FROM(" + sql
//				+ " ORDER BY " + orderBy + " " + direction + ") AA ) "
		/*
		 * + " OFFSET " + pageable.getPageNumber() + " ROWS FETCH NEXT " +
		 * pageable.getPageSize() + " ROWS ONLY"
		 */
		String q = "SELECT * FROM (SELECT AA.*, ROWNUM AS NOURUT FROM(" + sql
				+ " ORDER BY TO_NUMBER (" + orderBy + ") " + direction + ")AA ) WHERE "
				+ ((pageable.getPageNumber() + 1) * pageable.getPageSize())
				+ " >=  NOURUT AND NOURUT > "
				+ (pageable.getPageNumber() * pageable.getPageSize());
		
		if (params != null) {
			Query query = em.createNativeQuery(q);
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i + 1, params[i]);
			}
			return query.getResultList();
		} else {
			return em.createNativeQuery(q).getResultList();
		}
		
		
	}
}