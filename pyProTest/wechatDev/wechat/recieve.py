#  _*_utf-8_*_
#  
#  

import xml.etree.ElementTree as ET

def parse_xml(web_data):
    if len(web_data) ==0:
        return None
    xmlData= ET.fromstring(web_data)
    msg_type = xmlData.find('MsgType').text
    if msg_type == 'text':
        return TextMsg(xmlData)
    elif msg_type == 'image':
        return ImageMsg(xmlData)


class Msg(object):
    """docstring for Msg"""
    def __init__(self, xmlData):
        super(Msg, self).__init__()
        self.FromUserName = xmlData.find('ToUserName').text        
        self.FromUserName = xmlData.find('FromUserName').text        
        self.CreateTime = xmlData.find('CreateTime').text        
        self.MsgType = xmlData.find('MsgType').text        
        self.MsgId = xmlData.find('MsgId').text        

class TextMsg(Msg):
    """docstring for TextMsg"""
    def __init__(self, xmlData):
        super(TextMsg, self).__init__()
        self.Content = xmlData.find('Content').text.encode('utf-8')

class ImageMsg(Msg):
    """docstring for ImageMsg"""
    def __init__(self, xmlData):
        super(ImageMsg, self).__init__()
        self.PicUrl = xmlData.find('PicUrl').text
        self.MediaId = xmlData.find('MediaId').text
        
        
