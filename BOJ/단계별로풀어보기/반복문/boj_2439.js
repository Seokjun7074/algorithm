const fs = require("fs");
const filepath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = fs.readFileSync(filepath).toString().split(" ");

const starNum = parseInt(input[0]);
let result = "";
for (let i = 0; i < starNum; i++) {
  //공백
  for (let j = starNum - 1; j > i; j--) {
    result += " ";
  }
  //별
  for (let k = 0; k < i + 1; k++) {
    result += "*";
  }
  result += "\n";
}

console.log(result);
