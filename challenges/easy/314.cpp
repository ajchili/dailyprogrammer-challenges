//
//  main.cpp
//  Concatenated Integers
//
//  Created by Kirin Patel on 5/8/17.
//  Copyright © 2017 Kirin Patel. All rights reserved.
//

#include <iostream>
#include <string>

using namespace std;

int getNumber(string input);
int getLargestNumber(string input, int number);
int getSmallestNumber(string input, int number);

int main(int argc, const char * argv[]) {
    string number;
    cin >> number;
    cout << getSmallestNumber(number, getNumber(number)) << " " << getLargestNumber(number, getNumber(number));
    return 0;
}

int getNumber(string input) {
    int number = 1;
    for (int i = 0; i < input.length(); i++) {
        if (input.at(i) == ',')
            number++;
    }
    return number;
}

int getLargestNumber(string input, int number) {
    int largestnumber = 0;
    string currentNumber = "";
    
    for (int i = 0; i < number; i++) {
        for (int j = 0; j < number; j++) {
            
        }
    }
    
    return largestnumber;
}
