//
//  main.cpp
//  challenge-239
//
//  Created by Kirin Patel on 3/3/17.
//  Copyright © 2017 Kirin Patel. All rights reserved.
//

#include <iostream>

using namespace std;

int main(int argc, const char * argv[]) {
    int number = 100;
    bool hasReadchedOne = false;
    
    cout << "Please enter a number: ";
    cin >> number;
    
    do {
        int numChangedBy;
        
        cout << "Current number: " << number << "\n";
        
        if (number == 1) {
            hasReadchedOne = true;
            break;
        }
    
        switch (number % 3) {
            case 0:
                number = number / 3;
                numChangedBy = 0;
                break;
            case 1:
                number = (number - 1) / 3;
                numChangedBy = -1;
                break;
            case 2:
                number = (number + 1) / 3;
                numChangedBy = 1;
                break;
            default:
                break;
        }
        
        cout << "New number: " << number << " : " << numChangedBy << "\n";
    } while(!hasReadchedOne);
    
    return 0;
}
