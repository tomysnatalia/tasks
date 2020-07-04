package com.crud.tasks.trello.mapper;

import com.crud.tasks.domain.*;
import com.crud.tasks.mapper.TrelloMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TestTrelloMapper {

    @InjectMocks
    TrelloMapper trelloMapper;

    @Test
    public void testMapToBoards(){
        //Given
        TrelloListDto trelloListDto = new TrelloListDto("1", "test_List", false);
        List<TrelloListDto> listDto = Arrays.asList(trelloListDto);
        TrelloBoardDto trelloBoardDto = new TrelloBoardDto("test_Board", "one", listDto);
        List<TrelloBoardDto> boardDto = Arrays.asList(trelloBoardDto);
        //When
        List<TrelloBoard> mappedList = trelloMapper.mapToBoards(boardDto);
        //Then
        Assert.assertEquals(boardDto.get(0).getId(), mappedList.get(0).getId());
        Assert.assertEquals(boardDto.get(0).getName(), mappedList.get(0).getName());
        Assert.assertEquals(boardDto.get(0).getLists().get(0).getId(),
                mappedList.get(0).getLists().get(0).getId());
        Assert.assertEquals(boardDto.get(0).getLists().get(0).getName(),
                mappedList.get(0).getLists().get(0).getName());
        Assert.assertEquals(boardDto.get(0).getLists().get(0).isClosed(),
                mappedList.get(0).getLists().get(0).isClosed());
    }

    @Test
    public void testMapToBoardsDto(){
        //Given
        TrelloList trelloList = new TrelloList("1", "test_List", false);
        List<TrelloList> list = Arrays.asList(trelloList);
        TrelloBoard trelloBoard = new TrelloBoard("test_Board", "one", list);
        List<TrelloBoard> board = Arrays.asList(trelloBoard);
        //When
        List<TrelloBoardDto> mappedList = trelloMapper.mapToBoardsDto(board);
        //Then
        Assert.assertEquals(board.get(0).getId(), mappedList.get(0).getId());
        Assert.assertEquals(board.get(0).getName(), mappedList.get(0).getName());
        Assert.assertEquals(board.get(0).getLists().get(0).getId(),
                mappedList.get(0).getLists().get(0).getId());
        Assert.assertEquals(board.get(0).getLists().get(0).getName(),
                mappedList.get(0).getLists().get(0).getName());
        Assert.assertEquals(board.get(0).getLists().get(0).isClosed(),
                mappedList.get(0).getLists().get(0).isClosed());
    }

    @Test
    public void testMapToList(){
        //Given
        TrelloListDto trelloListDto = new TrelloListDto("1", "test_List", false);
        List<TrelloListDto> listDto = Arrays.asList(trelloListDto);
        //When
        List<TrelloList> mappedList = trelloMapper.mapToList(listDto);
        //Then
        Assert.assertEquals(listDto.get(0).getId(), mappedList.get(0).getId());
        Assert.assertEquals(listDto.get(0).getName(), mappedList.get(0).getName());
        Assert.assertEquals(listDto.get(0).isClosed(), mappedList.get(0).isClosed());
    }


    @Test
    public void testMapToListDto() {
        //Given
        TrelloList trelloList = new TrelloList("1", "test_List", false);
        List<TrelloList> list = Arrays.asList(trelloList);
        //When
        List<TrelloListDto> mappedList = trelloMapper.mapToListDto(list);
        //Then
        Assert.assertEquals(list.get(0).getId(), mappedList.get(0).getId());
        Assert.assertEquals(list.get(0).getName(), mappedList.get(0).getName());
        Assert.assertEquals(list.get(0).isClosed(), mappedList.get(0).isClosed());
    }

    @Test
    public void testMapToCard() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("card", "description", "pos", "2");
        //When
        TrelloCard mappedCard = trelloMapper.mapToCard(trelloCardDto);
        //Then
        Assert.assertEquals(trelloCardDto.getName(), mappedCard.getName());
        Assert.assertEquals(trelloCardDto.getDescription(), mappedCard.getDescription());
        Assert.assertEquals(trelloCardDto.getPos(), mappedCard.getPos());
        Assert.assertEquals(trelloCardDto.getListId(), mappedCard.getListId());
    }

    @Test
    public void testMapToCardDto() {
        //Given
        TrelloCard trelloCard = new TrelloCard("card", "description", "pos", "2");
        //When
        TrelloCardDto mappedCard = trelloMapper.mapToCardDto(trelloCard);
        //Then
        Assert.assertEquals(trelloCard.getName(), mappedCard.getName());
        Assert.assertEquals(trelloCard.getDescription(), mappedCard.getDescription());
        Assert.assertEquals(trelloCard.getPos(), mappedCard.getPos());
        Assert.assertEquals(trelloCard.getListId(), mappedCard.getListId());
    }
}
