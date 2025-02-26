const board = [
  [0, 0, 0, 0, 0], //arr[0][?]
  [0, 0, 1, 0, 3], //arr[1][?]
  [0, 2, 5, 0, 1], //arr[2][?]
  [4, 2, 4, 4, 2], //arr[3][?]
  [3, 5, 1, 3, 1], //arr[4][?]
];
const moves = [1, 5, 3, 5, 1, 2, 1, 4];

function solution(board, moves) {
  var answer = 0;
  let toys = [];
  for (let i = 0; i < moves.length; i++) {
    const spot = moves[i] - 1;
    for (let j = 0; j < board.length; j++) {
      if (board[j][spot] !== 0) {
        toys.push(board[j][spot]);
        if (toys[toys.length - 1] === toys[toys.length - 2]) {
          toys.pop();
          toys.pop();
          answer += 2;
        }
        board[j][spot] = 0;
        break;
      }
    }
  }
  return answer;
}

solution(board, moves);
