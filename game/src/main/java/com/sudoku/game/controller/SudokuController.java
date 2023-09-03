// SudokuController.java
package com.sudoku.game.controller;

import com.sudoku.game.entity.SudokuPuzzle;
import com.sudoku.game.entity.SudokuSolution;
import com.sudoku.game.repository.SudokuPuzzleRepository;
import com.sudoku.game.repository.SudokuSolutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class SudokuController {

    @Autowired
    private SudokuPuzzleRepository puzzleRepository;

    @Autowired
    private SudokuSolutionRepository solutionRepository;

    // Show the form to create a Sudoku puzzle
    @GetMapping("/create")
    public String showCreateSudokuPage(Model model) {
        model.addAttribute("puzzle", new SudokuPuzzle());
        return "createSudoku";
    }

    // Create a new Sudoku puzzle and redirect to the solving page
    @PostMapping("/create")
    public String createSudoku(@ModelAttribute SudokuPuzzle puzzle) {
        puzzleRepository.save(puzzle);
        Long puzzleId = puzzle.getId();
        return "redirect:/sudoku/solve/" + puzzleId;
    }

    // Show the Sudoku solving form
    @GetMapping("/sudoku/solve/{puzzleId}")
    public String showSolveSudokuPage(@PathVariable Long puzzleId, Model model) {
        SudokuPuzzle puzzle = puzzleRepository.findById(puzzleId).orElseThrow();
        model.addAttribute("puzzle", puzzle);
        model.addAttribute("solution", new SudokuSolution());
        return "solveSudoku";
    }

    // Verify the user's solution
    @PostMapping("/verify/{puzzleId}")
    public String verifySolution(@PathVariable Long puzzleId, @ModelAttribute SudokuSolution solution, Model model) {
        SudokuPuzzle puzzle = puzzleRepository.findById(puzzleId).orElseThrow();

        if (isSolutionCorrect(solution.getSolution(), puzzle.getSolution())) {
            model.addAttribute("successMessage", "Congratulations! Sudoku solved!");
        } else {
            model.addAttribute("errorMessage", "Oops! Solution is incorrect.");
        }

        model.addAttribute("puzzle", puzzle);
        return "solveSudoku";
    }
    
    

    private boolean isSolutionCorrect(String userSolution, String correctSolution) {
        // Check if the user's solution matches the correct solution
        return userSolution.equals(correctSolution);
    }
}
