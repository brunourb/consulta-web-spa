package pe.gob.sunat.sivep.dao;

import java.util.List;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.QueryBuilder;

import pe.gob.sunat.sivep.model.SHPRBean;
import pe.gob.sunat.sivep.model.SIVEPDatoBean;

public interface BeanDao {

	public SearchResponse searchBeanByQuery(QueryBuilder query);
	public SearchResponse searchBeanByQuery(QueryBuilder query, List<String> lista);
	public List<SHPRBean> searchWithoutDeselected(QueryBuilder query, List<String> lista);
	public List<SHPRBean> searchScrollBByQuery(QueryBuilder query);
	public List<SHPRBean> searchPaginationBByQuery(QueryBuilder query, Integer start,Integer finish);
	public List<SIVEPDatoBean> searchScrollBeanByQuery(QueryBuilder query);
	public List<SIVEPDatoBean> searchPaginationBeanByQuery(QueryBuilder query, Integer start,Integer finish);
	public Long countQuery(QueryBuilder query);
	public SearchResponse searchBeanByQuery(QueryBuilder query, List<String> lista,String filter);
	public List<SIVEPDatoBean> searchForDeselected(QueryBuilder query, List<String> lista, String filter);
}
