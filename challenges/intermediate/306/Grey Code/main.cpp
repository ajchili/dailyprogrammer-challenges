//
//  main.cpp
//  Grey Code
//
//  Created by Kirin Patel on 3/15/17.
//  Copyright © 2017 Kirin Patel. All rights reserved.
//

#include <iostream>
#include <math.h>
using namespace std;

//  Function decleration
string convertToBinary(string number);
void getGrey(unsigned int number);

int main(int argc, const char * argv[]) {
    string input;
    cin >> input;
    
    getGrey((unsigned int) stoi(convertToBinary(input)));
    
    return 0;
}

string convertToBinary(string number) {
    int convert = stoi(number);
    string binary = "1";
    
    if (convert == 0) {
        return "0";
    } else {
        int binaryLogOfNumber = log(convert) / log(2);
        convert = convert - pow(2, binaryLogOfNumber);
        
        for (int i = binaryLogOfNumber - 1; i > -1; i--) {
            if (pow(2, i) < convert || pow(2, i) == convert) {
                convert = convert - (int) pow(2, i);
                binary = "1" + binary;
            } else {
                binary = "0" + binary;
            }
        }
    }
    
    return binary;
}

void getGrey(unsigned int num) {
    cout << (num ^ (num >> 1));
}
