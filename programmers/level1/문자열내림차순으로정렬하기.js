function solution(s) {
  var answer = "";
  const str_arr = s.split("");
  answer = str_arr
    .sort((a, b) => {
      if (a > b) return -1;
      if (a < b) return 1;
    })
    .join("");
  return answer;
}

solution("Zbcdefg");
