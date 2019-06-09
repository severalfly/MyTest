from asyncore import dispatcher
import socket, asyncore

PORT = 8080

class ChatServer(dispatcher):
	"""docstring for ChatServer"""
	def __init__(self, port):
		super(ChatServer, self).__init__()
		self.create_socket(family=socket.AF_INET, type=socket.SOCK_STREAM)
		self.set_reuse_addr()
		self.bind(('', port))
		self.listen(5)
	
	def handle_accept(self):
		conn, addr = self.accept()
		print('Connection attempt from', addr[0])	

if __name__ == '__main__':
	s = ChatServer(PORT)
	try:
		asyncore.loop()
	except Exception as e:
		pass
