const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
const [N, M] = input[0].split(" ").map((e) => Number(e));
const arr = [];
const startPosition = [];
const dx = [-1, 1, 0, 0];
const dy = [0, 0, -1, 1];
// v1, v2 동선이 겹쳐도 됨. 하지만 한번만 수확 가능
for (let i = 1; i < N + 1; i++) {
  arr.push(input[i].split(" ").map((e) => Number(e)));
}
for (let i = N + 1; i < N + 1 + M; i++) {
  startPosition.push(input[i].split(" ").map((e) => Number(e) - 1));
}
const v = Array.from(Array(N), () => Array(N).fill(false));

let result = 0;
for (pos of startPosition) {
  v[pos[0]][pos[1]] = true;
  result += arr[pos[0]][pos[1]];
}

const dfs = (x, y, cnt, sum, friendNum) => {
  result = Math.max(result, sum);
  if (cnt === 3) {
    if (friendNum < M - 1) {
      dfs(startPosition[friendNum + 1][0], startPosition[friendNum + 1][1], 0, sum, friendNum + 1);
    }
    return;
  }
  for (let i = 0; i < 4; i++) {
    const nx = x + dx[i];
    const ny = y + dy[i];
    if (0 <= nx && nx < N && 0 <= ny && ny < N && !v[nx][ny]) {
      v[nx][ny] = true;
      dfs(nx, ny, cnt + 1, sum + arr[nx][ny], friendNum);
      v[nx][ny] = false;
    }
  }
};

dfs(startPosition[0][0], startPosition[0][1], 0, result, 0);
console.log(result);
