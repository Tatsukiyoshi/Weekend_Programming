# coding: utf-8
# sample01.py

import os
import cv2

try:
#   https://note.nkmk.me/python-script-file-path/
#   img = cv2.imread('F:\\Program\\Programming_study\\python\\opencv\\sample\\sample01.png', cv2.IMREAD_COLOR)
    pngpath = os.path.join(os.path.dirname(__file__), '..\\sample\\sample01.png')
    img = cv2.imread(pngpath, cv2.IMREAD_COLOR)
    if img is None:
        raise FileNotFoundError('ファイルが見つかりません。')

    cv2.imshow('sample01', img) # オリジナル

    dst1 = cv2.flip(img, 0) # 上下反転
    cv2.imshow('sample02', dst1)

    dst2 = cv2.flip(img, 1) # 左右反転
    cv2.imshow('sample03', dst2)

    dst3 = cv2.flip(img, -1) # 上下左右反転
    cv2.imshow('sample04', dst3)

    cv2.waitKey(0)
    cv2.destroyAllWindows()

except FileNotFoundError as e:
    print(e)
