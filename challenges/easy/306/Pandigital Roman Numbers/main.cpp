//
//  main.cpp
//  Pandigital Roman Numbers
//
//  Created by Kirin Patel on 4/17/17.
//  Copyright © 2017 Kirin Patel. All rights reserved.
//

#include <iostream>
#include <string>

using namespace std;

void getNumbers(string input);
void printRomanNumeral(string input);

int main(int argc, const char * argv[]) {
    string input;
    getline(cin, input);
    
    getNumbers(input);
    
    return 0;
}

void getNumbers(string input) {
    string number = "";
    for (int i = 0; i < input.length(); i++) {
        if (input.at(i) != ',') {
            if (input.at(i) != ' ')
                number += input.at(i);
        } else {
            printRomanNumeral(number);
            number = "";
        }
    }
    
    if (number.length() > 0)
        printRomanNumeral(number);
}

void printRomanNumeral(string input) {
    int number = stoi(input);
    string romanNumeral = "";
    while (number > 0) {
        if (number >= 1000) {
            number -= 1000;
            romanNumeral += "M";
        } else if (number >= 400) {
            if (number >= 500) {
                number -= 500;
                romanNumeral += "D";
            } else {
                number -= 400;
                romanNumeral += "CD";
            }
        } else if (number >= 90) {
            if (number > 100) {
                number -= 100;
                romanNumeral += "C";
            } else {
                number -= 90;
                romanNumeral += "XC";
            }
        } else if (number >= 40) {
            if (number >= 50) {
                number -= 50;
                romanNumeral += "L";
            } else {
                number -= 40;
                romanNumeral += "XL";
            }
        } else if (number >= 9) {
            if (number >= 10) {
                number -= 10;
                romanNumeral += "X";
            } else {
                number -= 40;
                romanNumeral += "IX";
            }
        } else if (number >= 5) {
            number -= 5;
            romanNumeral += "V";
        } else if (number >= 1) {
            if (number == 4) {
                number -= 4;
                romanNumeral += "IV";
            } else {
                number--;
                romanNumeral += "I";
            }
        }
    }
    
    cout << input << " : " << romanNumeral << endl;
}
