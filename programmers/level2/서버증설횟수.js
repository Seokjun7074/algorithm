function solution(players, m, k) {
  var answer = 0;
  const server = [];

  for (let time = 0; time < 24; time++) {
    // 서버를 추가한다면 서버 끝나는 시간도 추가 (2일 때 추가한건 7일 때 사라짐)
    while (server.length > 0 && server[0] === time) {
      server.shift();
    }
    const curPlayers = players[time];
    if (curPlayers / m >= 1) {
      const neededServer = Math.floor(curPlayers / m);
      if (server.length < neededServer) {
        const serverCnt = neededServer - server.length;
        for (let i = 0; i < serverCnt; i++) {
          server.push(time + k);
        }
        answer += serverCnt;
      }
    }
  }

  return answer;
}

//
