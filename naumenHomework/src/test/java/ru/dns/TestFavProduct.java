package ru.dns;

import org.junit.Assert;
import org.junit.Test;

public class TestFavProduct {
    private final static String url="https://www.dns-shop.ru/";
    private final static String text = "Ноутбук";
    private final static String resItem = "1";

    /*
    Тест на проверку добваления товара, смотрит количество товара в итоге в корзине
     */
    @Test
    public void testBuyProduct(){
       String item = new MainPage(url).search(text).buyElement();
       String msg = String.format("Получили: %s.Ожидалось: %s",item, resItem);
       Assert.assertTrue(msg, item.equals(resItem));
    }

    /*
        Тест на проверку наличия товара в корзине
         */
    @Test
    public void testEmptyBasket(){
        Boolean res = new MainPage(url).checkBasket();
        String msg = String.format("В корзине есть товары");
        Assert.assertFalse(msg,res);
    }

    /*
    Тест на проверку удаления товара,сначала товар добавляется, а потом удаляется
     */
    @Test
    public void testDeleteProduct(){
        Boolean res = new  MainPage(url).search(text).addProduct();
        String msg = "Все окей, товары удалились";
        Assert.assertTrue(msg,res);
    }
}
