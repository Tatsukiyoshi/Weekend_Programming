import pgzrun
import random

WIDTH = 400
HEIGHT = 600

rocket = Actor('rocket', center=(200, 300))

star = []
for i in range(20):
    rect = Rect((random.randrange(WIDTH),
                 random.randrange(HEIGHT)), (2, 2))
    star.append(rect)

speed = 0           # 速度
acceleration = 0.1  # 加速度
key_flg = False     # UPキーが押されるとTrue
status = 0          # 0:Opening、1:ゲーム中

def draw():
    global status
    screen.clear()

    # 星の描画
    for i in range(20):
        screen.draw.rect(star[i], 'WHITE')

    # 着陸台の描画
    for i in range(50):
        screen.draw.line((150 - i * 3, 550 + i), (250 + i * 3, 550 + i), 'GRAY')

    if status == 0: # オープニング
        # ロケットの炎
        for i in range(10):
            # ロケットの噴射
            screen.draw.circle(rocket.midbottom, i + 1, (255, i * 20, 0))
        
        # ゲームタイトル
        screen.draw.text("Moon Lander", (50, 100), owidth=1.5, ocolor=(255, 255, 0), color=(0, 0, 0), fontsize=64)
    elif status == 1: #ゲーム中
        if key_flg:     # UPキーが押されたら炎を噴出
            for i in range(10):
                screen.draw.circle(rocket.midbottom, i + 1, (255, i * 20, 0))

    rocket.draw()

def on_key_down(key):
    global status
    if key == keys.SPACE:
        if status == 0:
            status = 1

def update():
    global speed        # グローバル変数
    global acceleration # グローバル変数
    global key_flg      # グローバル変数
    global status       # グローバル変数

    if status == 1:
        if keyboard.up:      # UPキーが押されていた場合の処理
            key_flg = True
            acceleration = -0.1 # 加速度を-0.1にする
        else:
            key_flg = False
            acceleration = 0.1  # 加速度を0.1にする
        speed += acceleration   # 速度に加速度を加える
        rocket.y += speed       # ロケットのY座標に速度を加える

pgzrun.go()
