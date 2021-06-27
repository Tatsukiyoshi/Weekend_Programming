# coding: utf-8
"""
７章のチャレンジ問題４
http://tinyurl.com/z2m2ll5

数字を当てるゲーム
・繰り返し入力できるようにしておき、qを入力すると終了
・数字があらかじめ用意した正解（リスト）にあれば、正解と出力する
　なければ、不正解と出力する
・数字またはｑ以外を入力した場合、数字を入力するか、ｑで終了しますと出力する
"""

# 正解リスト
Corrects = (2, 4, 6, 9, 11)

try: 
    # 無限ループ
    while True:
        flag = 0

        # 入力する
        print("Type q to quit")
        answer = input("Please input a number!")
        if answer == "q":
            break

        # 正解チェック
        for Correct in Corrects:
            # 正解の場合
            if int(answer) == Correct:
                print("Exactly!")
                flag = 1
                continue
        # 不正解の場合
        if flag == 0:
            print("Not exactly!")

# 例外処理
except ValueError:
    print("Please input a number or q!")

