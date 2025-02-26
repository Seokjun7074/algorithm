function solution(sizes) {
  var answer = 0;
  let long = [];
  let short = [];
  sizes.forEach((e) => {
    if (e[0] >= e[1]) {
      long.push(e[0]);
      short.push(e[1]);
    } else {
      long.push(e[1]);
      short.push(e[0]);
    }
  });
  answer = Math.max(...long) * Math.max(...short);
  return answer;
}

console.log(
  solution([
    [60, 50],
    [30, 70],
    [60, 30],
    [80, 40],
  ])
);
