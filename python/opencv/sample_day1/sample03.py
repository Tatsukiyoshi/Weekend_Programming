# coding: utf-8
# sample03.py

import os
import cv2

try:
#   https://note.nkmk.me/python-script-file-path/
    # 画像を読み込む
#   img = cv2.imread('F:\\Program\\Programming_study\\python\\opencv\\sample\\sample01.png', cv2.IMREAD_COLOR)
    pngpath = os.path.join(os.path.dirname(__file__), '..\\sample\\sample01.png')
    img = cv2.imread(pngpath, cv2.IMREAD_COLOR)
    if img is None:
        raise FileNotFoundError('ファイルが見つかりません。')
    
    # 文字を表示する
    img = cv2.putText(img, 'Nikkei Software', (100, 50),  cv2.FONT_HERSHEY_SIMPLEX,        1, (0, 255.0), 1)
    img = cv2.putText(img, 'Nikkei Software', (100, 100), cv2.FONT_HERSHEY_PLAIN,          1, (0, 255.0), 1)
    img = cv2.putText(img, 'Nikkei Software', (100, 150), cv2.FONT_HERSHEY_DUPLEX,         1, (0, 255.0), 1)
    img = cv2.putText(img, 'Nikkei Software', (100, 200), cv2.FONT_HERSHEY_COMPLEX,        1, (0, 255.0), 1)
    img = cv2.putText(img, 'Nikkei Software', (100, 250), cv2.FONT_HERSHEY_TRIPLEX,        1, (0, 255.0), 1)
    img = cv2.putText(img, 'Nikkei Software', (100, 300), cv2.FONT_HERSHEY_COMPLEX_SMALL,  1, (0, 255.0), 1)
    img = cv2.putText(img, 'Nikkei Software', (100, 350), cv2.FONT_HERSHEY_SCRIPT_SIMPLEX, 1, (0, 255.0), 1)
    img = cv2.putText(img, 'Nikkei Software', (100, 400), cv2.FONT_HERSHEY_SCRIPT_COMPLEX, 1, (0, 255.0), 1)

    cv2.imshow('sample03', img)
    cv2.waitKey(0)
    cv2.destroyAllWindows()

except FileNotFoundError as e:
    print(e)
    