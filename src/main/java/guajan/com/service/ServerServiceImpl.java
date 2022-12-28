package guajan.com.service;

import guajan.com.entity.Server;
import guajan.com.repository.ServerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServerServiceImpl implements ServerService{

    private ServerRepository serverRepository;

    @Autowired
    ServerServiceImpl(final ServerRepository serverRepository){
        this.serverRepository = serverRepository;
    }

    @Override
    public List<Server> getAll() {
        return serverRepository.findAll();
    }
}
