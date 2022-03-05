const fs = require("fs");
const filepath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = fs.readFileSync(filepath).toString().split(" ");

let hours = parseInt(input[0]);
let minutes = parseInt(input[1]) - 45;

if (minutes < 0) {
  hours--;
  minutes = 60 + minutes;
  if (hours < 0) {
    hours = 23;
  }
}
console.log(hours, minutes);
