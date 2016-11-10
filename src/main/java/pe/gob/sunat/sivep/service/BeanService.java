package pe.gob.sunat.sivep.service;

import java.util.List;

import pe.gob.sunat.sivep.model.SHPRBean;
import pe.gob.sunat.sivep.model.SIVEPDatoBean;

public interface BeanService {

	public List<SHPRBean> searchBByQuery(String text) throws Exception;
	public List<SHPRBean> searchBByQuery(String text, List<String> selectedList) throws Exception;
	public List<SHPRBean> searchWithoutDeselected(String text, List<String> deselectedList) throws Exception;
	
	public  List<SHPRBean> searchBByQuery(String text, Integer start,Integer finish) throws Exception ;
	
	public List<SIVEPDatoBean> searchBeanByQuery(String text) throws Exception;
	public  List<SIVEPDatoBean> searchBeanByQuery(String text, Integer start,Integer finish) throws Exception ;
	public Long countQuery(String text);
	public List<SIVEPDatoBean> searchBeanByQuery(String text, List<String> selectedList) throws Exception;
	public List<SIVEPDatoBean> searchForDeselected(String text, List<String> deselectedList) throws Exception;
	
}
