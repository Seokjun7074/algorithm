const fs = require("fs");
const filepath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let input = fs
  .readFileSync(filepath)
  .toString()
  .trim()
  .split("\n")
  .map((e) => Number(e));

const testCase = input.shift();

for (let i = 0; i < testCase; i++) {
  const k = input.shift();
  const n = input.shift();
  const apartment = [];

  for (let i = 0; i <= k; i++) {
    apartment.push([1]);
    for (let j = 1; j < n; j++) {
      if (i === 0) {
        apartment[i].push(j + 1);
      } else {
        apartment[i].push(apartment[i][j - 1] + apartment[i - 1][j]);
      }
    }
  }
  console.log(apartment[k][n - 1]);
}
