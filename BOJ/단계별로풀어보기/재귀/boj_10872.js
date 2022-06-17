const fs = require("fs");
const filepath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let input = fs.readFileSync(filepath).toString().trim().split("\n");
const N = parseInt(input[0]);
function recursion(n) {
  if (n === 0) return 1;
  else {
    return n * recursion(n - 1);
  }
}

console.log(recursion(N));
