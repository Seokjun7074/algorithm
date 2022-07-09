function solution(left, right) {
  var answer = 0;
  const single = [];
  const couple = [];
  for (let i = left; i <= right; i++) {
    const arr = [];
    for (let j = 1; j <= i; j++) {
      if (i % j === 0) arr.push(j);
    }
    if (arr.length % 2 === 0) couple.push(i);
    else single.push(i);
  }

  const plus = couple.reduce((sum, cur) => {
    return sum + cur;
  }, 0);
  const minus = single.reduce((sum, cur) => {
    return sum + cur;
  }, 0);

  return plus - minus;
}

console.log(solution(13, 17));
