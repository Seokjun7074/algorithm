function solution(begin, target, words) {
  var answer = 0;
  const v = new Array(words.length).fill(false);

  q = [];
  q.push([begin, 0]);
  while (q.length > 0) {
    const [curWord, cnt] = q.shift();
    if (curWord === target) {
      answer = cnt;
      break;
    }
    for (let i = 0; i < words.length; i++) {
      if (!v[i] && checkWord(curWord, words[i])) {
        v[i] = true;
        q.push([words[i], cnt + 1]);
      }
    }
  }

  return answer;
}

function checkWord(input, compare) {
  let diff = 0;
  for (let i = 0; i < input.length; i++) {
    if (input[i] !== compare[i]) {
      diff += 1;
    }
    if (diff > 1) {
      return false;
    }
  }
  return diff === 1 ? true : false;
}
