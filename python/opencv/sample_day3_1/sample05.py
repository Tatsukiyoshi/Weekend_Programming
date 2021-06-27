# coding: utf-8
# sample05.py

import os
import cv2

try:
#   https://note.nkmk.me/python-script-file-path/
#   img = cv2.imread('F:\\Program\\Programming_study\\python\\opencv\\sample\\sample01.png', cv2.IMREAD_COLOR)
    pngpath = os.path.join(os.path.dirname(__file__), '..\\sample\\sample01.png')
    img = cv2.imread(pngpath, cv2.IMREAD_COLOR)
    if img is None:
        raise FileNotFoundError('ファイルが見つかりません。')

    cv2.imshow('sample01', img)

    # ０．１倍にする
    size = (int(img.shape[1] / 10), int(img.shape[0] / 10))

    # 縮小（最近傍補間）
    dst1 = cv2.resize(img, size, interpolation=cv2.INTER_NEAREST)

    # 元のサイズに戻す（最近傍補間）
    dst2 = cv2.resize(dst1, (img.shape[1], img.shape[0]), interpolation=cv2.INTER_NEAREST)

    cv2.imshow('sample02', dst2)

    cv2.waitKey(0)
    cv2.destroyAllWindows()

except FileNotFoundError as e:
    print(e)
