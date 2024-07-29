# 2019 카카오 개발자 겨울 인턴십

# user와 banned가 일치하는지 확인하는 함수
def usermatch(user, banned):
    if len(user) != len(banned):
        return False
    for u, b in zip(user, banned):
        if b == '*':
            continue
        if u != b:
            return False
    return True

# 백트래킹 함수
def backtrack(index, banned_id, user_id, current_set, result):
    # 모든 banned_id를 검사한 경우 결과에 추가
    if index == len(banned_id):
        result.add(frozenset(current_set))
        return

    for user in user_id:
        # 현재 선택된 user가 current_set에 없고, banned_id와 일치하면 추가
        if user not in current_set and usermatch(user, banned_id[index]):
            current_set.add(user)
            backtrack(index + 1, banned_id, user_id, current_set, result)
            current_set.remove(user)


def solution(user_id, banned_id):
    result = set()                                              # 가능한 제재 아이디 조합을 저장할 집합
    backtrack(0, banned_id, user_id, set(), result)             # 백트래킹을 시작
    return len(result)                                          # 가능한 경우의 수 반환