# from solution import *

def solution(survey, choices):
    answer = ''
    
    # 각 점수를 담을 변수 생성
    mbti = [("R", "T"), ("C", "F"), ("J", "M"), ("A", "N")]
    mbti_type = {
        "R": 0, "T": 0,
        "C": 0, "F": 0,
        "J": 0, "M": 0,
        "A": 0, "N": 0,
    }

    for i in range(len(choices)):
        if choices[i] <= 4:
            mbti_type[survey[i][0]] += 4 - choices[i]
        # elif choices[i] > 4:
        else:
            mbti_type[survey[i][1]] += choices[i] - 4
    
    # 각 번호별 유형을 비교해서 큰 값을 담기
    # 동일하다고 해도, 어차피 사전 순으로 빠른 L이 들어가야 함.
    for L, R in mbti:
        if mbti_type[L] >= mbti_type[R]:
            answer += L
        # elif mbti_type[L] < mbti_type[R]:
        else:
            answer += R
    
    return answer