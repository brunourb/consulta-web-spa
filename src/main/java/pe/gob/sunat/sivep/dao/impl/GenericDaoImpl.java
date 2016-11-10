package pe.gob.sunat.sivep.dao.impl;

import java.util.List;

import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.FilterBuilders;
import org.elasticsearch.index.query.FilteredQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pe.gob.sunat.sivep.web.util.ClientProvider;

public abstract class GenericDaoImpl {

	private static final Logger logger = LoggerFactory.getLogger(GenericDaoImpl.class);
	protected Client elasticSearchClient;
	protected abstract String getTypeName();
	protected abstract String getIndexName();

	public SearchResponse genericSearchByQuery(final QueryBuilder query) {

		SearchResponse response = elasticSearchClient.prepareSearch(getIndexName()).setTypes(getTypeName())
				.setQuery(query).setFrom(0).setSize(ClientProvider.TOTAL_NUMBER_RECORD).execute().actionGet();

		return response;
	}
	
	public SearchResponse genericSearchByQueryAndFilter(final QueryBuilder query, List<String> selecedtList) {

		SearchRequestBuilder searchRequestBuilder = elasticSearchClient.prepareSearch(getIndexName()).setTypes(getTypeName())
				.setQuery(query)
				.setPostFilter(FilterBuilders.termsFilter("line_number", selecedtList));
		
				SearchResponse response = searchRequestBuilder.execute().actionGet();
		logger.info("genericSearchByQueryAndFilter Query using Java Client:\n " + searchRequestBuilder.internalBuilder());
		return response;
	}
	
	public SearchResponse genericSearchByQueryAndNotFilter(final QueryBuilder query, List<String> deselectedList) {
		
		FilteredQueryBuilder builder = 
				 QueryBuilders.filteredQuery(query,
						 FilterBuilders.boolFilter().mustNot(
								 FilterBuilders.inFilter("line_number",deselectedList.toArray(new String[deselectedList.size()]))));
		
		SearchRequestBuilder searchRequestBuilder = elasticSearchClient.prepareSearch(getIndexName()).setTypes(getTypeName())
				.setSearchType(SearchType.SCAN).setScroll(TimeValue.timeValueMinutes(1))
				.setQuery(builder).setSize(ClientProvider.SCROLL_NUMBER_RECORD);
				
		SearchResponse response =	searchRequestBuilder.execute().actionGet();
		
		logger.info("GenericDAO: genericSearchByQueryAndNotFilter ::::  total hits: " + response.getHits().getTotalHits());
		logger.info("ElasticSearch Query using Java Client API:\n" + searchRequestBuilder.internalBuilder());
		
		return response;
	}
	
	
	public SearchResponse genericSearchScrollByQuery(final QueryBuilder query) {

		SearchResponse response = elasticSearchClient
				.prepareSearch(getIndexName())
				.setSearchType(SearchType.SCAN)
				.setScroll(TimeValue.timeValueMinutes(1))
				.setTypes(getTypeName())
				.setQuery(query)
				.setSize(ClientProvider.SCROLL_NUMBER_RECORD)
				.execute().actionGet();

		return response;
	}
	
	
	public SearchResponse genericSearchByQueryAndFilter(final QueryBuilder query, List<String> selecedtList, String filter) {

		SearchRequestBuilder searchRequestBuilder = elasticSearchClient.prepareSearch(getIndexName()).setTypes(getTypeName())
				.setQuery(query)
				.setPostFilter(FilterBuilders.termsFilter(filter, selecedtList));
		
				SearchResponse response = searchRequestBuilder.execute().actionGet();
		logger.info("genericSearchByQueryAndFilter Query using Java Client:\n " + searchRequestBuilder.internalBuilder());
		return response;
	}
	
	public SearchResponse genericSearchByQueryAndNotFilter(final QueryBuilder query, List<String> deselectedList,String filter) {
		
		FilteredQueryBuilder builder = 
				 QueryBuilders.filteredQuery(query,
						 FilterBuilders.boolFilter().mustNot(
								 FilterBuilders.inFilter(filter,deselectedList.toArray(new String[deselectedList.size()]))));
		
		SearchRequestBuilder searchRequestBuilder = elasticSearchClient.prepareSearch(getIndexName()).setTypes(getTypeName())
				.setSearchType(SearchType.SCAN).setScroll(TimeValue.timeValueMinutes(1))
				.setQuery(builder).setSize(ClientProvider.SCROLL_NUMBER_RECORD);
				
		SearchResponse response =	searchRequestBuilder.execute().actionGet();
		
		logger.info("GenericDAO: genericSearchByQueryAndNotFilter ::::  total hits: " + response.getHits().getTotalHits());
		logger.info("ElasticSearch Query using Java Client API:\n" + searchRequestBuilder.internalBuilder());
		
		return response;
	}

}
