// See https://aka.ms/new-console-template for more information
Console.WriteLine("Hello, World!");


string ArrayExample()
{

	string[][] array = [
		["Apt 101", "Apt 102", "Apt 103"],
		["Apt 201", "Apt 202", "Apt 203"],
		["Apt 301", "Apt 302", "Apt 303"]
	];
	array[1][1] = "Vacant";
	return string.Join(", ", array.SelectMany(x => x));
}

Console.WriteLine(ArrayExample());

void ColumnarZigZagExperiments()
{
	int[][] matrix = [
	[1, 2, 3,4],
	[5, 6, 7, 8],
	[9, 10, 11, 12]
	];
	int[] columnarZigZagExpected = [12, 8, 4, 3, 7, 11, 10, 6, 2, 1, 5, 9];

	// [3,4], [2, 4], [1, 4]  -- decrease x until 1
	// [1, 3], [2, 3], [3, 3] -- decrease y, increase x until max
	// [3, 2], [2, 2], [1, 2] -- decrease y, decrease x until 0
	// [1, 1], [2, 1], [3, 1] -- decrease y, increase x until max

	int[] columnarZigZagActual = new int[matrix.Length * matrix[0].Length];

	columnarZigZagActual[0] = matrix[matrix.Length - 1][matrix[0].Length - 1];
	columnarZigZagActual[1] = matrix[matrix.Length - 2][matrix[0].Length - 1];
	columnarZigZagActual[2] = matrix[matrix.Length - 3][matrix[0].Length - 1];

	columnarZigZagActual[3] = matrix[matrix.Length - 3][matrix[0].Length - 2];
	columnarZigZagActual[4] = matrix[matrix.Length - 2][matrix[0].Length - 2];
	columnarZigZagActual[5] = matrix[matrix.Length - 1][matrix[0].Length - 2];

	Console.WriteLine("Columnar Zig Zag Expected: {0}", string.Join(",", columnarZigZagExpected));
	Console.WriteLine("Columnar Zig Zag Actual: {0}", string.Join(",", columnarZigZagActual));

}

ColumnarZigZagExperiments();

int[] ColumnarZigZag(int[][] matrix)
{

	int[] columnarZigZagExpected = [12, 8, 4, 3, 7, 11, 10, 6, 2, 1, 5, 9];

	int[] columnarZigZagAlgo = new int[matrix.Length * matrix[0].Length];

	int outputIndex = 0;
	int direction = -1;
	for (int j = 0; j < matrix[0].Length; j++)
	{
		for (int i = 0; i < matrix.Length; i++)
		{
			int row = direction < 0 ?
				matrix.Length - 1 - i :
				i;

			columnarZigZagAlgo[outputIndex + i] = matrix[row][matrix[0].Length - 1 - j];
		}
		outputIndex += matrix.Length;
		direction = -direction;
	}


	Console.WriteLine("{0}", string.Join(",", columnarZigZagExpected));
	Console.WriteLine("{0}", string.Join(",", columnarZigZagAlgo));


	return columnarZigZagAlgo;
}

int[][] matrix = [
	[1, 2, 3,4],
	[5, 6, 7, 8],
	[9, 10, 11, 12]
];

Console.WriteLine(string.Join(",", ColumnarZigZag(matrix)));