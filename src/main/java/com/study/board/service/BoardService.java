package com.study.board.service;

import com.study.board.entity.Board;
import com.study.board.repo.BoardRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class BoardService {

    @Autowired
    private BoardRepo boardRepo;

    //글 작성 처리
    public void write(Board board) {

        boardRepo.save(board);

    }

    // 게시물 리스트 처리
    public List<Board> boardList() {
        return boardRepo.findAll();
    }

    // 특정 게시물 불러오기
    public Board boardView(Integer id) {
        return boardRepo.findById(id).get();
    }

    //특정 게시글 삭제
    public void boardDelete(Integer id) {
        boardRepo.deleteById(id);
    }
}
