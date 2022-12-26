package guajan.com.service;

import guajan.com.entity.Ability;
import guajan.com.repository.AbilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbilityServiceImpl implements AbilityService{

    @Autowired
    private AbilityRepository abilityRepository;

    @Override
    public Ability save(Ability ability) {
        ability.setStatus(true);
        return abilityRepository.save(ability);
    }

    @Override
    public Ability disable(Long id) {
        Ability abilityFind = abilityRepository.findById(id).orElse(null);
        if(abilityFind == null)
            return null;

        abilityFind.setStatus(false);
        return abilityRepository.save(abilityFind);
    }

    @Override
    public List<Ability> list(String email) {
        List<Ability> abilityList = abilityRepository.findAll().
        stream().
        filter(
                ability ->
                        ability.getEmail().equals(email) &&
                                ability.isStatus()==true).
        toList();

        return abilityList;
    }
}
