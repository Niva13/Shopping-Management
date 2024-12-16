package com.example.shoppingmanagement.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.navigation.Navigation;

import com.example.shoppingmanagement.R;
import com.example.shoppingmanagement.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {


    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        mAuth = FirebaseAuth.getInstance();
    }

    public void register()
    {
        String email = (((EditText) findViewById(R.id.editTextTextEmailAddress)).getText().toString());
        String password = (((EditText) findViewById(R.id.PasswordinputReg)).getText().toString());

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>()
        {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            //writeData();

                            Toast.makeText(MainActivity.this, "reg OKK", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(MainActivity.this, "reg Fail", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }



    public void login(View view)
    {
        String email2 = (((EditText) findViewById(R.id.Emailinput)).getText().toString());
        String password = (((EditText) findViewById(R.id.Passwordinput)).getText().toString());

        mAuth.signInWithEmailAndPassword(email2, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Navigation.findNavController(view).navigate(R.id.action_login_to_after_login);
                            Toast.makeText(MainActivity.this, "Loging OK", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(MainActivity.this, "Login Fail", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

    public void writeData()
    {
        String phone,email;
        phone = ((EditText)findViewById(R.id.editTextPhone)).getText().toString();
        email = ((EditText)findViewById(R.id.editTextTextEmailAddress)).getText().toString();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("users").child(phone);

        //User user = new User(phone,email);

        //myRef.setValue(user);
    }

    /*public void readData()
    {
        // Read from the database
        /*myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value

            }
        });*/


}