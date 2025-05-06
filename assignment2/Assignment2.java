package com.mycompany.assignment2;

import java.util.ArrayList;

public class Assignment2 {
    public static ArrayList<Block> blockchain = new ArrayList<>();
    public static int difficulty = 4;

    public static void main(String[] args) {
        System.out.println("Starting the blockchain demo...\n");

        blockchain.add(new Block("First Block (Genesis)", "0"));
        blockchain.get(0).mineBlock(difficulty);

        blockchain.add(new Block("Second Block", blockchain.get(blockchain.size() - 1).hash));
        blockchain.get(1).mineBlock(difficulty);

        blockchain.add(new Block("Third Block", blockchain.get(blockchain.size() - 1).hash));
        blockchain.get(2).mineBlock(difficulty);

        System.out.println("\nBlockchain is valid: " + isChainValid());

        for (Block block : blockchain) {
            System.out.println("\nBlock:");
            System.out.println("Hash: " + block.hash);
            System.out.println("Previous Hash: " + block.previousHash);
            System.out.println("Data: " + block.getData());
        }
    }

    public static boolean isChainValid() {
        for (int i = 1; i < blockchain.size(); i++) {
            Block currentBlock = blockchain.get(i);
            Block previousBlock = blockchain.get(i - 1);

            if (!currentBlock.hash.equals(currentBlock.calculateHash())) {
                return false;
            }

            if (!currentBlock.previousHash.equals(previousBlock.hash)) {
                return false;
            }
        }
        return true;
    }
}
