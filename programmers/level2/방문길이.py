def solution(dirs):
    answer = 0
    dx = {'U': 0, 'D': 0, 'R': 1, 'L': -1}
    dy = {'U': 1, 'D': -1, 'R': 0, 'L': 0}
    
    visited = set()  
    curX, curY = 0, 0 
    
    for c in dirs:
        nx = curX + dx[c]
        ny = curY + dy[c]
        
        if nx > 5 or nx < -5 or ny > 5 or ny < -5:
            continue  # 경계를 벗어나면 이동하지 않음
        
        if ((curX, curY, nx, ny) not in visited) and ((nx, ny, curX, curY) not in visited):
            visited.add((curX, curY, nx, ny))
            visited.add((nx, ny, curX, curY))  
            answer += 1  
        
        curX, curY = nx, ny  
    
    return answer
