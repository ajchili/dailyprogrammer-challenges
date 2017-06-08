def main():
    numbers = raw_input("Please enter your range of numbers: ");
    output = getNumbers(numbers);

    print(output);

def getNumbers(string):
    numbers = ""; #string of numbers to be printed

    lastNum = 0;
    num = 0;
    iteration = 0;

    for c in string:
        if c is  not",":
            if num is 0:
                num = int(c);
            else:
                num = int(str(num) + "" + c);

            iteration += 1;
        else:
            iteration = 0;
            if lastNum > num:
                iteration = 0;
            else:
                lastNum = num;
                num = 0;
                numbers += str(lastNum) + " ";

    if num > 0:
        numbers += str(num);
            
    return numbers;

if __name__ == "__main__":main()
