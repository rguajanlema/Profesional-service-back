package guajan.com.service;

import guajan.com.entity.Experienci;
import guajan.com.repository.ExperienciRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienciServiceImpl {

    @Autowired
    private ExperienciRepository experienciRepository;

    public Experienci save(Experienci entity){
        return experienciRepository.save(entity);
    }

    public List<Experienci> findByKey(){
        return experienciRepository.findAll();
    }
}
