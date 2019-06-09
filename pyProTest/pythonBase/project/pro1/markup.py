import sys, re
from handlers import *
from util import *
from rules import *

class Parser(object):
	"""读法分析器读取文本文件，应用规则并且控制处理程序"""
	def __init__(self, handler):
		super(Parser, self).__init__()
		self.handler = handler
		self.rules = []
		self.filters = []

	def addRule(self, rule):
		self.rules.append(rule)
	def addFilter(self, pattern, name):
		def filter(block, Handler):
			return re.sub(pattern, handler.sub(name), block)
		self.filters.append(filter)
	def parse(self, file):
		self.handler.start('document')
		for block in blocks(file):
			for filter in self.filters:
				block = filter(block, self.handler)
			for rule in self.rules:
				if rule.condition(block):
					last = rule.action(block, self.handler)
					if last:
						break
		self.handler.end('document')

class BasicTextParase(Parser):
	"""在构造中增加规则和过滤器的具体语法分析器"""
	def __init__(self, handler):
		Parser.__init__(self, handler)
		self.handler = handler
		self.addRule(ListRule())
		self.addRule(ListItemRule())
		self.addRule(TitleRule())
		self.addRule(HeadingRule())
		self.addRule(ParagraphRule())

		self.addFilter(r'\*(.+?)\*', 'emphasis')
		self.addFilter(r'(http://[\.a-zA-Z/]+)', 'url')
		# self.addFilter(r'', 'mail')

handler = HTMLRender()
parser = BasicTextParase(handler)
parser.parse(open('test_input.txt'))
