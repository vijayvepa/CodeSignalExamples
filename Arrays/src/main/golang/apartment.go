package main

import "fmt"

func apartmentMain() {
	apartments := [][]string{
		{"Apt 101", "Apt 102", "Apt 103"},
		{"Apt 201", "Apt 202", "Apt 203"},
		{"Apt 301", "Apt 302", "Apt 303"},
	}

	apartments[1][0] = "Vacant"

	fmt.Printf("\n # Apartments: %v", apartments)

	for floor, _ := range apartments {
		fmt.Println("Floor", floor+1)
		for room, _ := range apartments[floor] {
			fmt.Println("Apartment", apartments[floor][room])
		}
		fmt.Println()
	}
}
