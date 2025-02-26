const s = "123q";

function solution(s) {
  if (s.length === 4 || s.length === 6) {
    for (let i = 0; i < s.length; i++) {
      if (s.charCodeAt(i) < 48 || s.charCodeAt(i) > 57) {
        return false;
      }
    }
    return true;
  } else return false;
}

// 0부터 9까지 아스키 48~57
console.log(solution(s));
