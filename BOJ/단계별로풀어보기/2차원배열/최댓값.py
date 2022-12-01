import sys
sys.stdin = open('input.txt', 'r')

arr = []
max = 0
position = []

for x in range(9):
    arr.append(list(map(int, input().split(' '))))

for x in range(len(arr)):
    for y in range(len(arr)):
        if(arr[x][y] >= max):
            max = arr[x][y]
            position = [x, y]

print(max)
print('{} {}'.format(position[0]+1, position[1]+1))
