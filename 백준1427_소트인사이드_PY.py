N =list(map(int, list(input())))

N.sort(reverse=True)
for i in N:
    print(i, end='', flush = True)

#http://cigiko.cafe24.com/python-%EC%A0%95%EB%A0%AC%ED%95%98%EA%B8%B0-sort%EC%99%80-sorted/
#sort_reverse인자(내림차순)
#https://m.blog.naver.com/PostView.nhn?blogId=chandong83&logNo=221160472657&proxyReferer=https%3A%2F%2Fwww.google.com%2F
#print함수 개행없이 쓰기