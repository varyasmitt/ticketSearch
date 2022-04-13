package ru.netology.manager;

import ru.netology.domain.Offer;
import ru.netology.repository.RepositoryOffer;

import java.util.Arrays;

public class ManagerOffer {
    private RepositoryOffer repositoryOffer;

    public ManagerOffer(RepositoryOffer repositoryOffer) {
        this.repositoryOffer = repositoryOffer;
    }

    public void add(Offer offer) {
        repositoryOffer.add(offer);
    }

    public Offer[] findAll(String from, String to) {
        Offer[] result = new Offer[0];
        for (Offer ticket : repositoryOffer.getAll()) {
            if (ticket.getFrom().equals(from) && ticket.getTo().equals(to)) {
                Offer[] tmp = new Offer[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

}
