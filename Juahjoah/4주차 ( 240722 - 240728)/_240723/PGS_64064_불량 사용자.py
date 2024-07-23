# 2019년 카카오 개발자 겨울 인턴십 코딩테스트 문제
# Permustions 함수를 사용 방식 (참고 : https://bongseok.tistory.com/66)

from itertools import permutations

# user와 banned가 일치하는지 확인하는 함수
def userMatch(user, banned):
    if len(user) != len(banned):        # 길이가 다르면 일치하지 않음
        return False
    for u, b in zip(user, banned):      # 각 문자 비교
        if b == '*':                    # banned의 문자가 '*'이면 통과
            continue
        if u != b:                      # 문자가 다르면 일치하지 않음
            return False
    return True                         # 모든 조건을 만족하면 일치


def solution(user_id, banned_id):
    validCases = []
    
    # 각 banned_id에 대해 매칭될 수 있는 user_id 찾기
    for p in permutations(user_id, len(banned_id)):
        match = True
        for i in range(len(banned_id)):
            if not userMatch(p[i], banned_id[i]):    # case의 각 요소가 banned_id와 일치하는지 확인
                match = False
                break
        
        if match:
            if set(p) not in validCases:
                validCases.append(set(p))            # 일치하지 않는 경우 집합에 추가
    
    return len(validCases)              # 가능한 경우의 수 반환



### 개념 정리 ###

# Permutations 함수
# permutations는 파이썬의 itertools 모듈에서 제공하는 함수로, 주어진 iterable에서 모든 가능한 순열을 생성
# 순열은 순서가 중요하게 고려되는 조합을 의미함. 예를 들어, ['A', 'B']의 순열은 ['A', 'B']와 ['B', 'A'] 두 가지가 있음.

# permutations 함수는 iterable과 r을 인자로 받아 iterable에서 r개의 요소를 뽑아 순서를 고려해 나열하는 모든 경우의 수를 반환
# permutations 함수는 반환값이 iterator이므로 list로 변환하여 사용하는 것이 가능
# permutations 함수는 중복을 허용하지 않으며, r을 지정하지 않으면 iterable의 길이만큼 r로 간주

# 백트래킹과 Permutations 함수의 차이
# 백트래킹은 모든 경우의 수를 탐색하며, 조건을 만족하는 경우에만 탐색을 진행
    # 재귀적으로 조건을 만족하는 경우만 탐색해 불필요한 연산의 횟수를 줄임.
    # 경우의 수를 직접 생성하지 않아 메모리를 절약할 수 있음. 
# Permutations 함수는 itertools 모듈에서 제공하는 함수로, iterable에서 모든 가능한 순열을 생성하는 함수
    # 모든 가능한 순열을 생성하고, 각 순열의 조건을 검사
    # 경우의 수를 직접 생성하므로 메모리를 많이 사용할 수 있으며, 시간 복잡도가 증가할 수 있음.

# set
# set은 중복을 허용하지 않는 자료형으로 순서가 없음.
