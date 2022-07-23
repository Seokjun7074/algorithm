function solution(price, money, count) {
  let total_pay = 0;
  for (let i = 1; i <= count; i++) {
    total_pay += price * i;
  }
  return total_pay - money <= 0 ? 0 : total_pay - money;
}

console.log(solution(3, 20, 4));
