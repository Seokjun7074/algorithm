function solution(n, m) {
  var answer = [];

  // 최대공약수 함수
  const gn = (a, b) => {
    if (b === 0) {
      return a;
    }
    return gn(b, a % b); // 나머지가 0이 아니면 재귀로 함수를 실행한다.
  };
  // 최소공배수 함수
  const ln = (a, b) => (a * b) / gn(a, b);

  return [gn(n, m), ln(n, m)];
}
