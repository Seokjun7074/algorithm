let input = "...!@BaT#*..y.abcdefghijklm";

function solution(input) {
  let answer = input
    .toLowerCase()
    .replace(/[^a-z0-9-_.]/gi, "")
    .replace(/[.]{2,}/gi, ".") //.replace(/\.+/g, '.')
    .replace(/^[.]|[.]$/gi, "");
  if (answer === "") answer = "a";
  if (answer.length > 15) {
    answer = answer.substring(0, 15);
    answer = answer.replace(/[.]$/gi, "");
  }
  while (answer.length < 3) {
    answer += answer[answer.length - 1];
  }
  return answer;
}
console.log(solution(input));
