/*
import android.widget.Toast;

public class SaveToDB {
    static private void savePatient() {
        //Getting name from editText
        String name = editTextInventoryName.getText().toString().trim();

        //Checking if name is blank
        if (name.equalsIgnoreCase("")) {
            Toast.makeText(this, "Please enter a name", Toast.LENGTH_LONG).show();
            return;
        }

        //If name is not blank creating a new Inventory object
        Inventory inventory = new Inventory();
        //Adding the given name to inventory name
        inventory.name = name;
        //Saving name to sqlite database
        inventory.save();

        //Displaying a toast message for successfull insertion
        Toast.makeText(this, "Inventory Saved Successfully", Toast.LENGTH_LONG).show();
    }
}
*/
