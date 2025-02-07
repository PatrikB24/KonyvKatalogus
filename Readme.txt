# Könyvkatalógus Kezelő Rendszer

## Leírás
Ez az alkalmazás lehetőséget biztosít könyvek hozzáadására, törlésére, keresésére és adatbázisba mentésére.

## Fő funkciók
- Könyvek kezelése (hozzáadás, törlés, keresés, listázás)
- Fájlba mentés és betöltés
- Adatbázis kapcsolat MySQL-en keresztül
- JUnit tesztek a funkcionalitás ellenőrzésére

## Telepítés
1. **MySQL beállítása:**
   - Hozz létre egy `konyvkatalogus` adatbázist XAMPP segítségével.
   - Futtasd a `DatabaseHelper.createTable()` metódust az adatbázis létrehozásához.

2. **Futtatás:**
   - Nyisd meg a `Main.java` fájlt és futtasd az IntelliJ IDEA-ban.

3. **Tesztelés:**
   - A `BookCatalogTest.java` fájl futtatásával ellenőrizheted a teszteket.

## Használat
A konzolban elérhető funkciók:
1. Könyv hozzáadása
2. Könyv törlése
3. Könyvek listázása
4. Könyv keresése
5. Mentés fájlba
6. Betöltés fájlból
7. Mentés adatbázisba
8. Kilépés