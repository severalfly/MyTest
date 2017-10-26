from asyncore import dispatcher
from asynchat import async_chat

import socket, asyncore
from chatServer import ChatServer

PORT = 8080
NAME = 'TestChat'

class ChatSession(async_chat):
	"""docstring for ChatSession"""
	def __init__(self, server, sock):
		print(test)
		super(ChatSession, self).__init__(sock)
		self.server = server
		self.set_terminator("\r\n")		
		self.data=[]
		self.push('Welcome to %s\r\n' % self.server.name)

	def collect_incoming_data(self, data):
		self.data.append(data)

	def found_terminator(self):
		line = ''.join(self.data)
		self.data = []
		self.server.broadcast(line)

	def handle_close(self):
		async_chat.handle_close(self)
		self.server.disconnect(self)

class ChatServer(dispatcher):
	"""docstring for ChatServer"""
	def __init__(self, port, name):
		super(ChatServer, self).__init__()
		self.port = port
		self.name = name
		self.create_socket(family=socket.AF_INET, type=socket.SOCK_STREAM)
		self.set_reuse_addr()
		self.bind(('', port))
		self.listen(5)
		self.sessions = []

	def disconnect(self, session):
		self.sessions.remove(session)

	def broadcast(self, line):
		for session in self.sessions:
			session.push(line + '\r\n')

	def handle_accept(self):
		conn, addr = self.accept()
		print('test')
		self.sessions.append(ChatSession(self, conn))
		

if __name__ == '__main__':
	s = ChatServer(PORT, NAME)
	try:
		asyncore.loop()
	except Exception as e:
		pass

