const fs = require("fs");
const filepath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let input = fs.readFileSync(filepath).toString().split(" ");
input = Number(input);

function hansu(num) {
  let count = 0;
  for (let i = 1; i <= num; i++) {
    let stingNumber = String(i);
    if (i < 100) {
      count++;
      continue;
    }
    if (
      Number(stingNumber[0]) - Number(stingNumber[1]) ===
      Number(stingNumber[1]) - Number(stingNumber[2])
    ) {
      count++;
    }
  }
  return count;
}

console.log(hansu(input));
