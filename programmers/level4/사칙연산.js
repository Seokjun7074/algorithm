function makeArray(len) {
  const arr = new Array(len);
  for (let i = 0; i < len; i++) {
    arr[i] = new Array(len).fill(0);
  }
  return arr;
}

function solution(arr) {
  const MAX_VALUE = Infinity;
  const MIN_VALUE = -Infinity;

  const N = (arr.length + 1) / 2;
  const maxDP = makeArray(N);
  const minDP = makeArray(N);
  for (let i = 0; i < N; i++) {
    for (let j = 0; j < N; j++) {
      maxDP[i][j] = MIN_VALUE;
      minDP[i][j] = MAX_VALUE;
    }
  }

  // 어디서 끊을지 결정하는 step (1, / 2,3,4,5)
  // step이 0인 경우는 자기자신 값 사용
  for (let step = 0; step < N; step++) {
    for (let i = 0; i < N - step; i++) {
      if (step == 0) {
        maxDP[i][i] = Number(arr[i * 2]);
        minDP[i][i] = Number(arr[i * 2]);
        continue;
      }
      let j = i + step;
      for (let k = i; k < j; k++) {
        // console.log(i,k,'/',k+1,j)
        if (arr[2 * k + 1] === "+") {
          maxDP[i][j] = Math.max(maxDP[i][j], maxDP[i][k] + maxDP[k + 1][j]);
          minDP[i][j] = Math.min(minDP[i][j], minDP[i][k] + minDP[k + 1][j]);
        } else {
          maxDP[i][j] = Math.max(maxDP[i][j], maxDP[i][k] - minDP[k + 1][j]);
          minDP[i][j] = Math.min(minDP[i][j], minDP[i][k] - maxDP[k + 1][j]);
        }
      }
    }
  }
  return maxDP[0][N - 1];
}
