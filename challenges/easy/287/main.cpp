#include <iostream>

using namespace std;

char largest_digit(string digit);
string largest_digit_decending(string digit);

int main(int argc, const char * argv[]) {
    cout << "largest_digit(9800) -> " << largest_digit("9800") << "\n";
    return 0;
}

char largest_digit(string digit) {
    int largest_digit = 0;
    
    for (int i = 0; i < digit.length(); i++) {
        if ((int) digit.at(i) > largest_digit)
            largest_digit = (int) digit.at(i);
    }
    
    return (char) largest_digit;
}
