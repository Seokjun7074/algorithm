function solution(a, b) {
  const day = ["SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"];
  const month = [31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
  let totalDays = b + 4;

  for (let i = 0; i < a - 1; i++) {
    //a월 까지 날따 계산
    totalDays += month[i];
  }
  return day[totalDays % 7];
}

console.log(solution(2, 1));
