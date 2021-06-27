import pgzrun
import random
import math

WIDTH = 800
HEIGHT = 600

status = 0      # ゲームステータス(0:オープニング 1:ゲーム中 2:ゲームオーバー 3:ゲームクリア)

shooter_hp = 10 # playerのHP（0になるとゲームオーバー）
s_missiles = [] # playerのミサイルを格納するlist

enemy_hp = 30   # 敵のHP（0になるとゲームクリア）
turn = False    # 敵を左右に移動させるためのフラグ
eshot = 60      # 60回カウントして、敵から自機へミサイルを発射する
e_missiles = [] # 敵のミサイルを格納するlist

enemy = Actor('enemy.png', (400, 100))
shooter = Actor('shooter.png', (400, 500))

star = []
for i in range(30):
    rect = Rect((random.randrange(WIDTH), random.randrange(HEIGHT)), (2, 2))
    star.append(rect)

def draw():
    global status
    screen.clear()

    # 星の描画
    for i in range(len(star)):
        screen.draw.rect(star[i], 'WHITE')
    
    if status == 0: # オープニング
        # ゲームタイトル
        screen.draw.text('S P A C E  S H O O T E R', (100, 290), color='WHITE', gcolor='YELLOW', fontsize=72)

    elif status == 1:
        # ミサイルの描画
        for missile in s_missiles:
            missile.draw()
        for missile in e_missiles:
            missile.draw()

        # HPの表示
        screen.draw.text('Enemy HP = ' + str(enemy_hp), (50, 50), color='YELLOW', fontsize=32)
        screen.draw.text('Shooter HP = ' + str(shooter_hp), (600, 50), color='YELLOW', fontsize=32)

    elif status == 2:
        screen.draw.text('G A M E  O V E R', (200, 290), color='WHITE', gcolor='YELLOW', fontsize=72)

    else:
        screen.draw.text('G A M E  C L E A R', (180, 290), color='WHITE', gcolor='YELLOW', fontsize=72)

    shooter.draw()
    enemy.draw()

def update():
    global enemy_hp, shooter_hp, turn, eshot, status

    # 星の描画
    for i in range(len(star)):
        star[i].y += i
        if star[i].y > HEIGHT:
            star[i].y = 0

    if status == 1:
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
                # 衝突したので、playerのHPを減らす
                shooter_hp -= 1
                if shooter_hp == 0: # playerのHPが0になったら、ゲームオーバー
                    status = 2

                # 敵のミサイルを削除する
                e_missiles.remove(missile)

        # playerのミサイル描画
        for missile in s_missiles:
            missile.y -= 10

            # 判定用にplayerのミサイルのRectを作成
            rect = Rect(missile.topleft, (16, 22))

            # 敵とplayerのミサイルとの衝突判定
            if enemy.colliderect(rect):
                # 衝突したので、敵のHPを減らす
                enemy_hp -= 1
                if enemy_hp == 0:   # 敵のHPが0になったら、ゲームクリア
                    status = 3

                # playerのミサイルを削除する
                s_missiles.remove(missile)

def on_key_down(key):
    global status, s_missiles, e_missiles, enemy_hp, shooter_hp

    if key == keys.SPACE:
        if status == 0 or status == 2 or status == 3:   # オープニング／ゲームクリア／ゲームオーバー
            enemy_hp = 30
            shooter_hp = 10
            s_missiles = []
            e_missiles = []
            status = 1
        elif status == 1:   # ゲーム中
            s_missiles.append(Actor('smissile.png', shooter.pos))

pgzrun.go()
