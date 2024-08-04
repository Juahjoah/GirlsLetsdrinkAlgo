

def checkBalanced(inputText):
    stack = []

    # 각 문장별로 비교하기
    for i in inputText:
        # 여는 괄호일 경우, 담기
        if i == "(" or i == "[":
            stack.append(i)

        # 닫는 괄호가 나왔을 경우, 꺼내서 비교하기
        elif i == ")" or i == "]":
            # stack이 비어있다면 짝이 맞지 않음
            if not stack:
                return "no"
            top = stack.pop()
            if i == ")" and top != "(":
                return "no"
            elif i == "]" and top != "[":
                return "no"

    # stack에 무언가 남아있다면, 짝이 맞지 않은 것
    if stack :
        return "no"

    # 해당하지 않으면 짝이 맞음.
    return "yes"


while True:
    # inputText = input().strip()
    inputText = input().rstrip()
    # 맨 마지막 줄에 온점이 들어오는 경우 끝남.
    if inputText == ".":
        break
    print(checkBalanced(inputText))


# 공백과 .만 있는 경우를 고민했으나, rstrip()을 이용해 해결함.

# strip()은 양쪽 공백을 제거해줌.
# restirp()은 오른쪽 공백을 제거해줌. = "." 이 외의 다른 문자, 공백이 있는 상황을 고려함.
