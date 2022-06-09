package jp.gmopg.japanpost.fincodesdk.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by m.ohkawa on 2022/06/08.
 */
public class CardList {

    private List<CardListItem> cardLists;

    public List<CardListItem> getCardLists() {
        return cardLists;
    }

    public static class Builder {
        private List<CardListItem> cardLists = new ArrayList<>();

        public void setCardLists(CardListItem cardListItem) {
            cardLists.add(cardListItem);
        }

        public List<CardListItem> build() {
            CardList cardList = new CardList();
            cardList.cardLists = cardLists;

            return cardLists;
        }
    }
}
