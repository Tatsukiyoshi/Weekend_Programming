# coding: utf-8
# sample01.py

import os
import cv2

try:
#   https://note.nkmk.me/python-script-file-path/
    # 画像を読み込む
    pngpath = os.path.join(os.path.dirname(__file__), '..\\sample\\sample01.png')
    # グレースケールで読み込む
#   img1 = cv2.imread('F:\\Program\\Programming_study\\python\\opencv\\sample\\sample01.png', cv2.IMREAD_GRAYSCALE)
    img1 = cv2.imread(pngpath, cv2.IMREAD_GRAYSCALE)
    if img1 is None:
        raise FileNotFoundError('ファイルが見つかりません。') 

    # カラー画像で読み込む
#   img2 = cv2.imread('F:\\Program\\Programming_study\\python\\opencv\\sample\\sample01.png', cv2.IMREAD_COLOR)
    img2 = cv2.imread(pngpath, cv2.IMREAD_COLOR)
    if img2 is None:
        raise FileNotFoundError('ファイルが見つかりません。') 

    print(f'img1 : {img1.shape}') # 縦
    print(f'img2 : {img2.shape}') # 幅
    
except FileNotFoundError as e:
    print(e)
