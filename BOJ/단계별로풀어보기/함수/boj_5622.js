const fs = require("fs");
const filepath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let input = fs.readFileSync(filepath).toString().trim();

const dial = ["ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"];
let time = 0;

for (let i = 0; i < input.length; i++) {
  for (let j = 0; j < dial.length; j++) {
    if (dial[j].includes(input[i])) {
      let number = j + 3;
      time += number;
    }
  }
}
console.log(time);

// let answer = 0;
// for (let i = 0; i < input.length; ++i) {
//   let c = input[i];
//   if (c >= "W") {
//     answer += 10;
//   } else if (c >= "T") {
//     answer += 9;
//   } else if (c >= "P") {
//     answer += 8;
//   } else if (c >= "M") {
//     answer += 7;
//   } else if (c >= "J") {
//     answer += 6;
//   } else if (c >= "G") {
//     answer += 5;
//   } else if (c >= "D") {
//     answer += 4;
//   } else if (c >= "A") {
//     answer += 3;
//   }
// }
// console.log(answer);
