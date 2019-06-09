from asyncore import dispatcher
import socket, asyncore
import logging


logging.basicConfig(level=logging.INFO, filename='mylog.log')
logging.info('start paraming')

PORT = 8080

class ChatServer(dispatcher):
	
	def handle_accept(self):
		conn, addr = self.accept()
		logging.info('connection attempt from')
		print('Connection attempt from', addr[0])

logging.info('start')
s= ChatServer()
s.create_socket(socket.AF_INET, socket.SOCK_STREAM)
# s.set_reuse_addr()
s.bind(('', PORT))
s.listen(5)
logging.info('will go into loop')

asyncore.loop()
