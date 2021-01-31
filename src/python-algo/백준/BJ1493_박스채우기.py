length, width, height = map(int,input().split())
N = int(input())
cubes = {}
for i in range(N):
    a,b = map(int,input().split())
    cubes[a]=b

print(type(cubes))
cubes = sorted(cubes.items(), reverse=True)

dp = [0]*N

L,W,H=0,0,0

idx = 0
print(cubes)

for j in range(len(cubes)):

    key = cubes[j][0]
    cube = pow(2,key)

    for i in range(cubes[j][1]):
        if L+cube<=length and :
            total-=cube
            dp[idx]+=1
        else:
            break

    if total<=0:
        break
    idx+=1
    
if total==0:
    sum = 0
    for i in range(len(dp)):
        sum+=dp[i]
    print(sum)
else:
    print(-1)
