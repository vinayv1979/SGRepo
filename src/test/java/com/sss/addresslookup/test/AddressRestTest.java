package com.sss.addresslookup.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.sss.addresslookup.search.controller.PostCodeLookupController;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PostCodeLookupController.class })
@WebAppConfiguration
public class AddressRestTest {
	
	private MockMvc mockMvc;
	
	@Autowired
    private WebApplicationContext wac;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }
	
    @Test
    public void testCreationOfANewProjectSucceeds() throws Exception {
    	 // build your expected results here 
        String url = "/1";
       
        ResultActions result=mockMvc.perform(get("/addresslookup/"));
                
        
        System.out.println(result);

    

     

    }
	
	

}
