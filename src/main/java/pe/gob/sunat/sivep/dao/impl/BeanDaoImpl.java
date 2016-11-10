package pe.gob.sunat.sivep.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.QueryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import pe.gob.sunat.sivep.dao.BeanDao;
import pe.gob.sunat.sivep.model.SHPRBean;
import pe.gob.sunat.sivep.model.SIVEPDatoBean;
import pe.gob.sunat.sivep.web.util.ClientProvider;
import pe.gob.sunat.sivep.web.util.SearchMapperUtil;

@Repository("beanDao")
public class BeanDaoImpl extends GenericDaoImpl implements BeanDao{

	private static final Logger logger = LoggerFactory.getLogger(BeanDaoImpl.class);
	//private final String typeName = "sunattest4";
	private final String typeName = "act";
	
	public BeanDaoImpl() {
		elasticSearchClient = ClientProvider.instance().getClient();
	}
	
	@Override
	public String getTypeName() {
		return typeName;
	}

	@Override
	public String getIndexName() {
		return ClientProvider.INDEX_NAME;
	}
	
	public SearchResponse searchBeanByQuery(QueryBuilder query) {
		return super.genericSearchByQuery(query);
	}
	
	public SearchResponse searchBeanByQuery(QueryBuilder query, List<String> lista){
		return super.genericSearchByQueryAndFilter(query,lista);
	}
	
	public List<SHPRBean> searchWithoutDeselected(QueryBuilder query, List<String> deselectedList){
		//return super.genericSearchByQueryAndNotFilter(query, deselectedList);
		SearchResponse scrollResp = genericSearchByQueryAndNotFilter(query, deselectedList);
		long init =new Date().getTime();
		logger.info("DAO: searchWithoutDeselected Counter of the hits: " + scrollResp.getHits().getTotalHits());
		List<SHPRBean> listaBean = new ArrayList<SHPRBean>();
		try {
			while (true) {
					listaBean.addAll(SearchMapperUtil.getObjects(scrollResp, SHPRBean.class));
				
				logger.info("Nro de registro de la lista " + listaBean.size());
				scrollResp = elasticSearchClient
						.prepareSearchScroll(scrollResp.getScrollId())
						.setScroll(TimeValue.timeValueMinutes(1))
						.execute().actionGet();
				
				logger.info("scrollResp.getHits().getHits().length " + scrollResp.getHits().getHits().length);
			    if (scrollResp.getHits().getHits().length == 0) {
			        break;
			    }
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long finish =new Date().getTime();
		logger.info("total of the delay is: " + (finish- init));
		return listaBean;
		
	}
	
	public List<SHPRBean> searchScrollBByQuery(QueryBuilder query) {
		
		SearchResponse scrollResp = genericSearchScrollByQuery(query);
		long init =new Date().getTime();
		logger.info("DAO: searchScrollBeanByQuery Counter of the hits: " + scrollResp.getHits().getTotalHits());
		List<SHPRBean> listaBean = new ArrayList<SHPRBean>();
		try {
			while (true) {
					listaBean.addAll(SearchMapperUtil.getObjects(scrollResp, SHPRBean.class));
				
				logger.info("Nro de registro de la lista " + listaBean.size());
				scrollResp = elasticSearchClient
						.prepareSearchScroll(scrollResp.getScrollId())
						.setScroll(TimeValue.timeValueMinutes(1))
						.execute().actionGet();
				
				logger.info("scrollResp.getHits().getHits().length " + scrollResp.getHits().getHits().length);
			    if (scrollResp.getHits().getHits().length == 0) {
			        break;
			    }
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long finish =new Date().getTime();
		logger.info("total of the delay is: " + (finish- init));
		return listaBean;
	}
	
	
	
	public List<SHPRBean> searchPaginationBByQuery(QueryBuilder query, Integer start, Integer finish) {
		List<SHPRBean> listaBean = new ArrayList<SHPRBean>();

		try {
			SearchResponse response = elasticSearchClient.prepareSearch(getIndexName()).
					setTypes(getTypeName())
					.setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
					.setQuery(query)
					.setFrom(start)
					.setSize(finish)
					.setExplain(true)
					.execute().actionGet();

			listaBean.addAll(SearchMapperUtil.getObjects(response, SHPRBean.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaBean;
	}

public List<SIVEPDatoBean> searchScrollBeanByQuery(QueryBuilder query) {
		
		SearchResponse scrollResp = genericSearchScrollByQuery(query);
		long init =new Date().getTime();
		logger.info("DAO: searchScrollBeanByQuery Counter of the hits: " + scrollResp.getHits().getTotalHits());
		List<SIVEPDatoBean> listaBean = new ArrayList<SIVEPDatoBean>();
		try {
			while (true) {
					listaBean.addAll(SearchMapperUtil.getObjects(scrollResp, SIVEPDatoBean.class));
				
				logger.info("Nro de registro de la lista " + listaBean.size());
				scrollResp = elasticSearchClient
						.prepareSearchScroll(scrollResp.getScrollId())
						.setScroll(new TimeValue(3000))
						.execute().actionGet();
				
				logger.info("scrollResp.getHits().getHits().length " + scrollResp.getHits().getHits().length);
			    if (scrollResp.getHits().getHits().length == 0 || listaBean.size()== ClientProvider.TOTAL_NUMBER_RECORD) {
			        break;
			    }
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long finish =new Date().getTime();
		logger.info("total of the delay is: " + (finish- init));
		return listaBean;
	}


	public List<SIVEPDatoBean> searchPaginationBeanByQuery(QueryBuilder query, Integer start, Integer finish) {
		List<SIVEPDatoBean> listaBean = new ArrayList<SIVEPDatoBean>();
				
		try {
			SearchResponse response = elasticSearchClient
					.prepareSearch(getIndexName())
					.setTypes(getTypeName())
					.setQuery(query)
					.setFrom(start)
					.setSize(finish)
					.execute().actionGet();
			
			
			listaBean.addAll(SearchMapperUtil.getObjects(response, SIVEPDatoBean.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
	return listaBean;
}

	public Long countQuery(QueryBuilder query) {
		return elasticSearchClient.prepareCount(getIndexName())
				.setTypes(typeName)
		        .setQuery(query)
		        .execute()
		        .actionGet().getCount();
	}

	public SearchResponse searchBeanByQuery(QueryBuilder query, List<String> lista, String filter) {
		// TODO Auto-generated method stub
		return super.genericSearchByQueryAndFilter(query,lista, filter);
	}

	public List<SIVEPDatoBean> searchForDeselected(QueryBuilder query, List<String> deselectedList, String filter) {
		SearchResponse scrollResp = genericSearchByQueryAndNotFilter(query, deselectedList, filter);
		long init =new Date().getTime();
		logger.info("DAO: searchWithoutDeselected Counter of the hits: " + scrollResp.getHits().getTotalHits());
		List<SIVEPDatoBean> listaBean = new ArrayList<SIVEPDatoBean>();
		try {
			while (true) {
					listaBean.addAll(SearchMapperUtil.getObjects(scrollResp, SIVEPDatoBean.class));
				
				logger.info("Nro de registro de la lista " + listaBean.size());
				scrollResp = elasticSearchClient
						.prepareSearchScroll(scrollResp.getScrollId())
						.setScroll(TimeValue.timeValueMinutes(1))
						.execute().actionGet();
				
				logger.info("scrollResp.getHits().getHits().length " + scrollResp.getHits().getHits().length);
			    if (scrollResp.getHits().getHits().length == 0) {
			        break;
			    }
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		long finish =new Date().getTime();
		logger.info("total of the delay is: " + (finish- init));
		return listaBean;
	}

	
	
}
