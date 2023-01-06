package guajan.com.repository;

import guajan.com.entity.Server;
import guajan.com.entity.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class ServerRepositoryTest {

    @Autowired
    private ServerRepository serverRepository;

    @DisplayName("Test when save a serve return other serve")
    @Test
    void whenSave_whenReturnServer(){
        Server server = new Server(new User(), "Alvanil",true);

        Server serverSave = serverRepository.save(server);

        assertThat(serverSave).isNotNull();
        assertThat(serverSave.getProfesion()).isEqualTo("Alvanil");
        assertThat(serverSave).isEqualTo(server);
    }
}