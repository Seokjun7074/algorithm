function solution(num) {
  const monster = num.length / 2;
  const arr = [...new Set(num)];
  return arr.length > monster ? monster : arr.length;
}

const num = [3, 1, 2, 3];
console.log(solution(num));
