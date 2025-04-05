import sys
sys.stdin = open("../input.txt")
input = sys.stdin.readline  # 한 줄씩 읽기



def main():
    q = int(input())



    def search(h):
        # h보다 크거나 같은 사람이 있는 가장 왼쪽 산을 이분탐색
        left, right = 0, len(mount) - 1
        idx = len(mount)
        while left <= right:
            mid = (left + right) // 2
            if h <= mount[mid][-1]:
                idx = mid
                right = mid - 1
            else:
                left = mid + 1
        return idx

    heights = []
    for _ in range(q):
        tokens = list(map(int, input().split()))
        o = tokens[0]

        if o == 100:
            n = tokens[1]
            heights = tokens[2:]
            # for h in heights:
            #     idx = search(h)
            #     index.append(idx)
            #     if idx == len(mount):
            #         mount.append([])
            #     mount[idx].append(h)

        elif o == 200:
            h = tokens[1]
            heights.append(h)
            # idx = search(h)
            # index.append(idx)
            # if idx == len(mount):
            #     mount.append([])
            # mount[idx].append(h)

        elif o == 300:
            heights.pop()
            # idx = index.pop()
            # mount[idx].pop()
            # if mount and len(mount[-1]) == 0:
            #     mount.pop()

        elif o == 400:
            index = []
            mount = []
            for h in heights:
                idx = search(h)
                index.append(idx)
                if idx == len(mount):
                    mount.append([])
                mount[idx].append(h)
            m_idx = tokens[1] - 1
            result = (index[m_idx] + len(mount)) * 1000000 + mount[-1][0]
            print(result)
if __name__ == "__main__":
    main()

