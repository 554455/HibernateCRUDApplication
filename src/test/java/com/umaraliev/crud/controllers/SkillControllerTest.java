package com.umaraliev.crud.controllers;

import com.umaraliev.crud.model.Skill;
import com.umaraliev.crud.repository.SkillRepository;
import com.umaraliev.crud.repository.impl.SkillRepositoryImpl;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

public class SkillControllerTest {

    @Mock
    private SkillRepository skillRepository = mock(SkillRepositoryImpl.class);
    @InjectMocks
    private SkillController skillController = new SkillController(skillRepository);
    private Skill skillOne;
    private Skill skill;

    @Test
    public void createSkill() {

        skill = new Skill();

        skill.setName("Soft skill");

        when(skillRepository.save(any(Skill.class))).thenReturn(skill);
        assertNotNull(skill);
        assertEquals("Soft skill", skill.getName());
    }

    @Test
    public void updateSkill() {

        skill = new Skill();

        skill.setName("Soft skill");

        when(skillRepository.update(skill)).thenReturn(skill);
        assertEquals("Soft skill", skill.getName());
    }

    @Test
    public void getAll() {
        skillOne = new Skill();

        skillOne.setName("Soft skill");

        skill = new Skill();

        skill.setName("skill");

        List<Skill> skillList = new ArrayList<>();

        skillList.add(skillOne);
        skillList.add(skill);

        when(skillRepository.getAll()).thenReturn(skillList);
        assertNotNull(skillList);
    }

    @Test
    public void deleteByIdSkill() {

        skillRepository.deleteById(anyInt());

        verify(skillRepository).deleteById(anyInt());
    }

    @Test
    public void getById() {

        List<Skill> skillList = new ArrayList<>();

        skillList.add(skillOne);
        skillList.add(skill);

        when(skillRepository.getById(1)).thenReturn(skillOne);
    }
}