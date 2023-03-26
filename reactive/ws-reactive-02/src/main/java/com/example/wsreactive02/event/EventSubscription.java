package com.example.wsreactive02.event;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class EventSubscription {

    private Set<String> subscriptions = new HashSet<>();

    public void addSubscription(String identifier) {
        subscriptions.add(identifier);
    }

    public void removeSubscription(String identifier) {
        subscriptions.remove(identifier);
    }

    public Set<String> getSubscriptions() {
        return subscriptions;
    }

    public boolean hasSubscription(String identifier) {
        return subscriptions.contains(identifier);
    }

    public String getSubscription() {
        return subscriptions.stream().findFirst().orElse(null);
    }
}
