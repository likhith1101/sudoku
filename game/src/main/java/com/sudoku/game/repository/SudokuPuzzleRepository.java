package com.sudoku.game.repository;

import com.sudoku.game.entity.SudokuPuzzle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SudokuPuzzleRepository extends JpaRepository<SudokuPuzzle, Long> {
}