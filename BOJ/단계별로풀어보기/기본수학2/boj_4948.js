const fs = require("fs");
const filepath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let input = fs.readFileSync(filepath).toString().trim().split("\n");
input = input.map((e) => parseInt(e));
input.pop();
// console.log(input);

for (let i = 0; i < input.length; i++) {
  checkNumber(input[i]);
}

function checkNumber(num) {
  let arr = Array(num * 2 + 1).fill(true);
  arr[0] = false;
  arr[1] = false;

  for (let i = 2; i <= Math.ceil(Math.sqrt(num * 2)); i++) {
    if (arr[i]) {
      let m = 2;
      while (i * m <= num * 2) {
        arr[i * m] = false;
        m++;
      }
    }
  }
  let results = [];

  for (let i = num + 1; i <= num * 2; i++) {
    if (arr[i]) {
      results.push(i);
    }
  }
  console.log(results.length);
}
