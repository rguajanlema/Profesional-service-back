package guajan.com.service;

import guajan.com.entity.Server;
import guajan.com.entity.User;
import guajan.com.repository.ServerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ServerServiceImplTest {

    @Mock
    private ServerRepository serverRepository;
    @InjectMocks
    ServerServiceImpl serverService;


    private Server server;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);
        server = new Server();
        server.setProfesion("Alvanil");
        server.setStatus(true);
    }
    @Test
    @DisplayName("Test when return a list of Serve")
    void testFindAll(){
        Server server1 = new Server(new User(),"Alvanil",true);

        when(serverRepository.findAll()).thenReturn(Arrays.asList(server,server1));

        assertNotNull(serverService.getAll());

        assertThat(serverService.getAll().size()).isEqualTo(2);
        //assertEquals(5,allServer.size());
    }
}