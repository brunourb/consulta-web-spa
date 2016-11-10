package pe.gob.sunat.sivep.service.impl;

import java.util.List;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.sunat.sivep.dao.BeanDao;
import pe.gob.sunat.sivep.model.SHPRBean;
import pe.gob.sunat.sivep.model.SIVEPDatoBean;
import pe.gob.sunat.sivep.service.BeanService;
import pe.gob.sunat.sivep.web.util.SearchMapperUtil;

@Service("beanService")
public class BeanServiceImpl implements BeanService {
	private static final Logger logger = LoggerFactory.getLogger(BeanServiceImpl.class);

	private BeanDao beanDao;

	@Autowired
	public void setBeanDao(BeanDao beanDao) {
		this.beanDao = beanDao;
	}

//	public List<SHPRBean> searchBByQuery(String text) throws Exception {
//		QueryBuilder queryBuilder = QueryBuilders.queryStringQuery("*" + text + "*");
//		SearchResponse response = beanDao.searchBeanByQuery(queryBuilder);
//
//		logger.info("Method:searchBeanByQuery Counter of the hits: " + response.getHits().getTotalHits());
//		return SearchUtil.getObjects(response, SHPRBean.class);
//	}
	
	public List<SHPRBean> searchBByQuery(String text) throws Exception {
		QueryBuilder queryBuilder = getQueryBuilder(text);
		List<SHPRBean> responseList = beanDao.searchScrollBByQuery(queryBuilder);
		
		logger.info("Method:searchBByQuery responseBean.size(): " + responseList.size());
		return responseList;
	}
	
	public List<SHPRBean> searchBByQuery(String text, Integer start,Integer finish) throws Exception {
		QueryBuilder queryBuilder = getQueryBuilder(text);
		//List<SHPRBean> responseList = beanDao.searchScrollBByQuery(queryBuilder);
		int limit = getLimit(text, start, finish);
		List<SHPRBean> responseList = beanDao.searchPaginationBByQuery(queryBuilder,start,limit);
		logger.info("Method:searchBeanByQuery responseList.size(): " + responseList.size());
		return responseList;
	}
	
	public List<SHPRBean> searchBByQuery(String text, List<String> selectedList) throws Exception {
		
		QueryBuilder queryBuilder = getQueryBuilder(text); 
		SearchResponse response = beanDao.searchBeanByQuery(queryBuilder,selectedList);
		
		logger.info("Method:searchBByQuery para exportar al csv "+ response.getHits().totalHits());
		return SearchMapperUtil.getObjects(response, SHPRBean.class);
	}
	
	public List<SHPRBean> searchWithoutDeselected(String text, List<String> deselectedList) throws Exception {
		QueryBuilder queryBuilder = getQueryBuilder(text); 
		List<SHPRBean> responseList = beanDao.searchWithoutDeselected(queryBuilder,deselectedList);
		
		logger.info("searchWithoutDeselected para exportar al csv "+ responseList.size());
		return responseList;
	}

	private QueryBuilder getQueryBuilder(String text) {
		QueryBuilder queryBuilder = QueryBuilders.queryStringQuery("*" + text + "*");
		return queryBuilder;
	}
	
	public List<SIVEPDatoBean> searchBeanByQuery(String text) throws Exception {
		QueryBuilder queryBuilder = getQueryBuilder(text);
		List<SIVEPDatoBean> responseList = beanDao.searchScrollBeanByQuery(queryBuilder);
		
		logger.info("Method:searchBeanByQuery responseBean.size(): " + responseList.size());
		return responseList;
	}
	
	public List<SIVEPDatoBean> searchBeanByQuery(String text, Integer start,Integer finish) throws Exception {
		logger.info("Entrando al Method:searchBeanByQuery ");
		QueryBuilder queryBuilder = getQueryBuilder(text);
		
		int limit = getLimit(text, start, finish);
		
		//List<SIVEPDatoBean> responseList = beanDao.searchScrollBeanByQuery(queryBuilder);
		List<SIVEPDatoBean> responseList = beanDao.searchPaginationBeanByQuery(queryBuilder,start,limit);
		logger.info("Method:searchBeanByQuery responseBean.size(): " + responseList.size());
		return responseList;
	}

	private int getLimit(String text, Integer start, Integer finish) {
		Long counter = countQuery(text);
		logger.info("Method:getLimit counter: " + counter);
		int endSize = finish < counter.intValue() ? finish : counter.intValue();
		int fparam = start + endSize;
		int limit = fparam < counter.intValue()? fparam:counter.intValue();
		return limit;
	}

	public Long countQuery(String text) {
		// TODO Auto-generated method stub
		return beanDao.countQuery(getQueryBuilder(text));
	}

	public List<SIVEPDatoBean> searchBeanByQuery(String text, List<String> selectedList) throws Exception {
		QueryBuilder queryBuilder = getQueryBuilder(text); 
		String filter = "NUM_SERIE";
		SearchResponse response = beanDao.searchBeanByQuery(queryBuilder,selectedList, filter);
		
		logger.info("Method:searchBByQuery para exportar al csv "+ response.getHits().totalHits());
		return SearchMapperUtil.getObjects(response, SIVEPDatoBean.class);
	}

	public List<SIVEPDatoBean> searchForDeselected(String text, List<String> deselectedList) throws Exception {
		QueryBuilder queryBuilder = getQueryBuilder(text); 
		String filter = "NUM_SERIE";
		List<SIVEPDatoBean> responseList = beanDao.searchForDeselected(queryBuilder,deselectedList, filter);
		
		logger.info("searchWithoutDeselected para exportar al csv "+ responseList.size());
		return responseList;
	}
	
	
}
