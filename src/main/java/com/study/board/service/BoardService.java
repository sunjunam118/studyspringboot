package com.study.board.service;

import com.study.board.entity.Board;
import com.study.board.repo.BoardRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.UUID;

@Service

public class BoardService {

    @Autowired
    private BoardRepo boardRepo;

    //글 작성 처리(이미지 파일 업로드까지)
    public void write(Board board, MultipartFile file) throws Exception{
        String projectPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\files";

        UUID uuid = UUID.randomUUID();
        String fileName = uuid + "_" + file.getOriginalFilename();
        File saveFile = new File(projectPath, fileName);
        file.transferTo(saveFile);
        board.setFilename(fileName);
        board.setFilepath("/files/" + fileName);
        boardRepo.save(board);

    }

    // 게시물 리스트 처리
    public Page<Board> boardList(Pageable pageable) {
        return boardRepo.findAll(pageable);
    }

    public Page<Board> boardSearchList(String searchKeyword, Pageable pageable) {
        return boardRepo.findByTitleContaining(searchKeyword, pageable);
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
