// 1번 수포자 [1,2,3,4,5]
// 2번 수포자 [2,1,2,3,2,4,2,5]
// 3번 수포자 [3,3,1,1,2,2,4,4,5,5]

function solution(answers) {
  const supo_1 = [1, 2, 3, 4, 5];
  const supo_2 = [2, 1, 2, 3, 2, 4, 2, 5];
  const supo_3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5];
  let scores = [0, 0, 0];
  for (let i = 0; i < answers.length; i++) {
    if (supo_1[i % supo_1.length] === answers[i]) scores[0]++;
    if (supo_2[i % supo_2.length] === answers[i]) scores[1]++;
    if (supo_3[i % supo_3.length] === answers[i]) scores[2]++;
  }
  const answer = [];
  const maxValue = Math.max(...scores);
  let index = 0;
  for (let i = 0; i < 3; i++) {
    if (maxValue === scores[i]) {
      answer[index] = i + 1;
      index++;
    }
  }

  return answer;
}

solution([1, 3, 2, 4, 2]);
