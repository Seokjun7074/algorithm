function solution(absolutes, signs) {
  let answer = 0;
  for (let i = 0; i < signs.length; i++) {
    if (signs[i]) {
      signs[i] = 1;
    } else {
      signs[i] = -1;
    }
  }
  for (let j = 0; j < absolutes.length; j++) {
    answer = answer + absolutes[j] * signs[j];
  }
  return answer;
}

console.log(solution([4, 7, 12], [true, false, true]));
