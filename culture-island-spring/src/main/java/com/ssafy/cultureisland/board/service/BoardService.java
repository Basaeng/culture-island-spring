package com.ssafy.cultureisland.board.service;

import com.ssafy.cultureisland.board.model.BoardDto;
import com.ssafy.cultureisland.board.model.BoardListDto;
import com.ssafy.cultureisland.board.model.CommentDto;
import com.ssafy.cultureisland.board.model.FileInfoDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface BoardService {
    BoardListDto listArticle(Map<String,String> map) throws Exception;
    void writeArticle(BoardDto boardDto) throws Exception;
    BoardDto getArticle(int articleNo) throws Exception;
    List<FileInfoDto> getFileList(int articleNo) throws Exception;
    void deleteArticle(int articleNo) throws Exception;
    void updateHit(int articleNo) throws Exception;
    void writeComment(CommentDto commentDto) throws Exception;
    List<CommentDto> listComment(int articleNo) throws Exception;
    void modifyArticle(BoardDto boardDto) throws Exception;
}
