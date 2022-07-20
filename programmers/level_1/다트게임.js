function solution(dartResult) {
  var answer = 0;
  let scores_arr = [];
  let temp = 0;
  for (let i = 0; i < dartResult.length; i++) {
    if (dartResult[i] >= 0 && dartResult[i] <= 9) {
      if (dartResult[i] == 1 && dartResult[i + 1] == 0) {
        temp = 10;
        i++;
      } else {
        temp = dartResult[i];
      }
    } else if (dartResult[i] === "S") {
      scores_arr.push(temp);
    } else if (dartResult[i] === "D") {
      scores_arr.push(temp ** 2);
    } else if (dartResult[i] === "T") {
      scores_arr.push(temp ** 3);
    } else if (dartResult[i] == "#") {
      scores_arr[scores_arr.length - 1] *= -1;
    } else if (dartResult[i] == "*") {
      scores_arr[scores_arr.length - 1] *= 2;
      scores_arr[scores_arr.length - 2] *= 2;
    }
  }
  for (let i = 0; i < scores_arr.length; i++) {
    answer += Number(scores_arr[i]);
  }
  return answer;
}
console.log(solution("1D2S#10S"));
