package com.crud.tasks.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;


@Getter
@AllArgsConstructor
@NoArgsConstructor

public class TrelloBoardDto {
    private String name;
    private String id;
    private List<TrelloBoardDto> lists;

}
