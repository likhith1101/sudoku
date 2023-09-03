package com.sudoku.game.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

import lombok.Data;

@Entity
@Data
public class SudokuPuzzle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 81)
    private String puzzle;

    @Column(length = 81)
    private String solution;

	public String getSolution() {
		// TODO Auto-generated method stub
		return solution;
	}

	public Long getId() {
		// TODO Auto-generated method stub
		return id;
	}

	
}
