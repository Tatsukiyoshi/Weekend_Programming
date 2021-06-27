# coding: utf-8
"""
９章のチャレンジ問題３
http://tinyurl.com/hll6t3q

リストのリストをＣＳＶファイルに書き出す
"""
import csv

lists = [["Top Gun", "Risky Business", "Minority Report"],["Titanic", "The Revenant", "Inception"],["Training Day", "Man on Fire", "Flight"]]

with open("lists.csv", "w", encoding="utf-8", newline='') as f:
    w = csv.writer(f, delimiter=",")
    for datalist in lists:
        w.writerow(datalist)
