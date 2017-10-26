from PIL import Image, ImageDraw, ImageFont

img = Image.open('test.png', mode="r")
dr = ImageDraw.Draw(img, mode=None)
font = ImageFont.truetype('simkai.ttf', 50)
dr.text((0,0), 'hello world', (255,0,255), font=font)
img.save('out.png')
