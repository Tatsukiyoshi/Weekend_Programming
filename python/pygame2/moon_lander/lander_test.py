import pgzrun

WIDTH = 400
HEIGHT = 600

rocket = Actor('rocket', center=(200, 100))

speed = 0           # 速度
acceleration = 0.1  # 加速度
key_flg = False     # UPキーが押されるとTrue

def draw():
    screen.clear()
    if key_flg:     # UPキーが押されたら炎を噴出
        for i in range(10):
            screen.draw.circle(rocket.midbottom, i + 1, (255, i * 20, 0))
    rocket.draw()

def update():
    global speed        # グローバル変数
    global acceleration # グローバル変数
    global key_flg      # グローバル変数

    if keyboard.up:      # UPキーが押されていた場合の処理
        key_flg = True
        acceleration = -0.1 # 加速度を-0.1にする
    else:
        key_flg = False
        acceleration = 0.1  # 加速度を0.1にする
    speed += acceleration   # 速度に加速度を加える
    rocket.y += speed       # ロケットのY座標に速度を加える

pgzrun.go()
