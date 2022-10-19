const fs = require("fs");
const filepath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let input = fs
  .readFileSync(filepath)
  .toString()
  .split("\n")
  .map((e) => parseInt(e));

const newArr = [];
for (let i = 1; i <= input[0]; i++) {
  newArr.push(input[i]);
}

let tmp = 0;
for (let i = 0; i < newArr.length; i++) {
  for (let j = i + 1; j < newArr.length; j++) {
    if (newArr[i] > newArr[j]) {
      tmp = newArr[i];
      newArr[i] = newArr[j];
      newArr[j] = tmp;
    }
  }
}
newArr.forEach((e) => {
  console.log(e);
});
