package SeleniumTests;

import org.junit.Assert;
import org.junit.Test;

public class Task19_MultilayerArchitecture extends BaseTests{
    @Test
    public void addToCartDeleteFromCartTest()
    {
        liteCartShop.addDuckFromProductBlockToCart();
        Assert.assertTrue(liteCartShop.checkIncreasingDucksInCart());

        liteCartShop.addDuckFromPopularBlockToCart();
        Assert.assertTrue(liteCartShop.checkIncreasingDucksInCart());

        liteCartShop.addDuckFromLatestBlockToCart();
        Assert.assertTrue(liteCartShop.checkIncreasingDucksInCart());

        liteCartShop.goToCart();
        for (int i = 0; i < liteCartShop.getNumberOfDuckKind() - 1; i++)
        {
            Assert.assertTrue(liteCartShop.deleteOneKindDuck());
            Assert.assertTrue(liteCartShop.deleteLastKindDuck());
        }
    }
}
