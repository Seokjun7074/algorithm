const lottos = [31, 10, 45, 1, 6, 19];
const win_nums = [31, 10, 45, 1, 6, 19];
let count = 0;
let zero = 0;
lottos.forEach((e) => {
  if (win_nums.includes(e)) count++;
  else if (e === 0) zero++;
});

const min_money = 7 - count > 6 ? 6 : 7 - count;
const max_money = min_money - zero < 1 ? 1 : min_money - zero;
console.log([max_money, min_money]);
