# coding: utf-8
# sample02.py

import os
import cv2
import numpy as np

try:
#   https://note.nkmk.me/python-script-file-path/
#   img = cv2.imread('F:\\Program\\Programming_study\\python\\opencv\\sample\\sample01.png', cv2.IMREAD_COLOR)
    pngpath = os.path.join(os.path.dirname(__file__), '..\\sample\\sample01.png')
    img = cv2.imread(pngpath, cv2.IMREAD_COLOR)
    if img is None:
        raise FileNotFoundError('ファイルが見つかりません。')
    
    # ガウシアンフィルタでの平滑化
    # 平滑化カーネルサーズが(5, 5)
    # ガウシアンカーネルのＸ方向の標準偏差が1.3
    gaus = cv2.GaussianBlur(img, ksize=(5, 5), sigmaX=1.3)
    cv2.imshow('sample01/gaus', gaus)

    # バイラテラルフィルタでの平滑化
    # 近傍領域の直径が9
    # 色のフィルタシグマが75
    # 座標フィルタシグマが75
    bila = cv2.bilateralFilter(img, 9, 75, 75)
    cv2.imshow('sample01/bila', bila)

    cv2.waitKey(0)
    cv2.destroyAllWindows()

except FileNotFoundError as e:
    print(e)


