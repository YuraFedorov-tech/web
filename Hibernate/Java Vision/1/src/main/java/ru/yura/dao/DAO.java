package ru.yura.dao;

/*
 *
 *@Data 20.01.2020
 *@autor Fedorov Yuri
 *@project Hibernate example
 *
 */
public interface DAO <Enetity, Key> {
    void create(Enetity enetity);
    Enetity read(Key key);
    void update(Enetity enetity);
    void delete (Enetity enetity);
}
