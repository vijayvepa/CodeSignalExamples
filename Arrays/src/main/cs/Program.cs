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