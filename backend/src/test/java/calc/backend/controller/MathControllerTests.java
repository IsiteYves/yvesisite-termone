package calc.backend.controller;

import calc.backend.impl.MathOperatorImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MathController.class)
public class MathControllerTests {
    @Mock
    private MathOperatorImpl mathOperatorImplMock;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void checkAddition_success() throws Exception {
        double returnVal = 7;
        when(mathOperatorImplMock.doMath(3, 4, "+")).thenReturn(returnVal);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post("/")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc
                .perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"calcResponse\":7}"))
                .andReturn();
    }

    @Test
    public void checkSubtraction_success() throws Exception {
        double returnVal = 8;
        when(mathOperatorImplMock.doMath(13, 5, "-")).thenReturn(returnVal);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post("/")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc
                .perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"calcResponse\":"+returnVal+"}"))
                .andReturn();
    }

    @Test
    public void checkDivision_success() throws Exception {
        double returnVal = 4;
        when(mathOperatorImplMock.doMath(28, 7, "/")).thenReturn(returnVal);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post("/")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc
                .perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"calcResponse\":"+returnVal+"}"))
                .andReturn();
    }

    @Test
    public void checkMultiplication_success() throws Exception {
        double returnVal = 36;
        when(mathOperatorImplMock.doMath(12,3, "*")).thenReturn(returnVal);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post("/")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc
                .perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"calcResponse\":"+returnVal+"}"))
                .andReturn();
    }

    @Test
    public void checkPowering_success() throws Exception {
        double returnVal = 0.5;
        when(mathOperatorImplMock.doMath(2, -1, "**")).thenReturn(returnVal);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post("/")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc
                .perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"calcResponse\":"+returnVal+"}"))
                .andReturn();
    }
}
