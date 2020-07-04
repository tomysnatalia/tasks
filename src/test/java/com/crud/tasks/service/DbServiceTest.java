package com.crud.tasks.service;

import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DbServiceTest {

    @InjectMocks
    DbService dbService;

    @Mock
    TaskRepository taskRepository;

    @Test
    public void getAllTasksTest() {
        //Given
        Task task = new Task (1L, "testTitle", "testContent");
        List<Task> taskList = Arrays.asList(task);

        when(taskRepository.findAll()).thenReturn(taskList);

        //When
        List<Task> taskList1 = dbService.getAllTasks();

        //Then
        assertNotNull(taskList1);
        assertEquals(1, taskList1.size());

    }

    @Test
    public void saveTaskTest() {
        //Given
        Task task = new Task(1L, "testTitle", "testContent");

        when(taskRepository.save(task)).thenReturn(task);

        //When
        Task saveTask = dbService.saveTask(task);

        //Then
        assertEquals(task.getId(), saveTask.getId());
        assertEquals(task.getTitle(), saveTask.getTitle());
        assertEquals(task.getContent(), saveTask.getContent());
    }

    @Test
    public void deleteTaskTest() {
        //Given
        Task task = new Task(1L, "testTitle", "testContent");
        Task task2 = new Task(2L, "testTitle2", "testContent2");
        List<Task> taskList = Arrays.asList(task);

        when(taskRepository.findAll()).thenReturn(taskList);

        //When
        dbService.deleteTask(2L);
        List<Task> taskList1 = dbService.getAllTasks();

        //Then
        assertEquals(1, taskList1.size());
    }
}
