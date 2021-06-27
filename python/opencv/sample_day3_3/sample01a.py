# coding: utf-8
# sample01a.py

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

    rows, cols, ch = img.shape

    # 元画像の座標
    pts1 = np.float32([[0, 0], [cols, 0], [0, rows], [cols, rows]])

    # 変換後の座標（変更）
    pts2 = np.float32([[0, 0], [cols, 100], [0, rows], [cols, rows - 100]])

    # 透視変換行列を求める
    M = cv2.getPerspectiveTransform(pts1, pts2)

    # 透視変換
    dst = cv2.warpPerspective(img, M, (cols, rows))

    cv2.imshow('sample01', dst) # 説明では、sample02とある

    cv2.waitKey(0)
    cv2.destroyAllWindows()

except FileNotFoundError as e:
    print(e)
