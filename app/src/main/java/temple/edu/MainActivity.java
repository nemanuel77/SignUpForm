package temple.edu;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button myButton = findViewById(R.id.btnRegister);
        final TextView nameField = findViewById(R.id.txtName);
        final TextView emailField = findViewById((R.id.txtEmail));
        final TextView phoneField = findViewById(R.id.txtPhone);
        final TextView passField = findViewById(R.id.txtPassword);
        final TextView confirmPassField = findViewById(R.id.txtConfirmPassword);

        myButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String response = "";
                //int response = 0;
                String text = nameField.getText().toString();
                String email = emailField.getText().toString();
                String phone = phoneField.getText().toString();
                //int len = phone.length();
                String pass = passField.getText().toString();
                String confPass = confirmPassField.getText().toString();

                if (checkAllFields(text,email,phone,pass,confPass) == false){
                    response = "Please fill out all fields";
                    //int len = phone.length();

                }
                //dont forget the else
                else if (comparePasswords(pass,confPass) == false){
                    response = "passwords do not match.";
                }
                else{
                    response = "Welcome, " + text + " :)";
                }



                Toast toast = Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT);
                toast.show();
            }
        });

    }

    private Boolean checkAllFields(String t, String e, String p, String pass, String pass2){
        boolean flag = true;
        int len = p.length();
        Log.d("Length of phone", "is "+p.length());
        if (t.length() < 1 ){
            flag = false;
        }
        if (e.length() < 1 ){
            flag = false;
        }
        if (len != 10 ){
          flag = false;
        }
        if (pass.length() < 1){
            flag = false;
        }
        if (pass2.length() < 1){
            flag = false;
        }
        return flag;

    }

    private boolean comparePasswords(String pass1, String pass2){
        boolean flag = pass1.equals(pass2);

        return flag;

    }



}