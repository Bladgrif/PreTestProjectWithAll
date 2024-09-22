package tests.resstassured;

import helpers.CompanyUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import model.Company;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

import static helpers.CompanyGenerator.generateCompany;
import static helpers.CompanyUtils.createCompany;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.assertj.core.api.Assertions.assertThat;


public class RestAssuredTest extends  BaseTest{


    @Test
    @DisplayName("Verify that the list of companies is not empty.")
    @Description("Verify that the list of companies is not empty.")
    @Feature("Get Companies API")
    @Tag("API")
    void testGetCompanies() {
        List<Company> companies = CompanyUtils.getCompanies();
        assertThat(companies).isNotEmpty();
    }

    @Test
    @DisplayName("Verify that the list of companies is not empty.")
    @Description("Verify that a company can be fetched by its ID.")
    @Feature("Get Company by ID API")
    @Tag("API")
    void testGetCompanyById() {
        Integer companyId = createCompany(generateCompany());
        Company company = CompanyUtils.getCompany(companyId);
        assertThat(company).isNotNull();
    }
}
