let s = "23four5six7";

function solution(s) {
  const number_arr = [
    "zero",
    "one",
    "two",
    "three",
    "four",
    "five",
    "six",
    "seven",
    "eight",
    "nine",
  ];

  for (let e of number_arr) {
    s = s.split(e);
    s = s.join(number_arr.indexOf(e));
  }
  var answer = Number(s);
  return answer;
}

console.log(solution(s));
