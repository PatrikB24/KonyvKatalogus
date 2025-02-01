package org.example;

public interface CatalogItem {
    String getItemInfo();
    boolean matches(String keyword);
}