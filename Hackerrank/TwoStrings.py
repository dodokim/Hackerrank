def has_intersection(str1, str2):
    arr = [str1, str2]
    intersection = set.intersection(*arr)
    if len(intersection) > 1:
        return True

if __name__ == "__main__":
    N = int(input())
    for i in range(N):
        str1 = set(input())
        str2 = set(input())
        print("YES" if has_intersection(str1, str2) else "NO")            
        