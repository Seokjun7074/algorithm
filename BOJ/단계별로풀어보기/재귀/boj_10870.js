const fs = require("fs");
const filepath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let input = fs.readFileSync(filepath).toString().trim().split("\n");

const N = parseInt(input[0]);

function fibo(n) {
  if (n >= 2) {
    return fibo(n - 1) + fibo(n - 2);
  } else if (n === 0) return 0;
  else if (n === 1) return 1;
}

console.log(fibo(N));
