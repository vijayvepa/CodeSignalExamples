def main():
    array = [
        ["Apt 101", "Apt 102", "Apt 103"],
        ["Apt 101", "Apt 102", "Apt 103"],
        ["Apt 101", "Apt 102", "Apt 103"]
    ]
    print(f"Array: ${array}")
    array[1][0] = 'vacant'
    
    print(f'Updated: ${array}')

if __name__ == '__main__':
    main()

