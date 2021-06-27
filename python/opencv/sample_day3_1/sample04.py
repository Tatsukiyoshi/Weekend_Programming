# coding: utf-8
# sample04.py

import os
import cv2

try:
#   https://note.nkmk.me/python-script-file-path/
#   img = cv2.imread('F:\\Program\\Programming_study\\python\\opencv\\sample\\sample01.png', cv2.IMREAD_COLOR)
    pngpath = os.path.join(os.path.dirname(__file__), '..\\sample\\sample01.png')
    img = cv2.imread(pngpath, cv2.IMREAD_COLOR)
    if img is None:
        raise FileNotFoundError('ファイルが見つかりません。')

    # 目の部分の座標
    # img = img[325: 375, 175: 225]
    img = img[80: 95, 80: 150]
    cv2.imshow('sample01', img)

    # ８倍にする
    size = (img.shape[1] * 8, img.shape[0] * 8)

    # 最近傍補間
    dst1 = cv2.resize(img, size, interpolation=cv2.INTER_NEAREST)
    cv2.imshow('sample02', dst1)

    # ピクセル領域の関係
    dst2 = cv2.resize(img, size, interpolation=cv2.INTER_AREA)
    cv2.imshow('sample03', dst2)

    # ハイキュービック
    dst3 = cv2.resize(img, size, interpolation=cv2.INTER_CUBIC)
    cv2.imshow('sample04', dst3)

    # ランツォシュ
    dst4 = cv2.resize(img, size, interpolation=cv2.INTER_LANCZOS4)
    cv2.imshow('sample05', dst4)

    cv2.waitKey(0)
    cv2.destroyAllWindows()

except FileNotFoundError as e:
    print(e)
