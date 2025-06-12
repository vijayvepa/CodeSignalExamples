#include <iostream>

void print(int matrix[2][4])
{
	for (int i = 0; i < 2; i++)
	{
		for (int j = 0; j < 4; j++)
		{
			std::cout << matrix[i][j] << ", ";
		}
		std::cout << std::endl;
	}
}

const int UP = 1;
const int DOWN = 2;
const int LEFT = 3;

int getNextRow(int row, int col, int rows, int cols, int direction)
{
	if (direction == UP)
	{
		return row - 1;
	}
	if (direction == DOWN)
	{
		return row + 1;
	}
	return row;
}

int getNextCol(int row, int col, int rows, int cols, int direction)
{
	if (direction == LEFT)
	{
		return col - 1;
	}

	return col;
}

int getNextDirection(int row, int col, int rows, int cols, int direction)
{
	if (direction == UP)
	{
		if (row == 0)
		{
			return LEFT;
		}
		else
		{
			return direction;
		}
	}

	if (direction == DOWN)
	{
		if (row == rows - 1)
		{
			return LEFT;
		}
		else
		{
			return direction;
		}
	}

	if (direction == LEFT)
	{
		if (row == 0)
		{
			return DOWN;
		}
		if (row == rows - 1)
		{
			return UP;
		}
		return direction;
	}

	return direction;
}

void printArray(int traverse[12])
{
	for (int i = 0; i < 12; i++)
	{
		std::cout << traverse[i] << ",";
	}
}

void zigZagTraverse(int matrix[2][4], int traverse[12])
{
	int rows = 2;
	int cols = 4;
	int row = rows - 1;
	int col = cols - 1;
	int traversed = 12;
	int direction = UP;

	for (int i = 0; i < traversed; i++)
	{
		traverse[i] = matrix[row][col];

		int nextRow = getNextRow(row, col, rows, cols, direction);
		int nextCol = getNextRow(row, col, rows, cols, direction);
		int nextDirection = getNextDirection(row, col, rows, cols, direction);

		std::cout << "nextRow" << nextRow << ", nextCol" << nextCol << ", nextDirection" << nextDirection << std::endl;

		row = nextRow;
		col = nextCol;
		direction = nextDirection;
	}
}

void zigZagMain()
{
	int matrix[2][4] = {
			{1, 2, 3, 4},
			{5, 6, 7, 8}};

	int traversedPath[12];

	int rows = sizeof(matrix) / sizeof(matrix[0]);
	int cols = sizeof(matrix[0]) / sizeof(matrix[0][0]);

	std::cout << "Rows: " << rows << ", Cols: " << cols << std::endl;

	print(matrix);

	zigZagTraverse(matrix, traversedPath);

	printArray(traversedPath);
}

int main(int argc, char *argv[])
{
	zigZagMain();
	return 0;
}
