# coding: utf-8
# sample04.py

import os
import OpenSSL.rand
import cv2
import numpy as np

try:
#   https://note.nkmk.me/python-script-file-path/
#   img = cv2.imread('F:\\Program\\Programming_study\\python\\opencv\\sample\\sample01.png', cv2.IMREAD_COLOR)
    pngpath = os.path.join(os.path.dirname(__file__), '..\\sample\\sample01.png')
    img = cv2.imread(pngpath, cv2.IMREAD_COLOR)
    if img is None:
        raise FileNotFoundError('ファイルが見つかりません。')
    
    height, width = img.shape[:2]

    # 読み込んだ画像と同じサイズ／同じデータタイプで
    # シングルチャンネルのゼロデータを作成する
    zeros = np.zeros((height, width), img.dtype)

    # 読み込んだ画像の各色を分離する
    blue, green, red = cv2.split(img)

    # 分離した色成分とゼロデータを合成して
    # ３チャンネルカラー画像を生成する
    blue = cv2.merge((blue, zeros, zeros))
    green = cv2.merge((zeros, green, zeros))
    red = cv2.merge((zeros, zeros, red))

    #３チャンネルカラー画像を表示する
    cv2.imshow('sample_blue', blue)
    cv2.imshow('sample_green', green)
    cv2.imshow('sample_red', red)

    cv2.waitKey(0)
    cv2.destroyAllWindows()

except FileNotFoundError as e:
    print(e)
    