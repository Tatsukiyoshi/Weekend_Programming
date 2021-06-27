# coding: utf-8
# KEY TEST
import pgzrun

def update():
    # SPACE キーが押されているか？
    if keyboard.space == True:
        print("SPACE")

# 何らかのキーが押されたら実行される
def on_key_down(key):
    # key には押されたキーの情報が入る
    print(key)

# 何らかのキーから指が離れたら実行される
def on_key_up(key):
    # key には押されたキーの情報が入る
    print(key)

pgzrun.go()
