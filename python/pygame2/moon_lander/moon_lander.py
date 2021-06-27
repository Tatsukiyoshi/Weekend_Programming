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
status = 0          # 0:Opening、1:ゲーム中 2:GAME CLEAR 3:GAME OVER
anime_r = animate(None)

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
    elif status == 2:
        screen.draw.text("GAME CLEAR", (40, 300), owidth=1.5, ocolor='YELLOW', color='BLACK', fontsize=64)
    else:
        screen.draw.text("GAME  OVER", (50, 300), owidth=1.5, ocolor='RED', color='BLACK', fontsize=64)

    rocket.draw()

def on_key_down(key):
    global status, speed, acceleration
    if key == keys.SPACE and anime_r.running != True:
        if status == 0 or status == 2 or status == 3:
            status = 1
            rocket.y = 200
            speed = 0
            acceleration = 0.1
            rocket.angle = 0

def update():
    global speed, acceleration, key_flg, status, anime_r        # グローバル変数

    if status == 1:
        if keyboard.up:      # UPキーが押されていた場合の処理
            key_flg = True
            acceleration = -0.1 # 加速度を-0.1にする
        else:
            key_flg = False
            acceleration = 0.1  # 加速度を0.1にする
        speed += acceleration   # 速度に加速度を加える
        rocket.y += speed       # ロケットのY座標に速度を加える

        if rocket.y > 500:
            if speed < 1.0:
                status = 2 # GAME CLEAR
            else:
                status = 3 # GAME OVER

                # 着陸失敗でロケットが傾くアニメ
                anime_r = animate(rocket, 'bounce_start_end', 1, angle=45)

pgzrun.go()
