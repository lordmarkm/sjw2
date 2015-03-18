package org.sjw.app;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.sjw.data.config.SjwDataConfig;
import org.sjw.data.model.Address;
import org.sjw.data.model.Employee;
import org.sjw.marklogic.client.JSONWriter;
import org.sjw.marklogic.client.XMLWriter;
import org.sjw.marklogic.config.SjwMarklogicConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.google.common.collect.ImmutableList;

public class TestApp {

    private static Random random = new Random();

    public static void main(String[] args) throws IOException {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(
                SjwMarklogicConfig.class,
                SjwDataConfig.class);

        XMLWriter xmlWriter = ctx.getBean(XMLWriter.class);
        JSONWriter jsonWriter = ctx.getBean(JSONWriter.class);

        Address addr = new Address();
        addr.setAddressLine1("Somewhere");
        addr.setAddressLine2("Over the rainbow");
        addr.setCity("Pasig city");
        addr.setZip(1605);

        int count = 10;
        while (count++ < 15) {
            Employee employee = new Employee();
            employee.setId(count);
            employee.setName(randomFirstName() + " " + randomLastName());
            employee.setRole("Driver");
            employee.setAddress(addr);
            //xmlWriter.writeObjectAsXml("employees/employee" + count, employee, "Employees");
            jsonWriter.writeObjectAsJson("employees/employee" + count, employee, "Employees");
        }
    }

    private static final List<String> firstNames = ImmutableList.of("Mark", "John", "Ringo", "Paul", "George", "Brian", "Freddie", "James", "Roger", "Pedro");
    private static final List<String> lastNames = ImmutableList.of("Martinez", "Lennon", "Starr", "McCartney", "Harrison", "May", "Boulsara", "Deacon", "Taylor", "Penduko");
    private static String randomFirstName() {
        return firstNames.get(random.nextInt(firstNames.size() - 1));
    }
    private static String randomLastName() {
        return lastNames.get(random.nextInt(lastNames.size() - 1));
    }
}
