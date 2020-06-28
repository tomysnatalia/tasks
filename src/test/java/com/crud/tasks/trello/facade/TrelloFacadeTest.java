package com.crud.tasks.trello.facade;

import com.crud.tasks.domain.*;
import com.crud.tasks.mapper.TrelloMapper;
import com.crud.tasks.service.TrelloService;
import com.crud.tasks.trello.validator.TrelloValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TrelloFacadeTest {

    @InjectMocks
    TrelloFacade trelloFacade;

    @Mock
    TrelloService trelloService;

    @Mock
    TrelloValidator trelloValidator;

    @Mock
    TrelloMapper trelloMapper;

    @Test
    public void testCreatedTrelloCard(){

        TrelloBadgesDto trelloBadgesDto = new TrelloBadgesDto(1, new TrelloAttachmentByTypeDto(new TrelloTrelloDto(2,3)));

        CreatedTrelloCardDto createdTrelloCardDto = new CreatedTrelloCardDto( "1", "card", "com", trelloBadgesDto);

        TrelloCard trelloCard = new TrelloCard("card", "description", "pos", "1");
        TrelloCardDto trelloCardDto = new TrelloCardDto("card", "description", "pos", "1");

        when(trelloMapper.mapToCard(trelloCardDto)).thenReturn(trelloCard);
        when(trelloMapper.mapToCardDto(trelloCard)).thenReturn(trelloCardDto);

        //When
        CreatedTrelloCardDto createdTrelloCard = trelloFacade.createCard(trelloCardDto);

        //Then
        assertEquals("1",createdTrelloCardDto.getId());
        assertEquals("card",createdTrelloCardDto.getName());
        assertEquals("com",createdTrelloCardDto.getShortUrl());
        assertEquals(1,createdTrelloCardDto.getBadges().getVotes());
        assertEquals(2,createdTrelloCardDto.getBadges().getAttachments().getTrello().getBoard());
        assertEquals(3,createdTrelloCardDto.getBadges().getAttachments().getTrello().getCard());
    }
}
