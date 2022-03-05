const fs = require("fs");
const filepath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = fs.readFileSync(filepath).toString().split(" ");

let hours = parseInt(input[0]);
let minutes = parseInt(input[1]) - 45;

function setHours(hours) {
  if (hours >= 0) {
    return hours;
  } else {
    return 24 + hours;
  }
}
function setMinutes(minutes) {
  if (minutes >= 0) {
    return minutes;
  } else {
    return 60 + minutes;
  }
}
if (minutes < 0) {
  hours = hours - 1;
  hours = setHours(hours);
}
console.log(hours, setMinutes(minutes));
