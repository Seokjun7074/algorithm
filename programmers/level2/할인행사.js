function solution(want, number, discount) {
  var answer = 0;

  for (let i = 0; i < discount.length - 9; i++) {
    const shoppingList = discount.slice(i, i + 10);
    const dict = {};
    want.forEach((item) => (dict[item] = 0));
    shoppingList.forEach((item) => {
      if (want.includes(item)) dict[item] += 1;
    });

    let flag = true;
    want.forEach((item, idx) => {
      if (dict[item] !== number[idx]) flag = false;
    });
    if (flag) answer += 1;
  }
  return answer;
}
