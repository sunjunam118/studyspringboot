package com.study.board.repo;

import com.study.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepo extends JpaRepository<Board, Integer> {
}
