function solution(s) {
  const word = s.toUpperCase();
  let count_p = 0;
  let count_y = 0;
  for (let i = 0; i < word.length; i++) {
    if (word[i] === "P") count_p++;
    else if (word[i] === "Y") count_y++;
  }
  return count_p === count_y;
}

console.log(solution("pPoooyY"));
