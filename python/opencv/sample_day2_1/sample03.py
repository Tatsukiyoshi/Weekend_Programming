# coding: utf-8
# sample03.py

import os
import cv2

try:
#   https://note.nkmk.me/python-script-file-path/
#   img = cv2.imread('F:\\Program\\Programming_study\\python\\opencv\\sample\\sample01.png', cv2.IMREAD_COLOR)
    pngpath = os.path.join(os.path.dirname(__file__), '..\\sample\\sample01.png')
    img = cv2.imread(pngpath, cv2.IMREAD_COLOR)
    if img is None:
        raise FileNotFoundError('ファイルが見つかりません。')

    # シングルチャンネルに変換する
    blue, green, red = cv2.split(img)

    # 変換した各チャンネルを表示する
    cv2.imshow('sample01.png/blue',  blue)
    cv2.imshow('sample01.png/green', green)
    cv2.imshow('sample01.png/red',   red)

    cv2.waitKey(0)
    cv2.destroyAllWindows()

except FileNotFoundError as e:
    print(e)

