package com.example.abc123.lotuslive;

import android.app.Dialog;
import android.content.EntityIterator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public EditText contactNumber,nameD,lastNameD,emailD,contactD,addressD;
    Dialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contactNumber=(EditText)findViewById(R.id.contactNo);
        Button btn=(Button)findViewById(R.id.testBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String test=contactNumber.getText().toString();

                if(test.equals("1"))
                {
                    Bundle b = new Bundle();
                    b.putString("name","Lalit");
                    b.putString("email","lalitlkushwah@gmail.com");
                    b.putString("age","21");
                    b.putString("address","Indore");
                    b.putString("lastName","kushwah");
                    Intent i  =new Intent(MainActivity.this,CustomerDetails.class);
                    i.putExtras(b);
                    startActivity(i);
                }
                else{

                        dialog=new Dialog(MainActivity.this);
                        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                        dialog.setContentView(R.layout.dialog_items);
                        dialog.getWindow().setLayout(800,625);
                        dialog.show();

                        nameD=(EditText)dialog.findViewById(R.id.editText);
                        lastNameD=(EditText)dialog.findViewById(R.id.editText2);
                        contactD=(EditText)dialog.findViewById(R.id.number);
                        emailD=(EditText)dialog.findViewById(R.id.email);
                        addressD=(EditText)dialog.findViewById(R.id.address);


                     Button btn=(Button)dialog.findViewById(R.id.createCustomerBtn);
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Intent i = new Intent(MainActivity.this, CustomerDetails.class);
                            Bundle bundle = new Bundle();
                            if (!nameD.getText().toString().equals("")) {
                                bundle.putString("name", nameD.getText().toString());
                                bundle.putString("lastName", lastNameD.getText().toString());
                                bundle.putString("email", emailD.getText().toString());
                                bundle.putString("contact", contactD.getText().toString());
                                bundle.putString("address", addressD.getText().toString());
                                i.putExtras(bundle);
                                startActivity(i);
                            }
                            else {
                                Toast.makeText(getApplicationContext(),"Please Enter Name",Toast.LENGTH_LONG).show();
                            }
                        }
                    });




                }
            }
        });




    }
}
