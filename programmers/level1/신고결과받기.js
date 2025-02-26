const id_list = ["muzi", "frodo", "apeach", "neo"];
const report = [
  "muzi frodo",
  "apeach frodo",
  "frodo neo",
  "muzi neo",
  "apeach muzi",
];
const k = 2;

function solution(id_list, report, k) {
  const answer = new Array(id_list.length).fill(0);
  //0으로 다 채워놓기
  const report_list = {};

  id_list.map((user) => {
    report_list[user] = [];
  }); //키: 신고당한 유저 값: 신고자들 리스트 객체 생성

  report.map((user) => {
    const [user_id, report_id] = user.split(" ");
    if (!report_list[report_id].includes(user_id)) {
      report_list[report_id].push(user_id);
    }
  }); //신고자 리스트에 이름이 없으면 추가하는식으로 객체 완성
  console.log(report_list);
  for (const key in report_list) {
    if (report_list[key].length >= k) {
      report_list[key].map((user) => {
        answer[id_list.indexOf(user)]++;
      });
    }
  }
  return answer;
}

// console.log(solution(id_list, report, k));
