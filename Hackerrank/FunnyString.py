import math

def isFunny(word):
    i = 0
    length = len(word)
    arr = []
    revarr = []
    for i in range(0,math.ceil(length/2)):
        sdiff = abs(ord(word[i])-ord(word[i+1]))
        rdiff = abs(ord(word[length-i-1])-ord(word[length-i-2]))
        if sdiff == rdiff:
               continue
        else:
               return False
    return True

    if __name__ == "__main__":
    n = int(input())
    for _ in range(n):
        word = input();
        if isFunny(word):
            print("Funny")
        else:
            print("Not Funny")