//
//  main.cpp
//  Magic Squares
//
//  Created by Kirin Patel on 3/4/17.
//  Copyright © 2017 Kirin Patel. All rights reserved.
//

#include <iostream>
using namespace std;

// function decleration
bool checkMagic(int numbers[]);
bool checkRows(int numbers[]);
bool checkCols(int numbers[]);
bool checkDiag(int numbers[]);

int main(int argc, const char * argv[]) {
    int numbers [9];
    
    for (int i = 0; i < 9; i++) {
        cout << "Please enter nubmer for position " << i << " of the grid: ";
        cin >> numbers[i];
    }
    
    cout << checkMagic(numbers) << "\n";
    return 0;
}

bool checkMagic(int numbers[]) {
    return checkRows(numbers) && checkCols(numbers) && checkDiag(numbers);
}

bool checkRows(int numbers[]) {
    return ((numbers[0] + numbers[1] + numbers[2]) == 15) && ((numbers[3] + numbers[4] + numbers[5]) == 15) && ((numbers[6] + numbers[7] + numbers[8]) == 15);
}

bool checkCols(int numbers[]) {
    return ((numbers[0] + numbers[3] + numbers[6]) == 15) && ((numbers[1] + numbers[4] + numbers[7]) == 15) && ((numbers[2] + numbers[5] + numbers[8]) == 15);
}

bool checkDiag(int numbers[]) {
    return ((numbers[0] + numbers[4] + numbers[8]) == 15) && ((numbers[2] + numbers[4] + numbers[6]) == 15);
}
