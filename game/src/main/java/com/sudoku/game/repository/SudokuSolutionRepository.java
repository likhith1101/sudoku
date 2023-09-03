package com.sudoku.game.repository;

import com.sudoku.game.entity.SudokuSolution;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SudokuSolutionRepository extends JpaRepository<SudokuSolution, Long> {
}