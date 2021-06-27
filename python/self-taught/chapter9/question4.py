# coding: utf-8
"""
９章のチャレンジ問題４
http://tinyurl.com/hll6t3q

リストのリストをＣＳＶファイルに書き出す（日本語バージョン）
"""
import csv

lists = [["トップガン", "卒業白書", "マイノリティ・リポート"],["タイタニック", "蘇えりし者", "インセプション"],["トレーニングデイ", "マイ・ボディガード", "フライト"]]

with open("jlists.csv", "w", encoding="utf-8", newline='') as f:
    w = csv.writer(f, delimiter=",")
    for datalist in lists:
        w.writerow(datalist)
