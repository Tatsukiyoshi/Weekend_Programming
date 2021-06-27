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

    x = 100
    y = 180

    # 切り抜きたい画像のサイズ
    width = 280
    height = 380

    # pythonのスライス機能で
    # 読み込んだndarrayから切り出す
    dst = img[y: (y + height), x: (x + width)]

    cv2.imshow('sample01', dst)
    cv2.waitKey(0)
    cv2.destroyAllWindows()

except FileNotFoundError as e:
    print(e)

