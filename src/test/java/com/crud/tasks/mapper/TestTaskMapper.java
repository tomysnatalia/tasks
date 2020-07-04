package com.crud.tasks.mapper;
import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class TestTaskMapper {

    @InjectMocks
    TaskMapper taskMapper;

    @Test
    public void mapToTaskTest() {
        //Given
        Task task = new Task(1L, "testTitle", "testContent");
        TaskDto taskDto = new TaskDto(1L, "testTitle", "testContent");

        //When
        Task mapping = taskMapper.mapToTask(taskDto);

        //Then
        assertEquals(task.getId(), mapping.getId());
        assertEquals(task.getTitle(),mapping.getTitle());
        assertEquals(task.getContent(), mapping.getContent());
    }

    @Test
    public void mapToTaskDto() {
        //Given
        Task task = new Task(1L, "testTitle", "testContent");
        TaskDto taskDto = new TaskDto(1L, "testTitle", "testContent");

        //When
        TaskDto mapping = taskMapper.mapToTaskDto(task);

        //Then
        assertEquals(taskDto.getId(), mapping.getId());
        assertEquals(taskDto.getTitle(), mapping.getTitle());
        assertEquals(taskDto.getContent(), mapping.getContent());
    }

    @Test
    public void mapToTaskDtoList() {
        //Given
        Task task = new Task(1L, "testTitle", "testContent");
        List<Task> taskList = Arrays.asList(task);

        //When
        List<TaskDto> mappingList = taskMapper.mapToTaskDtoList(taskList);

        //Then
        assertNotNull(mappingList);
        assertEquals(1, mappingList.size());

    }
}
