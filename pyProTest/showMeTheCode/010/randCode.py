from PIL import Image, ImageDraw, ImageFont
import random
import uuid

width  = 80
height = 40

def rndCode():
    return (random.randint(10, 255), random.randint(30, 255), random.randint(10, 230))

font = ImageFont.truetype('simkai.ttf', size=25)
img = Image.new(mode='RGB', size=(width, height))
draw = ImageDraw.Draw(img)
s = str(uuid.uuid4()).replace('-', '')[0:4]
draw.text((0,0), s, font=font, fill=rndCode())
for x in range(1000):
    draw.point([random.randint(0,width), random.randint(0,height)], fill=rndCode())
# img.show()
img.save('test.png')
