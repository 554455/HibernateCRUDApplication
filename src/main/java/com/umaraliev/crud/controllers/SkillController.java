package com.umaraliev.crud.controllers;

import com.umaraliev.crud.model.Skill;
import com.umaraliev.crud.repository.SkillRepository;
import com.umaraliev.crud.repository.impl.SkillRepositoryImpl;

import java.util.List;

public class SkillController {
    private final SkillRepository repo;

    public SkillController() {
        repo = new SkillRepositoryImpl();
    }

    public SkillController(SkillRepository repo) {
        this.repo = repo;
    }

    public Skill createSkill(String name) {
        Skill skill = new Skill();
        skill.setName(name);
        return repo.save(skill);
    }

    public Skill updateSkill(Integer id, String name) {
        Skill skill = new Skill();
        skill.setId(id);
        skill.setName(name);
        return repo.update(skill);
    }

    public List<Skill> getAll() {
        return repo.getAll();
    }

    public void deleteByIdSkill(Integer id) {
        repo.deleteById(id);
    }

    public Skill getById(Integer id) {
        return repo.getById(id);
    }
}
