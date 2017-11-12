package io.github.halcyon_daze.blockchain;

import javax.json.Json;

public class Transaction {
    private final String sender;
    private final String recipient;
    private final int amount;
    
    public Transaction(String sender, String recipient, int amount) {
        this.sender = sender;
        this.recipient = recipient;
        this.amount = amount;
    }
    
    @Override
    public String toString() {
        return Json.createObjectBuilder()
                   .add("sender", sender)
                   .add("recipient", recipient)
                   .add("amount", amount)
                   .build()
                   .toString();
    }
}
