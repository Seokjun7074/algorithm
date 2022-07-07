function solution(n, lost, reserve) {
  var answer = 0;
  let students = new Array(n).fill(1);
  for (let i = 0; i < lost.length; i++) {
    const idx = lost[i] - 1;
    students[idx]--;
  }
  for (let i = 0; i < reserve.length; i++) {
    const idx = reserve[i] - 1;
    students[idx]++;
  }
  // 학생들 체육복 수
  for (let i = 0; i < students.length; i++) {
    if (students[i] === 2) {
      if (students[i - 1] === 0) {
        students[i]--;
        students[i - 1]++;
      } else if (students[i + 1] === 0) {
        students[i]--;
        students[i + 1]++;
      }
    }
  }
  students.forEach((e) => {
    if (e > 0) answer++;
  });
  console.log(answer);
  return answer;
}
const n = 3;
const lost = [3];
const reserve = [1];

solution(n, lost, reserve);
