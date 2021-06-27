from PIL import Image

img = Image.open('./images/spaceShips_003.png')
img_resize = img.resize((60, 60))
img_rotate = img_resize.transpose(Image.ROTATE_180)
img_rotate.save('./images/shooter.png')
