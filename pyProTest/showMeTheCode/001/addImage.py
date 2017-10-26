from PIL import Image, ImageDraw, ImageFont

img = Image.open('test.png', mode="r")
dr = ImageDraw.Draw(img, mode=None)
font = ImageFont.truetype('simkai.ttf', 50)
dr.text((0,0), 'hello world', (255,0,255), font=font)
img.save('out.png')

# 下面准备把字放在右上角

h = 20
img = Image.open('test.png', mode="r")
dr = ImageDraw.Draw(img, mode=None)
x, y = img.width, img.height
font = ImageFont.truetype(font='simkai.ttf', size=h, index=0, encoding="", layout_engine=None)
dr.text((x - h,0), '8', fill=(255,0,255), font=font, anchor=None)
img.save('out.png')
