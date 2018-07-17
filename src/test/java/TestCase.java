import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TestCase extends WebDriverTest {

    @Test()
    public void login() {


        driver.findElement(By.xpath("//span[@class='nav-line-3']")).click();
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ap_email\"]")));



        //driver.findElement(By.xpath("//div[@id='nav-signin-tooltip']//span[@class='nav-action-inner'][contains(text(),'Sign in')]")).click();
        driver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys("cegofose@dumoac.net");
        driver.findElement(By.id("continue")).click();

        driver.findElement(By.xpath("//*[@id=\"ap_password\"]")).sendKeys("123456");
        driver.findElement(By.id("signInSubmit")).click();


    }

    @AfterClass
    public static void doTest() throws InterruptedException {


                driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("samsung");
                driver.findElement(By.xpath("//input[@value='Go']")).click();

                String expectedMessage = driver.findElement(By.id("s-result-count")).getText();
                //System.out.println(expectedMessage);

                if(expectedMessage.contains("samsung"))
                {
                    System.out.println("samsung için sonuç bulundu.");
                }else{
                    System.out.println("samsung için sonuç bulunamadı.");
                }


                driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div[2]/div/div[5]/div/div/span[3]/a")).click();

                String page = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div[2]/div/div[5]/div/div/span[3]")).getText();
                //System.out.println(page);

                if(page.equals("2")){
                System.out.println("2. sayfa şuan gösterimde");
                Thread.sleep(1000);

                }else{
                System.out.println("2. sayfa gösterimde değil");
                driver.quit();
                }

                // Ustten 3. urun
                driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div[2]/div/div[4]/div[1]/div/ul/li[3]/div/div/div/div[2]/div[1]/div[1]/a/h2")).click();
                WebDriverWait wait = new WebDriverWait(driver, 2);
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"add-to-wishlist-button-submit\"]")));


                driver.findElement(By.xpath("//*[@id=\"add-to-wishlist-button\"]")).click();

                Thread.sleep(4000);

                WebDriverWait wait2 = new WebDriverWait(driver, 3);
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"atwl-list-name-1KUG92YHZORMK\"]")));

                driver.findElement(By.id("atwl-link-to-list-1KUG92YHZORMK")).click();
                Thread.sleep(4000);

                String expectedAddItem = driver.findElement(By.xpath("//*[@id=\"WLHUC_result_action_add\"]")).getText();
                //System.out.println(expectedAddItem);

                if(expectedAddItem.contains("added to"))
                {
                    System.out.println("Ürün eklenmiştir.");
                    driver.findElement(By.id("WLHUC_viewlist")).click();
                    Thread.sleep(1000);
                }
                else{
                    System.out.println("Ürün eklenemedi.");
                }


                //delete butonuna basıldı
                driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[1]/div/div/div/div[2]/div[4]/div[3]/div/ul/li[1]/span/div/div/div[2]/div[3]/div/div[2]/div/div/div[1]/div[2]/form/span/span/span/input")).click();
                Thread.sleep(3000);
                String deletedItem = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[1]/div/div/div/div[2]/div[4]/div[3]/div/ul/li[1]/span/div/div[2]/div/div/div")).getText();
                System.out.println(deletedItem);

                if (deletedItem.contains("Deleted")){
                    System.out.println("Ürün kaldırılmıştır.");
                }
                else{
                    System.out.println("Ürün kaldırılamamıştır.");
                }



    }

}
