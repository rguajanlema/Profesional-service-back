package guajan.com.service;

import guajan.com.entity.Server;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ServerServiceImplTest {

    @Autowired
    ServerServiceImpl serverService;

    @Test
    @DisplayName("Test when return a list of Serve")
    void testFindAll(){
        List<Server> allServer = serverService.getAll();

        assertEquals(5,allServer.size());
    }
}