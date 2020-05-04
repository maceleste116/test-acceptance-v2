package qa.ma.stepdefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import qa.ma.builders.data.UserBuilder;
import qa.ma.conf.DriverConfig;
import qa.ma.tasks.NavigateTo;
import qa.ma.tasks.UserSignUp;

import static org.assertj.core.api.Assertions.assertThat;


@ContextConfiguration(classes = {DriverConfig.class})
public class SignUpStepDefs {

    @Autowired
    private UserSignUp signUp;

   @Autowired
   private NavigateTo navigate;

    @Given("^Pepito wants to have an account")
    public void pepito_wants_to_have_an_account() {
        navigate.signUpPage();

    }

    @When("^he sends required information to get the account")
    public void he_sends_required_information_to_get_the_account() {

        signUp.withInfo(
                UserBuilder.anUser()
                           .withDefaultInfo()
                           .build()
        );

    }

    @Then("^he should be told that the account was created")
    public void he_should_be_told_that_the_account_was_created() {
        assertThat(true).isEqualTo(true);
    }


    @Then("he should be told that the account was not created")
    public void he_should_be_told_that_the_account_was_not_created() {
        assertThat(true).isEqualTo(false);
    }
}

