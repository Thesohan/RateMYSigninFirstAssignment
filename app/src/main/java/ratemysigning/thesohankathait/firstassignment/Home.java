package ratemysigning.thesohankathait.firstassignment;

import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Home extends AppCompatActivity {

    RecyclerView recyclerView;
    Button addDataButton;
    FirebaseRecyclerAdapter<User,MyViewHolder> firebaseRecyclerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        recyclerView=findViewById(R.id.recyclerView);
        addDataButton=findViewById(R.id.addDataButton);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        addDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                View view=LayoutInflater.from(Home.this).inflate(R.layout.adduser,null,false);
                final EditText name,age;
                name=view.findViewById(R.id.nameEdittext);
                age=view.findViewById(R.id.ageEdittext);
                android.app.AlertDialog.Builder builder=new android.app.AlertDialog.Builder(Home.this);
                builder.setMessage("Add New User")
                        .setTitle("User")
                        .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                addUser(name.getText().toString(),age.getText().toString());// Upload.spinnerArrayAdapter.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("Back", null)
                        .setView(view)
                        .setCancelable(false)
                        .show();

            }
        });

       getData();

    }

    private void addUser(String name, String age) {

        if(!name.trim().equals("") && !age.trim().equals("")){
            User user=new User(name,age);
            FirebaseDatabase.getInstance().getReference("User").push().setValue(user);
        }
        else{
            Toast.makeText(this, "Fill the input correctly!", Toast.LENGTH_SHORT).show();
        }
    }

    private void getData() {
       firebaseRecyclerAdapter=new FirebaseRecyclerAdapter<User, MyViewHolder>(User.class,R.layout.row,MyViewHolder.class,FirebaseDatabase.getInstance().getReference("User")) {
           @Override
           protected void populateViewHolder(MyViewHolder viewHolder, User model, int position) {
               viewHolder.nameTextView.setText(model.getName());
               viewHolder.ageTextView.setText(model.getAge());

           }
       } ;
        recyclerView.setAdapter(firebaseRecyclerAdapter);

    }
}
