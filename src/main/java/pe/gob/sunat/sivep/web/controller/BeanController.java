package pe.gob.sunat.sivep.web.controller;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectWriter;
//import com.fasterxml.jackson.dataformat.csv.CsvMapper;
//import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import pe.gob.sunat.sivep.model.SHPRBean;
import pe.gob.sunat.sivep.model.SIVEPDatoBean;
import pe.gob.sunat.sivep.service.BeanService;
import pe.gob.sunat.sivep.web.util.DataResponseWrap;

@Controller
@RequestMapping(value = "/data")
public class BeanController {

	private static final Logger logger = LoggerFactory.getLogger(BeanController.class);
	private BeanService beanService;

	@Autowired
	public void setBeanService(BeanService beanService) {
		this.beanService = beanService;
	}

	@RequestMapping(value = "/sivepBeanList.htm", method = { RequestMethod.GET })
	public ModelAndView paginationList(){
		return new ModelAndView("paginationList");
	}
	
	//@RequestMapping(value = "/sivepBeanList.htm", method = { RequestMethod.GET })
	//public ModelAndView prepareDocumentList(){
	//	return new ModelAndView("listadoPaginadoSivep");
	//}
	
	
	@RequestMapping(value = "/sivepBeanSearch", method = { RequestMethod.GET })
	@ResponseBody
	public DataResponseWrap sivepBeanSearch(@RequestParam("text") String text,
										@RequestParam("page") String numberPage,
										@RequestParam("start") Integer start,
										@RequestParam("finish") Integer finish){
		
		logger.info("incio del controller BeanController..."+text);
		 try {
			 List<SIVEPDatoBean> listaBean = beanService.searchBeanByQuery(text, start, finish);
			 Long listaBeanCount = beanService.countQuery(text);
			 
			 DataResponseWrap dataResponseWrap = new DataResponseWrap(listaBean,listaBeanCount);
			
			 return  dataResponseWrap;
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return null;
    }
	
	@RequestMapping(value = "/speechBeanList", method = { RequestMethod.GET })
	@ResponseBody
	public DataResponseWrap speechBeanList(@RequestParam("text") String text,
											@RequestParam("page") String numberPage,
											@RequestParam("start") Integer start,
											@RequestParam("finish") Integer finish){
		
		logger.info("incio del contro speechBeanController..."+text);
		 try {
			 List<SHPRBean> listaBean = beanService.searchBByQuery(text, start, finish);
			 Long listaBeanCount = beanService.countQuery(text);
			 DataResponseWrap dataResponseWrap = new DataResponseWrap(listaBean,listaBeanCount);
			
			 return  dataResponseWrap;
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return null;
    }
	
	
/*	@RequestMapping(value = "/exportCSV")
	public ModelAndView exportCSV(@RequestParam("text") String text,HttpServletResponse response) throws Exception {
		
		logger.info("incio del controller downloadCSV..."+text);
		List<SIVEPDatoBean> listaBean = beanService.searchBeanByQuery(text);

		getCSVResponse(response, listaBean);
        return null;
	}*/
	
//	@RequestMapping(value = "/downloadCSV")
//	public ModelAndView downloadCSV(@RequestParam("text") String text, HttpServletResponse response) throws Exception {
//		
//		logger.info("incio del controller downloadCSV para SHPRBean..."+text);
//		List<SHPRBean> listaBean = beanService.searchBByQuery(text);
//
//		getCSVResponse(response, listaBean);
//        return null;
//	}

//	@RequestMapping(value = "/selectedToExportCSV")
//	public ModelAndView selectedToExportCSV(@RequestParam("text") String text, HttpServletResponse response, @RequestParam("seleccionados") List<String> selectedList) throws Exception {
//
//		logger.info("incio del controller downloadCSV para SHPRBean..."+text);
//		logger.info("parametro de la lista..." + selectedList);
//
//		List<SIVEPDatoBean> listaBean = beanService.searchBeanByQuery(text, selectedList);
//
//		 getCSVResponse(response, listaBean);
//        return null;
//	}
//
//	@RequestMapping(value = "/deselectedToExportCSV")
//	public ModelAndView deselectedToExportCSV(@RequestParam("text") String text, HttpServletResponse response, @RequestParam("desmarcados") List<String> deselectedList) throws Exception {
//
//		logger.info("incio del controller deselectedToExportCSV para SHPRBean..."+text);
//		logger.info("parametro de la lista..." + deselectedList);
//
//		List<SIVEPDatoBean> listaBean = beanService.searchForDeselected(text, deselectedList);
//
//		logger.info("deselectedToExportCSV..listaBean size   . "+listaBean.size());
//		 getCSVResponse(response, listaBean);
//        return null;
//	}
///*
//	private void getCSVResponse(HttpServletResponse response, final List<SIVEPDatoBean> listaBean)
//			throws UnsupportedEncodingException, IOException, JsonGenerationException, JsonMappingException {
//		// create mapper and schema
//        CsvMapper mapper = new CsvMapper();
//        CsvSchema schema = mapper.schemaFor(SIVEPDatoBean.class).withHeader();
//        schema = schema.withColumnSeparator(',');
//
//
//        logger.info("incio del output writer...");
//        // output writer
//        ObjectWriter myObjectWriter = mapper.writer(schema);
//        File tempFile = new File("fileSHPRBean.csv");
//
//        response.setContentType("text/csv;charset=utf-8");
//		response.setHeader("Content-disposition", "attachment;filename=" + tempFile);
//
//
//        OutputStreamWriter writerOutputStream = new OutputStreamWriter(response.getOutputStream(), "UTF-8");
//        myObjectWriter.writeValue(writerOutputStream, listaBean);
//
//        response.flushBuffer();
//	}
//	*/
	/**
	 * 
	 * @RequestMapping(value = "/downloadCSV")
	public ModelAndView downloadCSV(@RequestParam("text") String text, HttpServletResponse response) throws Exception {
		
		logger.info("incio del controller downloadCSV para SHPRBean..."+text);
		List<SHPRBean> listaBean = beanService.searchBByQuery(text);

		getCSVResponse(response, listaBean);
        return null;
	}

	@RequestMapping(value = "/selectedToExportCSV")
	public ModelAndView selectedToExportCSV(@RequestParam("text") String text, HttpServletResponse response, @RequestParam("seleccionados") List<String> selectedList) throws Exception {
		
		logger.info("incio del controller downloadCSV para SHPRBean..."+text);
		logger.info("parametro de la lista..." + selectedList);
			
		List<SHPRBean> listaBean = beanService.searchBByQuery(text, selectedList);

		 getCSVResponse(response, listaBean);
        return null;
	}
	
	@RequestMapping(value = "/deselectedToExportCSV")
	public ModelAndView deselectedToExportCSV(@RequestParam("text") String text, HttpServletResponse response, @RequestParam("desmarcados") List<String> deselectedList) throws Exception {
		
		logger.info("incio del controller deselectedToExportCSV para SHPRBean..."+text);
		logger.info("parametro de la lista..." + deselectedList);

		List<SHPRBean> listaBean = beanService.searchWithoutDeselected(text, deselectedList);

		logger.info("deselectedToExportCSV..listaBean size   . "+listaBean.size());
		 getCSVResponse(response, listaBean);
        return null;
	}
	
	private void getCSVResponse(HttpServletResponse response, final List<SHPRBean> listaBean)
			throws UnsupportedEncodingException, IOException, JsonGenerationException, JsonMappingException {
		// create mapper and schema
        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = mapper.schemaFor(SHPRBean.class).withHeader();
        schema = schema.withColumnSeparator(',');
        
        
        logger.info("incio del output writer...");
        // output writer
        ObjectWriter myObjectWriter = mapper.writer(schema);
        File tempFile = new File("fileSHPRBean.csv");
        
        response.setContentType("text/csv;charset=utf-8");
		response.setHeader("Content-disposition", "attachment;filename=" + tempFile);
		
        
        OutputStreamWriter writerOutputStream = new OutputStreamWriter(response.getOutputStream(), "UTF-8");
        myObjectWriter.writeValue(writerOutputStream, listaBean);
        
        response.flushBuffer();
	}	
	 */
}
