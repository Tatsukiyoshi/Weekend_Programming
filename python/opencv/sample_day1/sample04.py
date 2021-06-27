# coding: utf-8
# sample04.py

import os
import cv2

try:
#   https://note.nkmk.me/python-script-file-path/
    # 画像を読み込む
#   img = cv2.imread('F:\\Program\\Programming_study\\python\\opencv\\sample\\sample02.png', cv2.IMREAD_COLOR)
    pngpath = os.path.join(os.path.dirname(__file__), '..\\sample\\sample02.png')
    img = cv2.imread(pngpath, cv2.IMREAD_COLOR)
    if img is None:
        raise FileNotFoundError('ファイルが見つかりません。')
    
    # 円を描く
    img = cv2.circle(img, (250, 250), 100, (0, 255, 0), 3)

    cv2.imshow('sample04', img)
    cv2.waitKey(0)
    cv2.destroyAllWindows()

    # 画像を保存する
    cv2.imwrite('F:\\Program\\python\\opencv\\sample\\sample03.png', img)

except FileNotFoundError as e:
    print(e)
