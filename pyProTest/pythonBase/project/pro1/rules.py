class Rule(object):
	"""docstring for Rule"""
	def __init__(self):
		super(Rule, self).__init__()
	def action(self, block, handler):
		handler.start(self.type)
		handler.feed(block)
		handler.end(self.type)
		return True
class HeadingRule(Rule):
	"""标题占一行，最多70个字符，并且不以冒号结尾"""
	def __init__(self):
		super(HeadingRule, self).__init__()
	type = 'heading'
	def condition(self, block):
		return not '\n' in block and len(block) <= 70 and not block[-1] == ':'	
class TitleRule(Rule):
	"""题目是文档的第一个块，但是前提是它是大标题"""
	def __init__(self):
		super(TitleRule, self).__init__()
	type = 'title'
	first = True		
	def condition(self, block):
		if not self.first:
			return False;
		self.first = False
		return HeadingRule.condition(self, block)
class ListItemRule(Rule):
	"""标题是以连字符开始的段落，作为格式化的一部分，要移除连字符"""
	type = 'listitem'
	def __init__(self):
		super(ListItemRule, self).__init__()
	def condition(self, block):
		return block[0]=='-'
	def action(self, block, handler):
		handler.start(self.type)
		handler.feed(block[1:].strip())
		handler.end(self.type)

class ListRule(ListItemRule):
	"""列表从不是列表项的块和随后的列表项之间，在最后一个连续列表项之后结束"""
	type = 'list'
	inside = False
	def __init__(self):
		super(ListRule, self).__init__()
	
	def condition(self, block):
		return True
	def action(self, block, handler):
		if not self.inside and ListItemRule.condition(self, block):
			handler.start(self.type)
			self.inside = True

		elif self.inside and not ListItemRule.condition(self, block):
			handler.end(self.type)
			self.inside = False
		return False

class ParagraphRule(Rule):
	"""docstring for ParagraphRule"""
	def __init__(self):
		super(ParagraphRule, self).__init__()
	type = 'prograph'
	def condition(self, block):
		return True
		
