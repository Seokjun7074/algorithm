function solution(a, b) {
  const day = ["FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"];
  const month = [31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
  let totalDays = b - 1;

  for (let i = 0; i < a - 1; i++) {
    //a월 까지 날따 계산
    totalDays += month[i];
  }
  return day[totalDays % 7];
}

console.log(solution(2, 2));
