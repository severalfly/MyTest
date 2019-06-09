# _*_ coding:utf-8 _*_
# http://www.360doc.com/content/17/1005/01/43284313_692298509.shtml



import json
import hashlib
from textwrap import dedent
from time import time
from uuid import uuid4
from flask import Flask, jsonify, request



class Blockchain(object):
    def __init__(self):
        self.chain = []
        self.current_transactions = []
        self.new_block(previous_hash = 1, proof=100)

    def new_block(self):
        # Create a new block and adds i to the chain
        pass
    def new_block(self, proof, previous_hash=None):
        block={
            'index':len(self.chain) + 1,
            'timestamp':time(),
            'transactions':self.current_transactions,
            'proof': proof,
            'previous_hash':previous_hash or self.hash(self.chain[-1]),
        }
        self.current_transactions =[]
        self.chain.append(block)
        return block


    # def new_transaction(self, sender, recipient, amount):
    #     # adds a new transaction to the list of transactions
    #     pass

    @staticmethod
    def hash(block):
        # Hashes a block
        block_string = json.dumps(block, sort_keys=True).encode()
        return hashlib.sha256(block_string).hexdigest()

    @property
    def last_block(self):
        # Return the last block in the chain
        return self.chain[-1]


    block = {
        'index':1,
        'timestamp':1514203334.2802432,
        'transactions':[
            {
                'sender':'851231231ee00',
                'recipient':'a77sdhfoasidff1f',
                'amount':5,
            }
        ],
        'proof':32492300,
        'previous_hash':'281934085702438'

    }

    def new_transaction(self, sender, recipient, amount):
        '''Creaetes a new transaction to go 
        into the next mined Block
        '''
        self.current_transactions.append({'sender':sender,
            'recipient':recipient,
            'amount':amount})
        return self.last_block['index'] + 1
    def proof_of_work(self, last_block):
        proof = 0
        while self.valid_proof(last_block, proof) is False:
            proof += 1
        return proof

    @staticmethod
    def valid_proof(last_proof, proof):
        guess = f'{last_proof}{proof}'.encode()
        guess_hash = hashlib.sha256(guess).hexdigest()
        return guess_hash[:4] == '0000'


app = Flask(__name__)
node_identifier = str(uuid4()).replace('-', '')
blockchain = Blockchain()

@app.route('/mine', methods=['GET'])
def mine():
    last_block = blockchain.last_block
    last_proof = last_block['proof']
    proof = blockchain.proof_of_work(last_proof)


    blockchain.new_transaction(sender = '0', recipient=node_identifier, amount=1)

    block = blockchain.new_block(proof)
    response = {
        'message':'New Block Forged',
        'index':block['index'],
        'transactions':block['transactions'],
        'proof':block['proof'],
        'previous_hash':block['previous_hash']
    }
    return jsonify(response), 200
    # return "We'll mine a new Block"



@app.route('/transactions/new', methods=["POST"])
def new_transaction():
    values = request.form
    # print(values)
    required = ['sender', 'recipient', 'amount']
    if not all(k in values for k in required):
        return 'Missing values', 400
    index = blockchain.new_transaction(values['sender'], values['recipient'], values['amount'])
    response = {'message':f'Transaction will be added to the Block {index}'}
    return jsonify(response), 201


@app.route('/chain', methods=["GET"])
def full_chain():
    response = {
        'chain':blockchain.chain,
        'length':len(blockchain.chain)
    }
    return jsonify(response), 200

if __name__ == '__main__':
    app.run(host='127.0.0.1',port=5000)
