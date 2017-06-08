//
//  main.cpp
//  Permutation Base 2
//
//  Created by Kirin Patel on 3/7/17.
//  Copyright © 2017 Kirin Patel. All rights reserved.
//

#include <iostream>
#include <math.h>
using namespace std;

// Function decleration
void getChoice();
void convertToDecimal();
void convertToBinary();

// Variable decleration
bool isRunning = false;

int main(int argc, const char * argv[]) {
    isRunning = true;
    
    do {
        getChoice();
    } while(isRunning);
    
    return 0;
}

void getChoice() {
    int choice;
    
    cout << "Please select an option:\n1.Conver to Decimal\n2.Convet to Binary\n3.Quit\n";
    cin >> choice;
    
    switch(choice) {
        case 1:
            convertToDecimal();
            break;
        case 2:
            convertToBinary();
            break;
        case 3:
            isRunning = false;
            break;
    }
}

void convertToDecimal() {
    string number;
    
    cout << "Please enter a binary number: ";
    cin >> number;
    
    number.reserve();
    int decimal = 0;
    for (int i = 0; i < number.length(); i++) {
        if (number.at(i) == '1') {
            decimal += pow(2.0, i);
        } else if (number.at(i) != '0') {
            cout << "\n\nInvalid number.\n";
            return;
        }
    }
    
    cout << "\n\n" << number << " is binary for " << decimal << "\n";
}

void convertToBinary() {
    string number;
    
    cout << "Please enter a decimal number: ";
    cin >> number;
    int convert = stoi(number);
    
    if (convert == 0) {
        cout << "\n\n" << number << " is decimal for 0\n";
    } else {
        int binaryLogOfNumber = log(convert) / log(2);
        convert = convert - pow(2, binaryLogOfNumber);
        string binary = "1";
        
        for (int i = binaryLogOfNumber - 1; i > -1; i--) {
            if (pow(2, i) < convert || pow(2, i) == convert) {
                convert = convert - (int) pow(2, i);
                binary = "1" + binary;
            } else {
                binary = "0" + binary;
            }
        }
        
        cout << "\n\n" << number << " is decimal for " << binary << "\n";
    }
}
