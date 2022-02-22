package com.umaraliev.crud.controllers;

import com.umaraliev.crud.model.Skill;
import com.umaraliev.crud.model.Team;
import com.umaraliev.crud.repository.TeamRepository;
import com.umaraliev.crud.repository.impl.TeamRepositoryImpl;
import org.hibernate.annotations.ManyToAny;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

public class TeamControllerTest {

    @Mock
    private TeamRepository teamRepository = mock(TeamRepositoryImpl.class);
    @InjectMocks
    private TeamController teamController = new TeamController(teamRepository);
    private Team teamOne;
    private Team team;

    @Test
    public void create() {

        team = new Team();

        team.setName("artic");

        when(teamRepository.save(any(Team.class))).thenReturn(team);
        assertNotNull(team);
        assertEquals("artic", team.getName());
    }

    @Test
    public void teamList() {

        teamOne = new Team();

        teamOne.setName("artik");

        team = new Team();

        team.setName("vartik");

        List<Team> teamList = new ArrayList<>();

        teamList.add(teamOne);
        teamList.add(team);

        when(teamRepository.getAll()).thenReturn(teamList);
        assertNotNull(teamList);
    }

    @Test
    public void update() {

        team = new Team();

        team.setName("artik");

        when(teamRepository.update(team)).thenReturn(team);
        assertEquals("artik", team.getName());
    }

    @Test
    public void delete() {

        teamRepository.deleteById(anyInt());

        verify(teamRepository).deleteById(anyInt());
    }

    @Test
    public void getById() {
        List<Team> teamList = new ArrayList<>();

        teamList.add(teamOne);
        teamList.add(team);

        when(teamRepository.getById(1)).thenReturn(teamOne);
    }
}