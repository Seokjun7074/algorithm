function checkNumber(number) {
  let first_idx = null;
  let second_idx = null;
  const phone = [
    [1, 2, 3],
    [4, 5, 6],
    [7, 8, 9],
    ["*", 0, "#"],
  ];

  if (number >= 1 && number <= 3) {
    first_idx = 0;
    second_idx = phone[first_idx].indexOf(number);
  } else if (number >= 4 && number <= 6) {
    first_idx = 1;
    second_idx = phone[first_idx].indexOf(number);
  } else if (number >= 7 && number <= 9) {
    first_idx = 2;
    second_idx = phone[first_idx].indexOf(number);
  } else {
    first_idx = 3;
    second_idx = phone[first_idx].indexOf(number);
  }

  return [first_idx, second_idx];
}

function solution(numbers, hand) {
  let answer = "";
  let lefthand = ["*"];
  let righthand = ["#"];
  const leftcheck = [1, 4, 7];
  const rightcheck = [3, 6, 9];
  if (hand === "right") hand = "R";
  else hand = "L";

  for (let i = 0; i < numbers.length; i++) {
    let dial = numbers[i];
    let lefthandPosition = lefthand[lefthand.length - 1];
    let righthandPosition = righthand[righthand.length - 1];
    if (leftcheck.includes(dial)) {
      lefthand.push(dial);
      answer += "L";
    } else if (rightcheck.includes(dial)) {
      righthand.push(dial);
      answer += "R";
    } else {
      const nowDial = checkNumber(dial);
      const nowLeft = checkNumber(lefthandPosition);
      const nowRight = checkNumber(righthandPosition);
      const leftDistance =
        Math.abs(nowDial[0] - nowLeft[0]) + Math.abs(nowDial[1] - nowLeft[1]);
      const rightDistance =
        Math.abs(nowDial[0] - nowRight[0]) + Math.abs(nowDial[1] - nowRight[1]);
      if (leftDistance < rightDistance) {
        lefthand.push(dial);
        answer += "L";
      } else if (leftDistance > rightDistance) {
        righthand.push(dial);
        answer += "R";
      } else {
        answer += hand;
        hand === "L" ? lefthand.push(dial) : righthand.push(dial);
      }
    }
  }
  // console.log(hand);
  // console.log(lefthand);
  // console.log(righthand);
  // console.log(answer);

  return answer;
}
solution([7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2], "left");

// console.log(checkNumber(0));
// LRLLLRLLRRL LRRRLRLRLRR LRRRLRLRLRR
// LRLLLRLLRRL LRLLRRLLLRR LRLLRRLLLRR
