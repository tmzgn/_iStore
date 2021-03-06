package com.example.istore.Adapter.Admin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.istore.Model.CartModel;
import com.example.istore.Model.CheckoutModel;
import com.example.istore.R;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;


public class ViewOrderDetailAdapter extends FirestoreRecyclerAdapter<CartModel, ViewOrderDetailAdapter.OrderHolder> {

    final private Context context;
    int item_number_count = 1;
    public ViewOrderDetailAdapter(@NonNull FirestoreRecyclerOptions<CartModel> options, Context context) {

        super(options);
        this.context = context;


    }
    @NonNull
    @Override
    public OrderHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.manger_order_details_row, parent, false);
        return new OrderHolder(v);
    }
    @Override
    protected void onBindViewHolder(@NonNull OrderHolder holder, int position, @NonNull CartModel model) {
//        String order_id = model.getOrder_id();
        holder.odName.setText(model.getName());
        holder.odTotal.setText(model.getTotalQuantity());
        try {
            holder.odItemNumber.setText(String.valueOf(item_number_count));
            item_number_count++;
        } catch (Exception e) {
            e.printStackTrace();
        }
//        holder.odTime.setText(model.getDate()+" "+model.getTime());


//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(context, "Order ID: \n"+order_id, Toast.LENGTH_LONG).show();
//            }
//        });
    }
    class OrderHolder extends RecyclerView.ViewHolder {

        private TextView odName, odItemNumber , odTotal;

        public OrderHolder(@NonNull View itemView) {
            super(itemView);

            // ui init
            odItemNumber    = itemView.findViewById(R.id.item_number_tv);
            odName    = itemView.findViewById(R.id.od_product_name_id);
            odTotal   = itemView.findViewById(R.id.od_total_price);
//            odTime    = itemView.findViewById(R.id.od_order_time_insert);




        }
    }
}
