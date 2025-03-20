function solution(rectangle, characterX, characterY, itemX, itemY) {
  const MAX_SIZE = 102;
  const graph = Array.from({ length: MAX_SIZE }, () => new Array(MAX_SIZE).fill(0));

  // 1. 사각형 내부와 테두리 구분
  rectangle.forEach(([x1, y1, x2, y2]) => {
    (x1 *= 2), (y1 *= 2), (x2 *= 2), (y2 *= 2);

    for (let i = y1; i <= y2; i++) {
      for (let j = x1; j <= x2; j++) {
        if (i === y1 || i === y2 || j === x1 || j === x2) {
          if (graph[i][j] === 0) graph[i][j] = 1;
        } else {
          graph[i][j] = 2;
        }
      }
    }
  });

  // 3. BFS 탐색 (최단 거리 찾기)
  const dx = [0, 1, 0, -1];
  const dy = [1, 0, -1, 0];
  const queue = [[characterY * 2, characterX * 2, 0]]; // (y, x, 이동 거리)
  const visited = Array.from({ length: MAX_SIZE }, () => new Array(MAX_SIZE).fill(false));

  visited[characterY * 2][characterX * 2] = true;

  while (queue.length) {
    const [y, x, dist] = queue.shift();

    if (y === itemY * 2 && x === itemX * 2) return dist / 2;

    for (let i = 0; i < 4; i++) {
      const ny = y + dy[i];
      const nx = x + dx[i];

      if (ny >= 0 && ny < MAX_SIZE && nx >= 0 && nx < MAX_SIZE) {
        if (!visited[ny][nx] && graph[ny][nx] === 1) {
          // 테두리만 이동 가능
          visited[ny][nx] = true;
          queue.push([ny, nx, dist + 1]);
        }
      }
    }
  }

  return -1;
}
