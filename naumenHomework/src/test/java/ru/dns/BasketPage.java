package ru.dns;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.$;

public class BasketPage {
    private final SelenideElement finalItem = $(byCssSelector(".summary-header__total-items"));
    private final SelenideElement oneProductDelete = $(byCssSelector(".remove-button__title"));
    private final SelenideElement massProductDelete = $(byCssSelector(".mass-selection__delete-btn"));
    private final SelenideElement productDeleteTitle = $(byCssSelector(".empty-message__title-empty-cart"));

    /*
    Метод вычисляет количество товаров в итоге
     */
    public String getItems(){
        return String.valueOf(finalItem.text().charAt(0));
    }

    /*
    Метод удаляет товар из корзины в зависимости от колиечства товара в корзине
     */
    public Boolean deleteProduct(){
        Integer basketItem = Integer.parseInt(getItems());
        if (basketItem==1){
            oneProductDelete.click();
        }
        else {
            massProductDelete.click();
        }
        $(productDeleteTitle).shouldBe(Condition.visible);
        return productDeleteTitle.isDisplayed();
    }

}
