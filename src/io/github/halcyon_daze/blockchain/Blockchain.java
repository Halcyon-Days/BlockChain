package io.github.halcyon_daze.blockchain;

import java.security.NoSuchAlgorithmException;
import java.util.LinkedList;

/*
 * Created with reference to python tutorial: https://hackernoon.com/learn-blockchains-by-building-one-117428612f46
 */
public class Blockchain {

    LinkedList<Transaction> currentTransactions;
    LinkedList<Block> blockchain;
    
    public Blockchain() {
        currentTransactions = new LinkedList<Transaction>();
        blockchain = new LinkedList<Block>();
        
        blockchain.add( new Block(0, this.currentTransactions, Integer.toString(100), Integer.toString(1)) );

    }
    
    public Block addBlock(String proof, String hash) {
        Block newBlock = new Block(blockchain.size() + 1, this.currentTransactions, proof, hash);
        
        currentTransactions.clear();
        blockchain.add(newBlock);
        return newBlock;
    }
    
    public Block addBlock(String proof) throws NoSuchAlgorithmException {
        Block newBlock = new Block(blockchain.size() + 1, this.currentTransactions, proof, blockchain.get(blockchain.size() - 1).hash());

        currentTransactions.clear();
        blockchain.add(newBlock);
        return newBlock;
    }
}
