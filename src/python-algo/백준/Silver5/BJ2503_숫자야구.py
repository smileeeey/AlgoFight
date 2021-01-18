N = int(input())

num=[0]*N
strike =[0]*N
ball =[0]*N

answer=0

for i in range(N):
    num[i],strike[i],ball[i] = map(int,input().split())

for i in range(123,988):
    
    if i%10==0 or i//10%10==0 or i//100==0 or i%10==i//10%10 or i//10%10==i//100 or i//100==i%10:
        continue

    flag = True
    for j in range(N):
        #num[j]가 조건에 안맞으면 i 포문으로 컨티뉴
        s = 0
        b = 0
        
        for k in range(3):
            for l in range(3):            
                if str(num[j])[k] == str(i)[l]:
                    if k==l:
                        s += 1
                    else:
                        b +=1
        
        
        if s == strike[j] and b == ball[j]:
            
            continue
        
        
        flag=False
        break
    
    
    if flag == True:
        answer += 1    

print(answer)