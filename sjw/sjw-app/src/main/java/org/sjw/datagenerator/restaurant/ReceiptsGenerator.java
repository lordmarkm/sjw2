package org.sjw.datagenerator.restaurant;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.Days;
import org.joda.time.LocalDateTime;
import org.sjw.data.config.SjwDataConfig;
import org.sjw.data.model.restaurant.MenuItem;
import org.sjw.data.model.restaurant.OrderItem;
import org.sjw.data.model.restaurant.Receipt;
import org.sjw.data.model.restaurant.RestaurantBranch;
import org.sjw.marklogic.client.XMLWriter;
import org.sjw.marklogic.config.SjwMarklogicConfig;
import org.sjw.reference.Weather;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.google.common.collect.Lists;

/**
 * Generate
 * 1. Between 4 - 10 receipts per day from start date to end date
 * 2. Between 2 - 5 dishes per receipt
 * 2. All orders made at random time of day between 10 am and 5pm
 * 3. Branch randomly selected
 * @author mbmartinez
 */
public class ReceiptsGenerator {

    private static Random rngsus = new Random();

    public static void main(String[] args) throws IOException {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(
                SjwMarklogicConfig.class,
                SjwDataConfig.class);

        XMLWriter xmlWriter = ctx.getBean(XMLWriter.class);

        Long id = 1l;
        LocalDateTime startDate = LocalDateTime.parse("2015-01-01");
        LocalDateTime endDate = LocalDateTime.parse("2015-12-31");

        LocalDateTime date = startDate;
        int maxDayCount = rngsus.nextInt(7) + 9; //4-10 receipts per day
        int dayCount = 0;
        Weather weather = null;
        List<Receipt> receipts = Lists.newArrayList();
        while (!date.equals(endDate) || dayCount != maxDayCount) {

            if (0 == dayCount) {
                weather = Weather.random(date.getMonthOfYear());
                if (weather == Weather.Typhoon) {
                    maxDayCount -= 3;
                } else if (weather == Weather.Rainy || weather == Weather.Cold) {
                    maxDayCount -= 1;
                }
            }

            Receipt receipt = new Receipt();
            receipt.setId(id++);
            receipt.setOrderDate(date.plusHours(rngsus.nextInt(8) + 10).plusMinutes(rngsus.nextInt(60)).toDate());
            receipt.setWeather(weather);
            receipt.setOrderItems(getRandomOrderItems(String.valueOf(receipt.getId()), receipt.getOrderDate().getHours(), date.getMonthOfYear(), receipt.getWeather()));
            receipt.setRestaurantCode(getRandomRestaurantCode());
            applySeniorDiscount(receipt);
            receipts.add(receipt);

            if (dayCount == maxDayCount) {
                date = date.plusDays(1);
                maxDayCount = rngsus.nextInt(7) + 4;
                System.out.println("Generated " + dayCount + " receipts for the date " + date);
                dayCount = 0;
            } else {
                dayCount++;
            }
        }

        System.out.println("Generated " + receipts.size() + " receipts over " + Days.daysBetween(startDate, endDate).getDays() + " days");
        boolean write = true;
        if (write) {
            for (Receipt receipt : receipts) {
                xmlWriter.writeObjectAsXml("receipts/receipt" + StringUtils.leftPad(String.valueOf(receipt.getId()), 4, "0"),
                        receipt, "Receipts");
            }
            for (Receipt receipt : receipts) {
                for (OrderItem order : receipt.getOrderItems()) {
                    xmlWriter.writeObjectAsXml("orders/order" + StringUtils.leftPad(String.valueOf(order.getOrderId()), 4, "0"),
                            order, "Orders");
                }
            }
        } else {
            for (Receipt receipt : receipts) {
                System.out.println(xmlWriter.previewObjectAsXml(receipt));
            }
        }
    }

    private static void applySeniorDiscount(Receipt receipt) {
        boolean isSenior = rngsus.nextInt(5) == 4;
        if (!isSenior) {
            return;
        }

        Double totalAmount = 0d;
        for (OrderItem orderItem : receipt.getOrderItems()) {
            totalAmount += orderItem.getItem().getPrice() * orderItem.getQuantity();
        }

        receipt.setSeniorDiscount(new BigDecimal(totalAmount * 0.2d).setScale(2, RoundingMode.HALF_UP).doubleValue());
    }

    private static final List<RestaurantBranch> branches = RestaurantBranchApp.getBranches();
    private static String getRandomRestaurantCode() {
        return branches.get(rngsus.nextInt(branches.size())).getCode();
    }

    private static long orderId = 0l;
    private static List<OrderItem> getRandomOrderItems(String receiptNo, int hourOfDay, int monthOfYear, Weather weather) {

        //if it's 11 am to 1 pm people order 4-8 dishes
        int dishCount;
        switch(hourOfDay) {
        case 11: case 12: case 13:
            dishCount = rngsus.nextInt(5) + 4;
            break;
        default:
            dishCount = rngsus.nextInt(3) + 2; //2-5 dishes per receipt
        }

        //if it's march or december people order 1.5x as many dishes
        if (monthOfYear == 3 || monthOfYear == 12) {
            dishCount = (int)(dishCount * 1.5);
        }

        Set<MenuItem> menuItems = MenuItem.random(dishCount, weather);
        List<OrderItem> orderItems = Lists.newArrayList();
        for (MenuItem menuItem : menuItems) {
            OrderItem oi = new OrderItem(menuItem, Double.valueOf(rngsus.nextInt(4) + 1)); //1-4 orders per dish
            oi.setOrderId(++orderId);
            oi.setReceiptNo(receiptNo);
            orderItems.add(oi);
        }

        OrderItem rice = new OrderItem(MenuItem.getRice(), Double.valueOf(orderItems.size()));
        rice.setOrderId(++orderId);
        rice.setReceiptNo(receiptNo);
        orderItems.add(rice);

        return orderItems;
    }
}
