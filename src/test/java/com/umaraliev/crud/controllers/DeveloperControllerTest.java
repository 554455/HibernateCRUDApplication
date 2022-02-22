package com.umaraliev.crud.controllers;

import com.umaraliev.crud.model.Developer;
import com.umaraliev.crud.repository.DeveloperRepository;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

public class DeveloperControllerTest {

    @Mock
    private DeveloperRepository developerRepository = mock(DeveloperRepository.class);
    @InjectMocks
    private DeveloperController developerController = new DeveloperController(developerRepository);
    private Developer developerOne;
    private Developer developer;

    @Test
    public void create() {

        developer = new Developer();

        developer.setFirstName("Andrei");
        developer.setLastName("Komarov");

        when(developerRepository.save(any(Developer.class))).thenReturn(developer);
        assertNotNull(developer);
        assertEquals("Andrei", developer.getFirstName());
    }

    @Test
    public void developerList() {

        developerOne = new Developer();

        developerOne.setFirstName("Andrei");
        developerOne.setLastName("Komarov");

        developer = new Developer();

        developer.setFirstName("Peter");
        developer.setLastName("Romanenko");

        List<Developer> developerList = new ArrayList<>();

        developerList.add(developerOne);
        developerList.add(developer);

        when(developerRepository.getAll()).thenReturn(developerList);
        assertNotNull(developerList);
    }

    @Test
    public void update() {

        developer = new Developer();

        developer.setFirstName("Peter");
        developer.setLastName("Romanenko");

        when(developerRepository.update(developer)).thenReturn(developer);
        assertEquals("Romanenko", developer.getLastName());
    }

    @Test
    public void delete() {

        developerRepository.deleteById(anyInt());

        verify(developerRepository).deleteById(anyInt());
    }

    @Test
    public void getById() {

        List<Developer> developerList = new ArrayList<>();

        developerList.add(developerOne);
        developerList.add(developer);

        when(developerRepository.getById(1)).thenReturn(developerOne);
    }
}