package helpers;

import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.Company;
import model.CreateCompany;

import java.util.List;

import static config.Endpoints.COMPANY;
import static io.restassured.RestAssured.given;
import static tests.resstassured.BaseTest.TOKEN;

public class CompanyUtils {

    static String xClient = "X-Client-Token";

    public static List<Company> getCompanies() {
        return getCompanies(null);
    }
    private  static List<Company> getCompanies(Boolean active) {
        try {
            String address = "";
            if (active != null) {
                address = "?active=" + active;
            }
            Response response = given()
                    .when()
                    .get(COMPANY.getPath() + address)
                    .then()
                    .statusCode(200)
                    .extract().response();

            return response.jsonPath().getList("", Company.class); //todo парсинг коллекции в Лист
//            return response.as(Company.class);  // Преобразуем JSON в объект Company

        } catch (Exception e) {
            System.out.println("Error when calling getCompanies method" + e.getMessage());
            return null;
        }

    }

    public static Integer createCompany(CreateCompany createCompany) {
        try {
            int companyId = given()
                    .contentType(ContentType.JSON)
                    .body(createCompany)
                    .header(xClient, TOKEN)
                    .when()
                    .post(COMPANY.getPath())
                    .then()
                    .statusCode(201)
                    .extract().path("id");
            return companyId;
        } catch (Exception e) {
            System.out.println("Error when calling addCompany method" + e.getMessage());
            return null;
        }
    }

    public static Company getCompany(Integer id) {
        try {
            Company company = given()
                    .contentType(ContentType.JSON)
                    .header(xClient, TOKEN)
                    .when()
                    .get(COMPANY.getPath() + "/" + id)
                    .then()
                    .statusCode(200)
                    .extract().body().as(Company.class);
            return company;
        } catch (Exception e) {
            System.out.println("Ошибка при вызове метода getCompanyById" + e.getMessage());
            return null;
        }
    }
}
