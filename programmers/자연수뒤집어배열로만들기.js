function solution(n) {
  var answer = [];
  const str_num = String(n);
  for (let i = str_num.length - 1; i >= 0; i--) {
    answer.push(Number(str_num[i]));
  }
  console.log(answer);
  return answer;
}

solution(12345);
