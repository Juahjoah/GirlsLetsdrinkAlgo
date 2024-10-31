def binary_search():

    start = max(input_list)
    end = sum(input_list)
    answer = end

    max_len = max(input_list)

    while start <= end:
        # 매우 큰 값으로 블루레이 크기를 일단 정한 다음에, 계속해서 줄여나가는 형태로 구현
        mid = (start + end) // 2

        # 중간 지점이 끝 지점보다 작은 경우에는 start 값을 증가 시켜서 값을 담을 배열의 크기를 늘려줌.
        if mid < max_len:
            start = mid + 1
            continue

        sum_len = 0         # 지금까지 담긴 강의의 총 시간
        cnt = 1         # M과 비교해 블루레이 갯수
        # 강의를 집어 넣어보기
        for i in range(N):
            # 강의 시간의 합이 mid 값을 넣게 되면, 다른 블루레이로 교체
            if sum_len + input_list[i] > mid:
                cnt += 1
                sum_len = input_list[i]

                # 여기서, 더이상 늘릴 블루레이가 없다면?
                if cnt > M:
                    # 현재  mid 값은 사용할 수가 없으니 크기를 늘리기
                    start = mid + 1
                    break

            # 값이 넘지 않아 기존의 블루레이에 넣을 수 있다면, 블루레이에 추가
            else:
                sum_len += input_list[i]

        # while문 내부에서 for-else
        # break로 끊기지 않았다 = 값이 잘 담겼다
        else:
            # 그럼 크기를 줄여 한 번 더 시도해보기
            end = mid - 1
            answer = min(mid, answer)

    return answer


N, M = map(int, input().split())
input_list = list(map(int, input().split()))

print(binary_search())