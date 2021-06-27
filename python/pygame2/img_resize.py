from PIL import Image

img = Image.open('./images/alien.png')
img_resize = img.resize((70, 70))
img_resize.save('./images/player.png')
