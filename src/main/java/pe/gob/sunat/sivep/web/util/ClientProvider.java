package pe.gob.sunat.sivep.web.util;


import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.lang3.StringUtils;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

public class ClientProvider {

	
	private static final int ES_PORT = 9300;
	
	private static final String ELASTIC_HOST = "localhost";
	private static final String CLUSTER_NAME = "elasticsearch";
	public static final String INDEX_NAME = "shakespeare";
	
//	private static final String ELASTIC_HOST = "192.168.56.43";
//	private static final String CLUSTER_NAME = "clusterelasticsivep";
	//public static final String INDEX_NAME = "sivepdm4";
		
	private static ClientProvider instance = null;
    private static Object lock  = new Object();
    
    private Client client;
    private Settings settings;

    public static final int SCROLL_NUMBER_RECORD = 1000;
    public static final int TOTAL_NUMBER_RECORD = 10000;
    
	
    public static ClientProvider instance(){
        
        if(instance == null) { 
            synchronized (lock) {
                if(null == instance){
                    instance = new ClientProvider();
                }
            }
        }
        return instance;
    }
    
    public Settings settings(String clusterName, String host, int port ){
    	settings = ImmutableSettings.settingsBuilder()
				.put("cluster.name", StringUtils.isBlank(clusterName) ? CLUSTER_NAME : clusterName)
				//.put("transport.tcp.port",port).build();
				.put("index.search.slowlog.threshold.query.warn","10s")
				.put("index.search.slowlog.threshold.query.info","5s")
				.put("index.search.slowlog.threshold.query.debug","2s")
				.put("index.search.slowlog.threshold.query.trace","500ms")
				.put("http.port",port).build();
    	
				//.put("node.name", NODE_NAME).build();
        
    	return settings;
    }
    
    public Client getClient(){
    	settings(CLUSTER_NAME, ELASTIC_HOST, ES_PORT);
    	client = new TransportClient(settings).addTransportAddress(new InetSocketTransportAddress(ELASTIC_HOST, ES_PORT));
        return client;
    }
    
    
}
