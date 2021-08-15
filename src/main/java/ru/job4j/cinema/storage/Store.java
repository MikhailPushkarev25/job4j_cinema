package ru.job4j.cinema.storage;

import ru.job4j.cinema.model.Account;
import ru.job4j.cinema.model.Ticket;

import java.util.Collection;

public interface Store {

    Collection<Ticket> findAllTickets();

    int createAccount(Account account);

    boolean createTicket(Ticket ticket);

    Account findAccountById(int id);

    Ticket findTicketById(int id);
}
