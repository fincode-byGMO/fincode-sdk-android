package jp.gmopg.japanpost.fincodesdk.entities;

import java.util.List;

/**
 * Created by m.ohkawa on 2022/06/06.
 */
public class CardListItem {

    private String cardNumber;
    private String expire;

    public CardListItem(String cardNumber, String expire) {
        this.cardNumber = cardNumber;
        this.expire = expire;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getExpire() {
        return expire;
    }

    public static class Builder {
        private String cardNumber;
        private String expire;

        public Builder(){
        }

        public void setCardNumber(String cardNumber) {
            this.cardNumber = cardNumber;
        }

        public void setExpire(String expire) {
            this.expire = expire;
        }

        public CardListItem build() {
            CardListItem cardListItem = new CardListItem(cardNumber, expire);

            cardListItem.cardNumber = cardNumber;
            cardListItem.expire = expire;
            return cardListItem;
        }
    }


}
