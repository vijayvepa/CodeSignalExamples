package main

import (
	"fmt"
)

func zigZagMain() {

	grid := [][]int{
		{1, 2, 3, 4},
		{5, 6, 7, 8},
	}

	fmt.Printf("Grid: %v \n", grid)

	traversed := traverse(grid)

	fmt.Printf("Traversed: %v \n", traversed)

}

func traverse(grid [][]int) []int {
	rows := len(grid)
	cols := len(grid[0])

	row := rows - 1
	col := cols - 1
	direction := "up"

	traverse := []int{}
	for range rows * cols {
		//fmt.Printf("row %d col %d : %d", row,  col,  grid[row][col])
		traverse = append(traverse, grid[row][col])

		row, col = next(direction, row, col)
		direction = nextDirection(direction, row, rows)

	}

	return traverse

}

func next(direction string, row int, col int) (int, int) {
	switch direction {
	case "up":
		row--
	case "down":
		row++
	case "left":
		col--
	}
	return row, col
}

func nextDirection(direction string, row int, rows int) string {
	switch direction {
	case "up":
		if row == 0 {
			return "left"
		}
	case "down":
		if row == rows-1 {
			return "left"
		}
	case "left":
		if row == 0 {
			return "down"
		} else if row == rows-1 {
			return "up"
		}
	}

	return direction
}
