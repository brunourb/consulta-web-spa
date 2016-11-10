package pe.gob.sunat.webspa.elasticTest;

import java.io.IOException;

import org.elasticsearch.common.inject.Inject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import pe.gob.sunat.sivep.model.SHPRBean;
import pe.gob.sunat.sivep.web.controller.BeanController;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
//@ContextConfiguration({"applicationContext.xml","dispatcher-servlet.xml"})
public class ControllerTestUnit {

//	 @Inject
//	    private ApplicationContext applicationContext;
//
//	    private MockHttpServletRequest request;
//	    private MockHttpServletResponse response;
//	    private HandlerAdapter handlerAdapter;
//	    private BeanController controller;
//
//	    @Before
//	    public void setUp() {
//	       request = new MockHttpServletRequest();
//	       response = new MockHttpServletResponse();
//	     //  handlerAdapter = applicationContext.getBean(HandlerAdapter.class);
//	       // I could get the controller from the context here
//	       controller = new BeanController();
//	    }
//
//	    //@Test
//	    public void testDoSomething() throws Exception {
//	       request.setRequestURI("/test.html");
//	       final ModelAndView mav = handlerAdapter.handle(request, response, 
//	           controller);
//	       //Assert.assertNotNull(mav, "view");
//	       // assert something
//	    }
//	    
//	    @Test
//	    public void whenDeserializingUsingJsonSetter_thenCorrect()
//	      throws JsonProcessingException, IOException {
//	        String json = "{line_id:1,play_name:My bean}";
//	     
//	        SHPRBean bean = 
//	          new ObjectMapper().reader(SHPRBean.class).readValue(json);
//	        Assert.assertEquals("My bean", bean.getPlay_name());
//	    }
	  
}
