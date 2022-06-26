function solution(numbers) {
  let answer = 0;
  const test_arr = new Array(10).fill(false);
  for (let i = 0; i < numbers.length; i++) {
    const idx = numbers[i];
    test_arr[idx] = true;
  }
  answer = test_arr.reduce((total, currnetValue, idx) => {
    if (currnetValue === false) {
      return total + idx;
    } else return total;
  }, 0);
  return answer;
}
