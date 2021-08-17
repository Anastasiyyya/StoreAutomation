package pages;

import page_elements.Button;
import page_elements.Input;
import page_objects.Account;

public class PersonalInfoPage extends MyAccountPage {

    public PersonalInfoPage replaceDataAndSave(Account account) {
        new Input("First name").replaceFieldTextTo(account.getFirstName() + "UPDATE");
        new Input("Last name").replaceFieldTextTo(account.getLastName() + "UPDATE");
        new Input("Password").enterTextToField(account.getPassword());
        new Button("Save").click();
        return this;
    }

    /*public String getChangedMessageText(){
        return $().getText();
    }*/
}
