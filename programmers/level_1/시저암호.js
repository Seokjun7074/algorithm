function solution(s, n) {
  var answer = "";

  for (let i = 0; i < s.length; i++) {
    const ascii = s[i].charCodeAt();
    if (ascii === 32) answer += " ";
    else if (ascii >= 65 && ascii <= 90) {
      if (ascii + n > 90) answer += String.fromCharCode(ascii + n - 26);
      else answer += String.fromCharCode(ascii + n);
    } else if (ascii >= 97 && ascii <= 122) {
      if (ascii + n > 122) answer += String.fromCharCode(ascii + n - 26);
      else answer += String.fromCharCode(ascii + n);
    }
  }
  console.log(answer);
  return answer;
}

solution("a B z", 4);
// 공백 = 32
// a~z = 97~122
// A~Z = 65~90

//   console.log(" ".charCodeAt());
//   console.log(String.fromCharCode(100));
