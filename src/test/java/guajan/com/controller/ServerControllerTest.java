package guajan.com.controller;

import guajan.com.entity.Server;
import guajan.com.entity.User;
import guajan.com.service.ServerService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ServerController.class)
class ServerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ServerService serverService;

    @DisplayName("create mock")
    @Test
    void shouldCreateMockMvc() {
        assertNotNull(mockMvc);
    }

    @DisplayName("Test for Get All server REST API when have elements")
    @Test
    void givenListOfServe_whenGetAllServe_thenReturnServeList() throws Exception {
        //given
        List<Server> listOfServer = new ArrayList<>();
        Server server1 = new Server(new User(),"Alvanil",true);
        Server server2 = new Server(new User(),"Alvanil",true);
        listOfServer.add(server1);
        listOfServer.add(server2);
        given(serverService.getAll()).willReturn(listOfServer);

        //when
        ResultActions response = mockMvc.perform(get("/server/list"));

        //then
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.size()",is(listOfServer.size())));
    }

    @DisplayName("Test for Get All server REST API when not have elements")
    @Test
    void givenListOfServerEmpty_whenGetAllServer_thenReturnNOT_FOUND() throws Exception {

        //given
        List<Server> listOfServer = new ArrayList<>();
        given(serverService.getAll()).willReturn(listOfServer);

        //when
        ResultActions response = mockMvc.perform(get("/server/list"));

        //then
        response.andExpect(status().isNotFound())
                .andDo(print());
    }

    @DisplayName("Test for Save server REST API when return a server")
    @Test
    void whenSaveServer_whenReturnSever() throws Exception {
        //given
        Server server1 = new Server(new User(),"Alvanil",true);
        given(serverService.save(server1)).willReturn(server1);

        //when
        ResultActions response = mockMvc.perform(post("/server/save"));

        //then
        response.andExpect(status().isCreated())
                .andDo(print());
                //.andExpect();
    }
}