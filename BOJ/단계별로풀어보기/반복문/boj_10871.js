const fs = require("fs");
const filepath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let input = fs.readFileSync(filepath).toString().split(" ");
//코드 정제과정
const arraySetting = (input) => {
  input.shift();
  let setArray = input[0].split("\n");
  let X = setArray[0].split("\r");
  X = X[0];
  input.shift();
  input.unshift(setArray[1]);
  input.unshift(X);

  return input;
};
const newArray = arraySetting(input);
for (let i = 1; i <= newArray.length; i++) {
  if (parseInt(newArray[i]) < newArray[0]) {
    console.log(newArray[i]);
  }
}
