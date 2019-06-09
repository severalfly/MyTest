#_*_coding:utf-8_*_
#

import time 
class Msg(object):
    def __init__(self):
        pass

    def send(self):
        return 'success'

class TextMsg(Msg):
    """docstring for TextMsg"""
    def __init__(self, toUserName, fromUserName, content):
        super(TextMsg, self).__init__()
        self.__dict = dict()
        self.__dict['toUserName'] = toUserName
        self.__dict['fromUserName'] = fromUserName
        self.__dict['CreateTime'] = int(time.time())
        self.__dict['content'] = content
    
    def send(self):
        XmlForm = '''
        <xml>
        <ToUserName><![CDATA[{ToUserName}]]></ToUserName>
        <FromUserName><![CDATA[{FromUserName}]]></FromUserName>
        <CreateTime>{CreateTime}</CreateTime>
        <MsgType><![CDATA[text]]></MsgType>
        <Content><![CDATA[{Content}]]></Content>
        </xml>
        '''
        return XmlForm.format(**self.__dict)

class ImageMsg(Msg):
    """docstring for ImageMsg"""
    def __init__(self, toUserName, fromUserName, mediaId):
        super(ImageMsg, self).__init__()
        self.__dict = dict()
        self.__dict['toUserName'] = toUserName
        self.__dict['fromUserName'] = fromUserName
        self.__dict['CreateTime'] = int(time.time())
        self.__dict['mediaId'] = mediaId
    def send(self):
        XmlForm = '''
        <xml>
        <ToUserName><![CDATA[{ToUserName}]]></ToUserName>
        <FromUserName><![CDATA[{FromUserName}]]></FromUserName>
        <CreateTime>{CreateTime}</CreateTime>
        <MsgType><![CDATA[image]]></MsgType>
        <Image>
        <MediaId><![CDATA[{MediaId}]]></MediaId>
        </Image>
        </xml>
        '''
        return XmlForm.format(**self.__dict)
