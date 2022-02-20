package com.umaraliev.crud.controllers;

import com.umaraliev.crud.model.Team;
import com.umaraliev.crud.repository.TeamRepository;
import com.umaraliev.crud.repository.impl.TeamRepositoryImpl;

import java.util.List;

public class TeamController {

    private TeamRepository teamRepository;

    public TeamController() {
        teamRepository = new TeamRepositoryImpl();
    }

    public TeamController(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public Team create(String name) {
        Team team = new Team();
        team.setName(name);
        return teamRepository.save(team);
    }

    public List<Team> teamList() {
        return teamRepository.getAll();
    }

    public Team update(Integer id, String name) {
        Team team = new Team();
        team.setName(name);
        return teamRepository.update(team);
    }

    public void delete(Integer id){
        teamRepository.deleteById(id);
    }

    public Team getById(Integer id) {
        return teamRepository.getById(id);
    }
}
