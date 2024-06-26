package com.ssafy.cultureisland.board.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BoardDto {
    private int articleNo;
    private String memberId;
    private String name;
    private String subject;
    private String content;
    private int hit;
    private String registerTime;
    private String type;
    private int pay;
    private List<FileInfoDto> fileInfos;
}
