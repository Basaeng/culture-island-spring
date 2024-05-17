package com.ssafy.cultureisland.board.service;

import com.ssafy.cultureisland.board.model.BoardDto;
import com.ssafy.cultureisland.board.model.BoardListDto;
import com.ssafy.cultureisland.board.model.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BoardServiceImpl implements BoardService {

    private BoardMapper boardMapper;

    @Autowired
    public BoardServiceImpl(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    @Override
    public BoardListDto listArticle(Map<String, String> map) throws Exception {
        Map<String, Object> param = new HashMap<String, Object>();
        System.out.println(map);
        param.put("word", map.get("word") == null ? "" : map.get("word"));
        int currentPage = Integer.parseInt(map.get("pgno") == null ? "1" : map.get("pgno"));
        int sizePerPage = Integer.parseInt(map.get("spp") == null ? "20" : map.get("spp"));
        int start = currentPage *sizePerPage - sizePerPage;
        param.put("start", start);
        param.put("listSize", sizePerPage);

        String key = map.get("key");
        param.put("key", key == null ? "" : key);
        if ("user_id".equals(key)) {
            param.put("key", "b.member_id");
        }
        System.out.println("list");
        List<BoardDto> list = boardMapper.listArticle(param);
        if ("user_id".equals(key)) {
            param.put("key", "member_id");
        }
        int totalArticleCount = boardMapper.getTotalArticleCount(param);
        int totalPageCount = (totalArticleCount - 1) / sizePerPage + 1;

        BoardListDto boardListDto = new BoardListDto();
        boardListDto.setArticles(list);
        boardListDto.setCurrentPage(currentPage);
        boardListDto.setTotalPageCount(totalPageCount);

        return boardListDto;
    }
}