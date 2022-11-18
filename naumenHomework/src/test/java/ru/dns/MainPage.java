package ru.dns;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    private final static SelenideElement input = $(byXpath("(//input[@name='q'])[2]"));
    private final static SelenideElement button = $(byCssSelector(".ui-input-search__buttons:nth-child(3) > .ui-input-search__icon_search"));
    private final static SelenideElement basketItem = $(byCssSelector(".cart-link__badge"));
    private final static SelenideElement basket = $(byCssSelector(".cart-link__price"));

    /*
    Метод отвечает за открытие главной страницы
     */
    public MainPage(String url){
        Selenide.open(url);
    }

    /*
    Осуществляется поиск товара на главной страницы, после поиска переходит к методам на других страницах
     */
    public ListProductPage search(String searchProduct){
        input.setValue(searchProduct);
        button.click();
        return new ListProductPage();
    }

    /*
    *Смотрит есть ли товар в корзине
      */
    public boolean checkBasket(){
        return basketItem.isDisplayed();
    }
}
