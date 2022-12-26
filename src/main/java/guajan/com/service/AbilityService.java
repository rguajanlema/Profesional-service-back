package guajan.com.service;

import guajan.com.entity.Ability;

import java.util.List;

public interface AbilityService {
    Ability save(Ability ability);
    Ability disable(Long id);
    List<Ability> list(String email);
}
