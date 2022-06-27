function solution(array, commands) {
  var answer = [];
  for (let i = 0; i < commands.length; i++) {
    const copy = [...array];
    const cmd = commands[i];
    let [start, end, idx] = cmd;
    const spliceArr = copy
      .splice(start - 1, end - start + 1)
      .sort((a, b) => a - b);
    //sort 메소드는 유니코드 기준이므로 2, 10 비교시 10이 더 작다고 나옴
    answer.push(spliceArr[idx - 1]);
  }
  return answer;
}

const array = [10, 5, 2, 6, 3, 7, 4];
const commands = [
  [2, 5, 3],
  [4, 4, 1],
  [1, 7, 3],
  [7, 7, 1],
];

// console.log(solution(array, commands));
console.log(array.sort());
