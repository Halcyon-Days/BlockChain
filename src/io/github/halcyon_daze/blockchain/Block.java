package io.github.halcyon_daze.blockchain;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Base64;
import java.util.Calendar;
import java.util.LinkedList;
import javax.json.*;


public class Block {
    private final int index;
    private final String timestamp;
    private final LinkedList<Transaction> transactions;
    private final String proof;
    private final String previousHash;
    private final String blockstring;
    
    public Block(int index, LinkedList<Transaction> transactions, String proof, String hash) {
        this.index = index;
        this.timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        this.transactions = transactions;
        this.proof = proof;
        this.previousHash = hash;
        
        blockstring = Json.createObjectBuilder()
                            .add("index", this.index)
                            .add("timestamp", this.timestamp)
                            .add("transactions", Arrays.toString(this.transactions.toArray()))
                            .add("proof", this.proof)
                            .add("previous hash", this.previousHash)
                            .build()
                            .toString();
    }
    
    //reference to https://stackoverflow.com/questions/5531455/how-to-hash-some-string-with-sha256-in-java
    public String hash() throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(blockstring.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(hash);
    }

    @Override
    public String toString() {
        return new String(blockstring);
    }
}
