# Part 1.繰り返しによる背景の表示
# Part 2.条件による表示
import pgzrun

WIDTH = 700
HEIGHT = 490

# MAP情報(1の場所がbox)
map_data = [[1, 0, 1, 0, 0, 0, 0, 1, 0, 0],
            [1, 0, 1, 1, 1, 0, 1, 1, 1, 0],
            [1, 0, 0, 0, 0, 0, 0, 0, 0, 0],
            [1, 1, 0, 1, 1, 1, 1, 1, 1, 0],
            [0, 0, 0, 1, 0, 0, 0, 1, 1, 0],
            [0, 1, 1, 1, 0, 1, 0, 0, 0, 1],
            [0, 0, 0, 0, 0, 1, 0, 1, 0, 0]]

# playerの現在位置
location = [0, 1]

# プレイヤー
player = Actor('player', topleft=(70, 0))

# 床のタイル
floor = Actor('floor', topleft=(0, 0))

# 箱
box = Actor('box', topleft=(0, 0))

# 出口の看板
exit = Actor('exit', topleft=(630, 420))

def draw():
    screen.clear()
    for y in range(7):
        for x in range(10):
            # floorの描画
            floor.topleft = (70 * x, 70 * y)
            floor.draw()
            # boxの描画
            if map_data[y][x] != 0:
                box.topleft=(70 * x, 70 * y)
                box.draw()
    exit.draw()
    player.draw()

def on_key_down(key):
    if key == keys.UP:
        # プレイヤーが上端でなければ
        if location[0] >= 1:
            # プレイヤーの進む方向がboxでなければ進む
            if map_data[location[0] - 1][location[1]] != 1:
                location[0] -= 1
                player.y -= 70

    if key == keys.DOWN:
        # プレイヤーが下端でなければ
        if location[0] <= 5:
            # プレイヤーの進む方向がboxでなければ進む
            if map_data[location[0] + 1][location[1]] != 1:
                location[0] += 1
                player.y += 70
    
    if key == keys.LEFT:
        # プレイヤーが左端でなければ
        if location[1] >= 1:
            # プレイヤーの進む方向がboxでなければ進む
            if map_data[location[0]][location[1] - 1] != 1:
                location[1] -= 1
                player.x -= 70
        
    if key == keys.RIGHT:
        # プレイヤーが右端でなければ
        if location[1] <= 8:
            # プレイヤーの進む方向がboxでなければ進む
            if map_data[location[0]][location[1] + 1] != 1:
                location[1] += 1
                player.x += 70

pgzrun.go()
