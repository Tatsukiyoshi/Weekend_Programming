import pgzrun
import random

WIDTH = 800
HEIGHT = 600

enemy = Actor('enemy.png', (400, 100))
shooter = Actor('shooter.png', (400, 500))

star = []
for i in range(30):
    rect = Rect((random.randrange(WIDTH), random.randrange(HEIGHT)), (2, 2))
    star.append(rect)

status = 0  # ゲームステータス

def draw():
    global status
    screen.clear()

    # 星の描画
    for i in range(len(star)):
        screen.draw.rect(star[i], 'WHITE')
    
    if status == 0: # オープニング
        # ゲームタイトル
        screen.draw.text('S P A C E  S H O O T E R', (100, 290), color='WHITE', gcolor='YELLOW', fontsize=72)

        enemy.draw()
        shooter.draw()

pgzrun.go()
