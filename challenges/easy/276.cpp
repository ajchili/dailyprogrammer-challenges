#include <iostream>

using namespace std;

void printReckt(string word, int width, int height);
void printRow(string word, int times);
void printFlippedRow(string word, int times);
void printCol(string word, int times);
void printFlippedCol(string word, int times);
string reverseWord(string word);

int main(int argc, const char * argv[]) {
    string word;
    int width, height;
    
    cout << "Please enter a word: ";
    cin >> word;
    cout << "Please enter width of recktangle: ";
    cin >> width;
    cout << "Please enter height of recktangle: ";
    cin >> height;
    
    printReckt(word, width, height);
    
    return 0;
}

void printReckt(string word, int width, int height) {
    bool startOffset = width % 2 == 0 || height % 2 == 0;
    
    if (startOffset)
        word = reverseWord(word);
    
    printRow(word, width);
    
    for (int i = 0; i < height; i++) {
        if (i % 2 == 0) {
            printCol(word, width);
            printFlippedRow(word, width);
        } else {
            printFlippedCol(word, width);
            printRow(word, width);
        }
    }
}

void printRow(string word, int times) {
    string newWord = "";
    for (int i = 0; i < times; i++) {
        if (i == 0) {
            for (int j = 0; j < word.length() * 2; j++) {
                if (j % 2 == 0) {
                    newWord += word.at(j / 2);
                } else {
                    newWord += " ";
                }
            }
        } else if (i % 2 == 1) {
            for (int j = (int) word.length() * 2; j > 0; j--) {
                if (j == word.length() * 2) {
                    newWord += word.at((j / 2) - 2);
                    j = ((int) word.length() - 2) * 2;
                } else {
                    if (j % 2 == 0) {
                        newWord += word.at(j / 2);
                    } else {
                        newWord += " ";
                    }
                }
            }
            newWord += word.at(0);
        } else {
            for (int j = 0; j < word.length() * 2; j++) {
                if (j % 2 == 0 && j != 0) {
                    newWord += word.at(j / 2);
                } else {
                    if (j != 1) {
                        newWord += " ";
                    }
                }
            }
        }
    }
    
    cout << newWord << "\n";
}

void printFlippedRow(string word, int times) {
    printRow(reverseWord(word), times);
}

void printCol(string word, int times) {
    string newWord = "";
    
    for (int i = 0; i < word.length() * 2; i++) {
        if (i % 2 != 0) {
            if (i != 1 && (i / 2) != word.length() - 1) {
                newWord += "\n";
                newWord += word.at(i / 2);
                for (int j = 0; j < times; j++) {
                    for (int k = 0; k < (word.length() * 2) - 2; k++) {
                        if (k != (word.length() * 2) - 3) {
                            newWord += " ";
                        } else {
                            if (j % 2 == 0) {
                                newWord += word.at(word.length() - 1 - (i / 2));
                            } else {
                                newWord += word.at(i / 2);
                            }
                        }
                    }
                }
                newWord += "\n";
            }
        }
    }
    cout << newWord << "\n";
}

void printFlippedCol(string word, int times) {
    printCol(reverseWord(word), times);
}

string reverseWord(string word) {
    string tempWord = word;
    word = "";
    
    for (int i = 0; i < tempWord.length() - 1; i++) {
        word = word + tempWord.at(tempWord.length() - i);
    }
    
    return word;
}
