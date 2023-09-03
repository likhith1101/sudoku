package com.sudoku.game.entity;

import lombok.Data;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Data
public class SudokuSolution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 81)
    private String solution; // Store the solution grid as a string

	public String getSolution() {
		// TODO Auto-generated method stub
		return solution;
	}
}