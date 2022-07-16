function solution(n) {
  var answer = "";
  let num_arr = n
    .toString()
    .split("")
    .map((e) => parseInt(e));
  const sorted_arr = num_arr.sort((a, b) => b - a);
  sorted_arr.forEach((e) => {
    answer += e.toString();
  });
  return parseInt(answer);
}

solution(118372);
