# coding: utf-8
# sample02.py

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

    width  = img.shape[1]
    height = img.shape[0]

    # デフォルトのバイリニアで２倍のサイズにする
    dst1 = cv2.resize(img, (width * 2, height * 2))
    cv2.imshow('sample02', dst1)

    # デフォルトのバイリニアで半分のサイズにする
    dst2 = cv2.resize(img, (int(width / 2), int(height / 2)))
    cv2.imshow('sample03', dst2)

    cv2.waitKey(0)
    cv2.destroyAllWindows()

except FileNotFoundError as e:
    print(e)

