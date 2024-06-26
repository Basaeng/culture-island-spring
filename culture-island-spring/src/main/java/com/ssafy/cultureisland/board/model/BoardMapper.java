package com.ssafy.cultureisland.board.model;

import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Mapper
public interface BoardMapper {
    List<BoardDto> listArticle(Map<String,Object> param) throws SQLException;
    int getTotalArticleCount(Map<String,Object> param) throws SQLException;
    void writeArticle(BoardDto boardDto) throws SQLException;
    void registerFile(BoardDto boardDto) throws SQLException;
    BoardDto getArticle(int articleNo) throws SQLException;
    public List<FileInfoDto> getFileList(int articleNo) throws SQLException;
    void deleteArticle(int articleNo) throws SQLException;
    void updateHit(int articleNo) throws SQLException;
    void modifyArticle(BoardDto boardDto) throws  SQLException;
    List<BoardDto> memberListArticle(Map<String,Object> param) throws SQLException;
    int getMemberTotalArticleCount(Map<String,Object> param) throws SQLException;
}
