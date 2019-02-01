package ratemysigning.thesohankathait.firstassignment;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class MyViewHolder extends RecyclerView.ViewHolder {
    public TextView nameTextView,ageTextView;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        nameTextView=itemView.findViewById(R.id.nameTextView);
        ageTextView=itemView.findViewById(R.id.ageTextView);
    }
}
