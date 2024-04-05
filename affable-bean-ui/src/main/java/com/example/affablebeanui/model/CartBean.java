package com.example.affablebeanui.model;

import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class CartBean {
    public Set<CartItem> getCarts() {
        return carts;
    }

    private Set<CartItem> carts = new HashSet<>();

    public void setCarts(Set<CartItem> carts) {
        this.carts = carts;
    }

    public void clearCart() {
        this.carts.clear();
    }

   public void removeCartItem(int id) {
       this.carts = carts.stream()
               .filter(c -> c.getId() != id)
               .collect(Collectors.toSet());
   }
   public int cartSize() {
       return carts.size();
   }
   public Set<CartItem> getCartItems() {
       return this.carts;
   }
   public void addToCart(CartItem cartItem) {
       this.carts.add(cartItem);
   }
}
