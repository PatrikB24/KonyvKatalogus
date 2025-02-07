package org.example;
/**
 * A  CatalogItem interfész definiálja azokat a műveleteket, amelyeket minden katalógus elemnek implementálnia kell.
 */
public interface CatalogItem {
    String getItemInfo();
    boolean matches(String keyword);
}