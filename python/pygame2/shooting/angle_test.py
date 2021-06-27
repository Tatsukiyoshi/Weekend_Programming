import pgzrun
import math

WIDTH = 800
HEIGHT = 600

shooter = Actor('shooter.png', (400, 500))
enemy = Actor('enemy.png', (100, 100))      # 左側の敵
enemy2 = Actor('enemy.png', (700, 100))     # 右側の敵

def draw():
    screen.clear()
    shooter.draw()
    enemy.draw()
    enemy2.draw()

    # 左側の敵からの角度算出
    angle = enemy.angle_to(shooter)
    rad = math.radians(-angle)
    x = math.cos(rad)
    y = math.sin(rad)
    screen.draw.text('angle = ' + str(angle), (50, 300), color='YELLOW', fontsize=32)
    screen.draw.text('x = ' + str(x), (50, 350), color='YELLOW', fontsize=32)
    screen.draw.text('y = ' + str(y), (50, 400), color='YELLOW', fontsize=32)

    # 右側の敵からの角度算出
    angle = enemy2.angle_to(shooter)
    rad = math.radians(-angle)
    x = math.cos(rad)
    y = math.sin(rad)
    screen.draw.text('angle = ' + str(angle), (450, 300), color='YELLOW', fontsize=32)
    screen.draw.text('x = ' + str(x), (450, 350), color='YELLOW', fontsize=32)
    screen.draw.text('y = ' + str(y), (450, 400), color='YELLOW', fontsize=32)

pgzrun.go()
