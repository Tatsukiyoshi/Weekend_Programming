import pgzrun
import math

WIDTH = 800
HEIGHT = 600

shooter_hp = 10 # playerのHP（0になるとゲームオーバー）
s_missiles = [] # playerのミサイルを格納するlist

enemy_hp = 30   # 敵のHP（0になるとゲームクリア）
turn = False    # 敵を左右に移動させるためのフラグ
eshot = 60      # 60回カウントして、敵から自機へミサイルを発射する
e_missiles = [] # 敵のミサイルを格納するlist

shooter = Actor('shooter.png', (400, 500))
enemy = Actor('enemy.png', (400, 100))

def draw():
    screen.clear()

    # ミサイルの描画
    for missile in s_missiles:
        missile.draw()
    for missile in e_missiles:
        missile.draw()

    shooter.draw()
    enemy.draw()

    # HPの表示
    screen.draw.text('Enemy HP = ' + str(enemy_hp), (50, 50), color='YELLOW', fontsize=32)
    screen.draw.text('Shooter HP = ' + str(shooter_hp), (600, 50), color='YELLOW', fontsize=32)

def update():
    global enemy_hp, turn, eshot, shooter_hp

    # 自機のキー操作
    if keyboard.left:
        if shooter.x > 47:
            shooter.x -= 3
    
    if keyboard.right:
        if shooter.x < WIDTH - 47:
            shooter.x += 3

    # 敵を左右に動かす
    if turn:
        enemy.x += 5
        if enemy.x > WIDTH:
            turn = False
    else:
        enemy.x -= 5
        if enemy.x < 0:
            turn = True

    # 敵のミサイル描画
    if eshot == 0:
        angle = enemy.angle_to(shooter)
        missile1 = Actor('emissile.png', (enemy.x - 25, enemy.y + 10))
        missile2 = Actor('emissile.png', (enemy.x + 25, enemy.y + 10))
        missile1.angle = 90 + angle
        missile2.angle = 90 + angle
        e_missiles.append(missile1)
        e_missiles.append(missile2)
        eshot = 60
    else:
        eshot -= 1

    for missile in e_missiles:
        # 敵のミサイルの位置
        rad = math.radians(-(missile.angle - 90))
        missile.x += (math.cos(rad)) * 3
        missile.y += (math.sin(rad)) * 3

        # 判定用に敵のミサイルのRectを作成
        rect = Rect(missile.topleft, (11, 35))

        # 自機と敵のミサイルとの衝突判定
        if shooter.colliderect(rect):
            # 衝突したので、playerのHPを減らし、敵のミサイルを削除する
            shooter_hp -= 1
            e_missiles.remove(missile)

    # playerのミサイル描画
    for missile in s_missiles:
        missile.y -= 10

        # 判定用にplayerのミサイルのRectを作成
        rect = Rect(missile.topleft, (16, 22))

        # 敵とplayerのミサイルとの衝突判定
        if enemy.colliderect(rect):
            # 衝突したので、敵のHPを減らし、playerのミサイルを削除する
            enemy_hp -= 1
            s_missiles.remove(missile)

def on_key_down(key):
    global s_missiles

    if key == keys.SPACE:
        s_missiles.append(Actor('smissile.png', shooter.pos))

pgzrun.go()

