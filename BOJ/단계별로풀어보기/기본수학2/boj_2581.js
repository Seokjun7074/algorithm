const fs = require("fs");
const filepath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let input = fs.readFileSync(filepath).toString().trim().split("\n");
input = input.map((e) => parseInt(e));

const M = input[0];
const N = input[1];
let arr = [];
let sum = 0;
const check = (num) => {
  if (num < 2) return false;
  else {
    let check_number = true;
    for (let i = 2; i < num; i++) {
      if (num % i === 0) {
        check_number = false;
      }
    }
    if (check_number === true) return true;
    else return false;
  }
};

for (let i = M; i <= N; i++) {
  if (check(i) === true) {
    arr.push(i);
  }
}
for (let a = 0; a < arr.length; a++) {
  sum += arr[a];
}

if (arr.length === 0) {
  console.log(-1);
} else {
  console.log(sum);
  console.log(arr[0]);
}
