function solution(n) {
  const num = n ** 0.5;
  return num % 1 === 0 ? (num + 1) ** 2 : -1;
}
console.log(solution(10));
