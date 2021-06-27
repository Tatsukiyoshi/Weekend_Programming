import pgzrun

WIDTH = 400
HEIGHT = 600

def draw():
    screen.clear()
    rect = Rect((150, 50), (100, 100))
    screen.draw.filled_rect(rect, 'WHITE')
    screen.draw.circle((200, 270), 50, 'RED')
    screen.draw.line((50, 370), (350, 450), 'GREEN')
    screen.draw.text('Pygame Zero', (50, 480), color='YELLOW', fontsize=70)

pgzrun.go()
