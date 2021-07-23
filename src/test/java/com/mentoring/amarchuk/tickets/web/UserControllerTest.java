package com.mentoring.amarchuk.tickets.web;

import com.mentoring.amarchuk.tickets.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:config.xml"})
@WebAppConfiguration
class UserControllerTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @Autowired
    UserController userController;

    @BeforeEach
    public void setup() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();
    }

    @Test
    void startPage() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("welcome"));
    }

    @Test
    void allUsers() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/allUsers"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("list_users"));
    }

    @Test
    void createUser() throws Exception {
        User user = new User("testName", "test@test.com");
        mvc.perform(MockMvcRequestBuilders.get("/create")
                .param("name", user.getName())
                .param("email", user.getEmail()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("/allUsers"));

    }

    @Test
    void newUser() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/new"))
                .andExpect(status().isOk())
                .andExpect(view().name("new_user"));
    }


    @Test
    void deleteTransport_whenIdIsCorrect() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/delete/{id}", 1)
        ).andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("facade"));
    }




    @Test
    void getIncorrectUser2() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/user/{id}", " "))
                .andExpect(status().isBadRequest());

    }

    @Test
    void getUserByName() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/user/name")
                .param("name", "Stacy"))
                .andExpect(status().isOk())
                .andExpect(view().name("facade"));
    }


}