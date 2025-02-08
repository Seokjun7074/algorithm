class Solution(object):
    def uniqueOccurrences(self, arr):
        d = dict()
        for n in arr:
            if n in d:
                d[n] += 1
            else:
                d[n] = 1
        print(d)
        arr = set()
        for n in d:
            arr.add(d[n])
        return len(d) == len(arr)
