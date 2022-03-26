const fs = require("fs");
const filepath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let input = fs.readFileSync(filepath).toString().split("\n");

const C = input[0];

for (let i = 1; i <= C; i++) {
  const arr = input[i].split(" ");
  let sum = 0;
  let count = 0;
  for (let j = 1; j < arr.length; j++) {
    sum += Number(arr[j]);
  }
  const avg = sum / (arr.length - 1);
  //   console.log(avg);
  for (let j = 1; j < arr.length; j++) {
    if (arr[j] > avg) {
      count++;
    }
  }
  const rate = (count / arr[0]) * 100;
  console.log(`${rate.toFixed(3)}%`);
}
