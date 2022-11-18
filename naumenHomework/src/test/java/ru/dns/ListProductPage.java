package ru.dns;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class ListProductPage {
    private final SelenideElement buttonBuy = $(byCssSelector(".catalog-product:nth-child(1) .buy-btn"));
    private final SelenideElement title = $(byXpath("//div[@id='cart-page-new']/div[2]/div/div/h1"));
    private final SelenideElement basket = $(byCssSelector(".cart-link__lbl"));
    /*
    1.Добавляет товар в корзину
    2.Ждет изменения кнопки добавления
    3.После изменения переходит в корзину
    4.После загрузки страницы корзины переходит к методу на след. странице
    */
    public String buyElement(){
        buttonBuy.click();
        $(buttonBuy).shouldHave(Condition.exactText("В корзине"));
        buttonBuy.click();
        $(title).shouldBe(Condition.visible);
        return new BasketPage().getItems();

    }

    /*
   1.Добавляет товар в корзину
   2.Ждет изменения кнопки добавления
   3.После изменения переходит в корзину
   4.После загрузки страницы корзины переходит к методу на след. странице
   */
    public Boolean addProduct(){
        buttonBuy.click();
        $(buttonBuy).shouldHave(Condition.exactText("В корзине"));
        basket.click();
        $(title).shouldBe(Condition.visible);
        return new BasketPage().deleteProduct();
    }
}
