package pe.gob.sunat.webspa.elasticTest;

import static org.elasticsearch.index.query.QueryBuilders.matchAllQuery;
import static org.elasticsearch.node.NodeBuilder.nodeBuilder;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.elasticsearch.action.admin.indices.mapping.put.PutMappingResponse;
import org.elasticsearch.action.count.CountResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.lang3.StringUtils;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.node.Node;
import org.elasticsearch.search.SearchHit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pe.gob.sunat.sivep.web.util.ClientProvider;
public class ElasticTest implements Serializable{

	private static final String TYPE_NAME = "article";
	static final String indexName = "ejfcindex";
	private static final Logger logger = LoggerFactory.getLogger(ElasticTest.class);
	private static Client  client;

	@SuppressWarnings("resource")
	public static void connect(final String clusterName, final String hostname, final int port) {
		// destroy();
		final Settings settings = ImmutableSettings.settingsBuilder()
				.put("cluster.name", StringUtils.isBlank(clusterName) ? "elasticsearch" : clusterName)
				.put("http.port",port).build();
		
		//node = nodeBuilder().local(true).data(true).settings(settings).node();
		//client = new TransportClient(settings).addTransportAddress(new InetSocketTransportAddress(hostname, port));
		//client = node.client();
		client = new TransportClient(settings).addTransportAddress(new InetSocketTransportAddress(hostname, port));
	
	}
	
	public static void main(String[] args) throws Exception{
		
		connect("elasticsearch", "localhost",9300);
		String sourcejson = readJsonDefn("src/main/resources/mapping/articulosJSONFile.json");
		
		//final PutMappingRequestBuilder builder = client.admin().indices().preparePutMapping(FileUtil.readText("mapping/articulosJSONFile.json"));
		
//		PutMappingResponse putMappingResponse = client.admin().indices()
//                .preparePutMapping(indexName)
//                .setType(TYPE_NAME)
//                .setSource(sourcejson)
//                .execute().actionGet();    
//		
//		  if (putMappingResponse.isAcknowledged()) {
//              logger.info("Created " + indexName + "/" + TYPE_NAME + " mapping.");
//          } else {
//              logger.warn("Failed to create " + indexName + "/" + TYPE_NAME + " mapping.");
//          }
		  
	}
	
	public static String readJsonDefn(String url) throws Exception {
        //implement it the way you like 
        StringBuffer bufferJSON = new StringBuffer();

        FileInputStream input = new FileInputStream(new File(url).getAbsolutePath());
        DataInputStream inputStream = new DataInputStream(input);
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

        String line;

        while ((line = br.readLine()) != null) {
                       bufferJSON.append(line);
                       
                       System.out.println("line::::::: " + line);
        }
        br.close();
        return bufferJSON.toString();
 }
	

//	public static void main3(String[] args) {
//
//		connect("elasticsearch", "localhost",9300);
//		
//		SearchResponse response = client
//				.prepareSearch(indexName)
//				.setTypes(TYPE_NAME)
//				.setQuery(matchAllQuery())
//				.execute().actionGet();
//		
//		System.out.println("searchReponse ::: " + response);
//		
//		List<Article> articleList = new ArrayList<Article>();
//		Article temporary = null;
//		String tags = null;
//
//		if (response != null) {
//			for (SearchHit hit : response.getHits()) {
//
//				try {
//
//					tags = hit.getSource().get("tags").toString();
//					temporary = new Article(Long.parseLong(hit.getId()),
//							hit.getSource().get("title").toString(), hit.getSource().get("content").toString(),
//							new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
//									.parse(hit.getSource().get("postDate").toString()),
//							hit.getSource().get("author").toString(), tags);
//				} catch (ParseException e) {
//					e.printStackTrace();
//				}
//				articleList.add(temporary);
//			}
//		}
//
//		for (Article articulo : articleList) {
//			System.out.println("(Articulo): " + articulo);
//		}
//		
//	}

	public static void main2(String[] args) {

		Node node = nodeBuilder().node();// nodeBuilder().clusterName("clusterone").node();
		Client client = node.client();

		

		CountResponse countResponse = ClientProvider.instance().getClient()
				// CountResponse countResponse= client
				.prepareCount(indexName).setTypes(TYPE_NAME)
				// .setQuery(termQuery("_type", "article"))
				.execute().actionGet();

		System.out.println("countResponse.getSuccessfulShards : " + countResponse.getSuccessfulShards());
		System.out.println("countResponse.getTotalShards : " + countResponse.getTotalShards());

		System.out.println("countResponse.count : " + countResponse.getCount());

		SearchResponse response = ClientProvider.instance().getClient()
				.prepareSearch(indexName)
				.setTypes(TYPE_NAME)
				.setQuery(matchAllQuery())
				.execute().actionGet();
//		List<Article> articleList = new ArrayList<Article>();
//		Article temporary = null;
//		String tags = null;
//
//		if (response != null) {
//			for (SearchHit hit : response.getHits()) {
//
//				try {
//
//					tags = hit.getSource().get("tags").toString();
//					temporary = new Article(Long.parseLong(hit.getSource().get("id").toString()),
//							hit.getSource().get("title").toString(), hit.getSource().get("content").toString(),
//							new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
//									.parse(hit.getSource().get("postDate").toString()),
//							hit.getSource().get("author").toString(), tags);
//				} catch (ParseException e) {
//					e.printStackTrace();
//				}
//				articleList.add(temporary);
//			}
//		}
//
//		for (Article articulo : articleList) {
//			System.out.println("(Articulo): " + articulo);
//		}

	}

	public static Map<String, Object> putJsonDocument(String title, String content, Date postDate, String[] tags,
			String author) {

		Map<String, Object> jsonDocument = new HashMap<String, Object>();

		jsonDocument.put("title", title);
		jsonDocument.put("content", content);
		jsonDocument.put("postDate", postDate);
		jsonDocument.put("tags", tags);
		jsonDocument.put("author", author);

		return jsonDocument;
	}

	public static void getDocument(Client client, String index, String type, String id) {

		GetResponse getResponse = client.prepareGet(index, type, id).execute().actionGet();
		Map<String, Object> source = getResponse.getSource();

		System.out.println("------------------------------");
		System.out.println("Index: " + getResponse.getIndex());
		System.out.println("Type: " + getResponse.getType());
		System.out.println("Id: " + getResponse.getId());
		System.out.println("Version: " + getResponse.getVersion());
		System.out.println(source);
		System.out.println("------------------------------");

	}
}
