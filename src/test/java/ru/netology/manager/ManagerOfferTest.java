package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Offer;
import ru.netology.repository.RepositoryOffer;


class ManagerOfferTest {
    RepositoryOffer repository = new RepositoryOffer();
    ManagerOffer offer = new ManagerOffer(repository);

    Offer offer1 = new Offer(1, 400, "SVO", "MBA", 630);
    Offer offer2 = new Offer(2, 300, "SVO", "MBA", 730);
    Offer offer3 = new Offer(3, 200, "SVO", "SIP", 150);
    Offer offer4 = new Offer(4, 150, "SVO", "KVK", 130);

    @BeforeEach
    public void setUp() {
        offer.add(offer1);
        offer.add(offer2);
        offer.add(offer3);
        offer.add(offer4);
    }

    @Test
    void shouldFindAllAndSort() {
        Offer[] expected = {offer2, offer1};
        Offer[] actual = offer.findAll("SVO", "MBA");
        Assertions.assertArrayEquals(expected, actual);
    }

}