package com.simple.app;

import com.simple.app.Enum.Color;
import com.simple.app.controller.MainController;
import com.simple.app.model.User;
import com.simple.app.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.View;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration
public class MainControllerTest {

    @InjectMocks
    MainController controller = new MainController();

    @Mock
    UserService service = new UserService();

    @Mock
    View mockView;
    MockMvc mockMvc;

    private User user;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).setSingleView(mockView).build();
        user = new User();
        user.setId(1);
        user.setName("user1");
        user.setAge(20);
    }

    @Test
    public void testGetUserByArticle() throws Exception {

        List<User> users = Arrays.asList(user);

        when(service.findUserByArticles()).thenReturn(users);

        mockMvc.perform(get("/usersByArticles")).andExpect(status().isOk());
    }

}
