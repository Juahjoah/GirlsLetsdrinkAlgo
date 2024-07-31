# BFS 함수를 사용하여 시작 단어에서 목표 단어로 변환하는 최단 경로를 찾는 함수

from collections import deque

def BFS(start, end, wordList):
    queue = deque([(start, 0)])  # 시작 단어와 현재 변환 단계 수를 큐에 추가
    visited = set()              # 방문한 단어를 저장하는 집합

    while queue:
        current_word, steps = queue.popleft()  # 큐에서 현재 단어와 단계 수를 꺼냄

        # 목표 단어에 도달하면 현재 단계 수를 반환
        if current_word == end:
            return steps

        # 단어 리스트를 순회하면서 변환 가능한 단어를 찾음
        for word in wordList:
            # 아직 방문하지 않았고 한 글자 차이나는 단어인 경우
            if word not in visited and isOneLetter(current_word, word):
                visited.add(word)                # 방문한 단어로 표시
                queue.append((word, steps + 1))  # 큐에 변환된 단어와 단계 수를 추가

    # 목표 단어에 도달할 수 없는 경우 0 반환
    return 0

# 두 단어가 한 글자 차이인지 판단하는 함수
def isOneLetter(word1, word2):
    # 두 단어의 각 글자를 비교하여 다른 글자 수를 계산
    diff_count = sum(1 for a, b in zip(word1, word2) if a != b)
    # 다른 글자 수가 1이면 True 반환, 그렇지 않으면 False 반환
    return diff_count == 1

# 주어진 단어들을 사용하여 시작 단어를 목표 단어로 변환하는 최단 경로를 찾는 함수
def solution(begin, target, words):
    # target이 words에 없으면 변환할 수 없음
    if target not in words:
        return 0

    return BFS(begin, target, words)

