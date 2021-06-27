# coding: utf-8
# sample01.py

import os
import cv2
import numpy as np

try:
#   https://note.nkmk.me/python-script-file-path/
#   img = cv2.imread('F:\\Program\\Programming_study\\python\\opencv\\sample\\sample04.png', cv2.IMREAD_COLOR)
    pngpath = os.path.join(os.path.dirname(__file__), '..\\sample\\sample04.png')
    img = cv2.imread(pngpath, cv2.IMREAD_COLOR)
    if img is None:
        raise FileNotFoundError('ファイルが見つかりません。')
    
    cv2.imshow('sample04.png', img)

    # メディアンフィルタでの平滑化
    # アパーチャサイズは3
    medi1 = median = cv2.medianBlur(img, 3)
    cv2.imshow('sample04.png/3', medi1)

    # アパーチャサイズは5
    medi5 = median = cv2.medianBlur(img, 5)
    cv2.imshow('sample04.png/5', medi5)

    cv2.waitKey(0)
    cv2.destroyAllWindows()

except FileNotFoundError as e:
    print(e)


