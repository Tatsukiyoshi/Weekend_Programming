import pgzrun

WIDTH = 400
HEIGHT = 200

file_name = 'alien'
alien = Actor(file_name, midright=(0, 100))

def draw():
    screen.clear()
    alien.draw()

def update():
    alien.x += 1
    # alien.left += 1

pgzrun.go()
