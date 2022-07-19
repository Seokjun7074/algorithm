function solution(d, budget) {
  var answer = 0;
  let total = 0;
  const arr = d.sort((a, b) => a - b);
  for (let i = 0; i < arr.length; i++) {
    answer++;
    total += arr[i];
    if (total > budget) {
      answer--;
      break;
    }
  }
  return answer;
}

console.log(solution([2, 2, 3, 3], 10));
