package pe.gob.sunat.sivep.dao;

import java.util.List;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.QueryBuilder;

import pe.gob.sunat.sivep.model.SHPRBean;
import pe.gob.sunat.sivep.model.SIVEPDatoBean;

public interface BeanDao {

	SearchResponse searchBeanByQuery(QueryBuilder query);
	SearchResponse searchBeanByQuery(QueryBuilder query, List<String> lista);
	List<SHPRBean> searchWithoutDeselected(QueryBuilder query, List<String> lista);
	List<SHPRBean> searchScrollBByQuery(QueryBuilder query);
	List<SHPRBean> searchPaginationBByQuery(QueryBuilder query, Integer start,Integer finish);
	List<SIVEPDatoBean> searchScrollBeanByQuery(QueryBuilder query);
	List<SIVEPDatoBean> searchPaginationBeanByQuery(QueryBuilder query, Integer start,Integer finish);
	Long countQuery(QueryBuilder query);
	SearchResponse searchBeanByQuery(QueryBuilder query, List<String> lista,String filter);
	List<SIVEPDatoBean> searchForDeselected(QueryBuilder query, List<String> lista, String filter);
}
