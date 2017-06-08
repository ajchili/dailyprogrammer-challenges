def main():
    d = input("The number of sides on your die: ");
    h = input("The amount of health left on the enemy: ");

    print(getCriticalHit(d, h));
    
def getCriticalHit(d, h):
    if (h <= d):
        return (d + 1.0 - h) / d;
    else:
        return getCriticalHit(d, h - d) / d;
if __name__ == "__main__":main()

# help from https://www.reddit.com/r/dailyprogrammer/comments/4nvrnx/20160613_challenge_271_easy_critical_hit/d48o494/
