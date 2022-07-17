function solution(arr) {
  const answer = [];
  for (let i = 0; i < arr.length; i++) {
    if (i === 0) answer.push(arr[i]);
    else {
      if (answer[answer.length - 1] !== arr[i]) answer.push(arr[i]);
    }
  }
  return answer;
}

solution([4, 4, 4, 3, 3]);
