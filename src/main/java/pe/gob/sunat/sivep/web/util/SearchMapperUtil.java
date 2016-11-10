package pe.gob.sunat.sivep.web.util;

import java.util.ArrayList;
import java.util.List;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.search.SearchHit;

import com.fasterxml.jackson.databind.ObjectMapper;

public class SearchMapperUtil {
	private static final ObjectMapper MAPPER = new ObjectMapper();

	public static <T> List<T> getObjects(SearchResponse response, Class<T> valueType) throws Exception {
		List<T> res = new ArrayList<T>();
		for (SearchHit hit : response.getHits()) {
			res.add(getObject(hit, valueType));
		}
		return res;
	}

	public static <T> T getObject(SearchResponse response, Class<T> valueType) throws Exception {
		for (SearchHit hit : response.getHits()) {
			return getObject(hit, valueType);
		}
		return null;
	}

	public static <T> T getObject(SearchHit hit, Class<T> valueType) throws Exception {
		T res = MAPPER.readValue(hit.getSourceAsString(), valueType);
		return res;
	}
}
