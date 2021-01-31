N = int(input())
A = map(int,input().split())
M = int(input())
B = map(int,input().split())

for i in range(M):
    binarySearch(B[i])


def binarySearch(b):
    
    while 