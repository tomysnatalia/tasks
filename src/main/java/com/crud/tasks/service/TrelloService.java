package com.crud.tasks.service;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.CreatedTrelloCard;
import com.crud.tasks.domain.Mail;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.trello.client.TrelloClient;
import jdk.internal.jline.internal.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.Optional.ofNullable;

@Service
public class TrelloService {

    private static final String SUBJECT = "Tasks: New Trello card";

    @Autowired
    AdminConfig adminConfig;

    @Autowired
    public TrelloClient trelloClient;

    @Autowired
    public SimpleEmailService emailService;

    public List<TrelloBoardDto> fetchTrelloBoards() {
        return trelloClient.getTrelloBoards();
    }

    public CreatedTrelloCard createdTrelloCard (final TrelloCardDto trelloCardDto) {
        CreatedTrelloCard newCard = trelloClient.createNewCard(trelloCardDto);

        Optional.ofNullable(newCard).ifPresent(card -> emailService.send(new Mail(adminConfig.getAdminMail(),
                SUBJECT,
                "New Card " + card.getName() + " has been created on your Trello account")));

        return newCard;
    }
}
